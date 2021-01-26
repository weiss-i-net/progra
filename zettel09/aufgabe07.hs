data Optional a = Empty
                | Present a
                deriving Show

data Product = Article String Int
             deriving Show

mapOptional :: (a -> b) -> Optional a -> Optional b
mapOptional _ Empty = Empty
mapOptional f (Present x) = Present (f x)

filterOptional :: (a -> Bool) -> Optional a -> Optional a
filterOptional _ Empty = Empty
filterOptional keep (Present x)
    | keep x    = Present x
    | otherwise = Empty

foldOptional :: (a -> b) -> b -> Optional a -> b
foldOptional _ alt Empty     = alt
foldOptional f _ (Present x) = f x

isHumanEatable :: Product -> Bool
isHumanEatable (Article str _) = str /= "Dog Food"

adjustPrice :: Product -> Product
adjustPrice (Article str cents)
    | cents < 1000  = Article str (2*cents)
    | otherwise     = Article str cents

stringify :: Product -> String
stringify (Article str cents) = "The article named '" ++ str ++ "' costs " ++ (show cents) ++ " Cent."

filterHumanEatable :: Product -> Optional Product
filterHumanEatable p = filterOptional isHumanEatable (Present p)

adjustPriceO :: Optional Product -> Optional Product
adjustPriceO op = mapOptional adjustPrice op

stringifyO :: Optional Product -> String
stringifyO op = foldOptional stringify "This article is unavailable." op

toPriceTag :: Product -> String
toPriceTag p = stringifyO (adjustPriceO (filterHumanEatable p))
