-- b

prime :: Int -> Bool
prime n = primeHelp n (n - 1)
    where primeHelp :: Int -> Int -> Bool
          primeHelp _ 1 = True
          primeHelp n t = rem n t /= 0 && primeHelp n (t - 1)

powersOfTwo :: Int -> Int -> [Int]
powersOfTwo i0 i1
    | i0 > i1   = []
    | otherwise = 2^i0 : powersOfTwo (i0 + 1) i1

intersection :: [Int] -> [Int] -> [Int]
intersection [] _ = []
intersection _ [] = []
intersection (x : xs) ys
    | contains ys x = x : intersection xs ys
    | otherwise     = intersection xs ys
    where contains :: [Int] -> Int -> Bool
          contains [] _ = False
          contains (x : xs) y
              | x == y    = True
              | otherwise = contains xs y

selectKsmallest :: Int -> [Int] -> Int
selectKsmallest k xs = length (smallestList k xs)
    where smallestList :: Int -> [Int] -> [Int]
          smallestList _ []       = []
          smallestList k (x : xs)
              | x <= k    = x : smallestList k xs
              | otherwise = smallestList k xs

