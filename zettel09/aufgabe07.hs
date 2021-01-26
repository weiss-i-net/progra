data Optional a = Empty
                | Present a
                deriving Show

data Product = Article String Int
             deriving Show

--a
mapOptional :: (a -> b) -> Optional a -> Optional b
mapOptional f (Present a) = Present (f a) 
mapOptional _ Empty = Empty

--b
filterOptional :: (a -> Bool) -> Optional a -> Optional a
filterOptional _ Empty = Empty
filterOptional f (Present a)
    | f a       = Present a
    | otherwise = Empty

--c
foldOptional :: (a -> b) -> b -> Optional a -> b
foldOptional f _ (Present t) = f t
foldOptional f b _ = b

--d
isHumanEatable :: Product -> Bool
isHumanEatable (Article "Dog Food" _) = False
isHumanEatable _                      = True

adjustPrice :: Product -> Product
adjustPrice (Article s p)
    | p < 1000  = (Article s (p*2))
    | otherwise = (Article s p)

stringify :: Product -> String
stringify (Article s p) = "The article named '" ++ s ++ "' costs " ++ show p ++ " Cent."

--e
filterHumanEatable :: Product -> Optional Product
filterHumanEatable a = filterOptional isHumanEatable (Present a)

adjustPrice0 :: Optional Product -> Optional Product
adjustPrice0 a = mapOptional adjustPrice a

stringify0 :: Optional Product -> String
stringify0 a = foldOptional stringify "This article is unavailable." a

toPriceTag :: Product -> String
toPriceTag a = stringify0 (adjustPrice0 (filterHumanEatable a))
