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
          newRow               = getElems 0 (j-1)  ++  [aij]  ++  getElems (j+1) (colCount - 1)

          getRows :: Int -> Int -> [[Int]]
          getRows start stop
              | start > stop  = []
              | otherwise     = matrix !! start : getRows (start+1) stop

          getElems :: Int -> Int -> [Int]
          getElems start stop
              | start > stop = []
              | otherwise    = matrix !! i !! start : getElems (start+1) stop


-- addiert 2 Matrizen elementenweise und gibt das Ergebnis zurück
add :: [[Int]] -> [[Int]] -> [[Int]]
add matrixA matrixB
    | colsA /= colsB  || rowsA /= rowsB || colsA == -1 = error "Dimension mismatch"
    | otherwise = addRows 0
    where (rowsA, colsA) = dimensions matrixA
          (rowsB, colsB) = dimensions matrixB

          addRows :: Int -> [[Int]]
          addRows i
              | i > rowsA - 1 = []
              | otherwise = addElems i 0 : addRows (i + 1)

          addElems :: Int -> Int -> [Int]
          addElems currRow i
              | i > colsA - 1 = []
              | otherwise = matrixA !! currRow !! i + matrixB !! currRow !! i : addElems currRow (i+1)


-- test matrizen
a :: [[Int]]
a = [[1,2],
     [3,4]]

a' :: [[Int]]
a' = [[1,0],
      [0,0]]

b :: [[Int]]
b = [[1,2,3],
     [4,5,6]]

b' :: [[Int]]
b' = [[-1,-2,-3],
      [-4,-5,-6]]

c :: [[Int]]
c = [[1,0,0],
     [0,1,0],
     [0,0,1]]

