--a
isMatrix :: [[Int]] -> Bool
isMatrix (x : xs : xss) = length x == length xs && isMatrix (xs : xss)
isMatrix _ = True
--b
dimensions :: [[Int]] -> (Int, Int)
dimensions matrix | isMatrix matrix = (countrows matrix, countcol matrix )
             | otherwise = (1, -1)
               where countrows x = length x
                     countcol x = length (x !! 0)
--c
isQuadratic :: [[Int]] -> Bool
isQuadratic matrix | isMatrix matrix && length matrix == length (matrix !! 0)  = True
                   | otherwise = False
--d
getRow :: [[Int]] -> Int -> [Int]
getRow matrix i | isMatrix matrix = matrix !! i 
                | otherwise = []

getCol :: [[Int]] -> Int -> [Int]
getCol matrix i | isMatrix matrix = generateCol matrix i 
                | otherwise = []
                where
                      generateCol :: [[Int]] -> Int -> [Int]
                      generateCol (x : xs) i =  ((x !! i) : ((generateCol xs i) ++ []))
                      generateCol _ _ = []
                      
--e
trav :: [[Int]] -> [[Int]]
trav (x: xs: xss) |isMatrix (x:xs:xss) = getCol (x : xs : xss) (length ( (x : xs : xss)!! 0 )) ++ []
trav matrix =  [[]]


