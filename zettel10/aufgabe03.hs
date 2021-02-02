primes :: [Int]
primes = dropMultiples (from 2)
       where dropMultiples :: [Int] -> [Int]
             dropMultiples (x : xs) = x : dropMultiples (filter (\n -> mod n x /= 0) xs)
             from :: Int -> [Int]
             from n = n : from (n + 1)

goodPrimes :: [Int]
goodPrimes = filterWithBoolList (zipWith (>) primeSquares neighProductPrimes) primes'

           where primes'            = drop 1 primes
                 primeSquares       = map (\x -> x*x) primes'
                 neighProductPrimes = neighProducts primes

                 neighProducts :: [Int] -> [Int]
                 neighProducts (a : b : c : rest) = a*c : neighProducts (b : c : rest)

                 filterWithBoolList :: [Bool] -> [a] -> [a]
                 filterWithBoolList (keepA : bs) (a : as)
                     | keepA     = a : filterWithBoolList bs as
                     | otherwise = filterWithBoolList bs as
