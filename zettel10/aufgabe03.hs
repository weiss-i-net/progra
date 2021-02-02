from :: Int -> [Int]
from x = x: from (x+1)

drop_mult :: Int -> [Int] -> [Int]
drop_mult x xs = filter (\y -> mod y x /= 0) xs

dropall :: [Int] -> [Int]
dropall (x:xs) = x : dropall (drop_mult x xs)

primes :: [Int]
primes = dropall (from 2)

goodprimes :: [Int]
goodprimes = droplesser (drop (1) (primes)) (zipmult (primes))
    where zipmult :: [Int] -> [Int]
          zipmult xs = zipWith (*) xs (drop 2 xs)  --all neighbours of an element multiplied (Pn-1 * Pn+1)

          mappedsquare :: [Int] -> Int
          mappedsquare (x: xs) = head(map (^2) (x:xs))     --all elements of a list squared

          droplesser :: [Int] -> [Int] -> [Int]
          droplesser [] _  = []
          droplesser _ [] = []
          droplesser (x:xs) (y:ys) | mappedsquare(x:xs) > y = x: droplesser xs ys
                                   | otherwise = droplesser xs ys

