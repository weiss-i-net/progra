isMatrix :: [[Int]] -> Bool
isMatrix (x : y : zs) = length x == length y && isMatrix (y : zs)
isMatrix _            = True

dimensions :: [[Int]] -> (Int, Int)
dimensions xs
    | isMatrix xs = (length xs, length (xs !! 0))
    | otherwise   = (-1, -1)

isQuadratic :: [[Int]] -> Bool
isQuadratic xs = rows == cols && rows >= 0
                 where (rows, cols) = dimensions xs

getRow :: [[Int]] -> Int -> [Int]
getRow xs i
    | isMatrix xs = xs !! i
    | otherwise   = []

getCol :: [[Int]] -> Int -> [Int]
getCol xs i
    | isMatrix xs = cols xs i
    | otherwise   = []
    where cols :: [[Int]] -> Int -> [Int]
          cols (y : ys) t = y !! t : cols ys t
          cols _ _        = []

trav :: [[Int]] -> [[Int]]
trav xs = [getCol xs i | i <- [0..length (xs !! 0) - 1]] -- TODO replace list comprehention


setEntry :: [[Int]] -> Int -> Int -> Int -> [[Int]]
setEntry matrix i j aij
    | not (isMatrix matrix)          = error "First argument is not a matrix!"
    | i >= rowCount || j >= colCount = error "Index outside of the dimensions of the matrix!"
    | otherwise                      =    getRows 0 (i-1)
                                       ++ [newRow]
                                       ++ getRows (i+1) (rowCount - 1)

    where (rowCount, colCount) = dimensions matrix

          getRows :: Int -> Int -> [[Int]]
          getRows start stop
              | start > stop  = []
              | otherwise = matrix !! start : getRows (start+1) stop

          newRow :: [Int]
          newRow = getElems 0 (j-1)  ++  [aij]  ++  getElems (j+1) (colCount - 1)
                   where getElems :: Int -> Int -> [Int]
                         getElems start stop
                             | start > stop = []
                             | otherwise = matrix !! i !! start : getElems (start+1) stop

