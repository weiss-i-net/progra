data MultiTree t = Leaf t
                 | Node t t (List (MultiTree t))
                 deriving Show

data List t = End
            | Next t (List t)
            deriving Show

t1 :: MultiTree Int
t1 = Node 3 42
        (Next
            (Node  3 15
                (Next (Leaf  3)
                (Next (Leaf 11)
                (Next (Leaf 12)
                 End))))
        (Next
            (Node 19 42
                (Next (Leaf 42)
                (Next (Leaf 23)
                 End)))
         End))

t2 :: MultiTree Int
t2 = Node 3 42
        (Next
            (Node  3 15
                (Next (Leaf  3)
                (Next (Leaf 11)
                (Next (Leaf 12)
                 End))))
        (Next
            (Node 19 42
                (Next (Leaf 42)
                (Next (Leaf 23)
                (Next
                    (Node 98 12
                        (Next (Leaf  1)
                        (Next (Leaf  2)
                        (Next (Leaf  3)
                        (Next (Leaf  4)
                        (Next (Leaf  5)
                         End))))))
                 End))))
         End))

len :: List a -> Int
len End         = 0
len (Next x xs) = 1 + len xs

fold :: (a -> b -> b) -> b -> List a -> b
fold _ null End           = null
fold f null (Next a rest) = f a (fold f null rest)

listBounds :: (a -> a -> Bool) -> a -> a -> List a -> (a, a)
listBounds greater min max list = fold updateBounds (max, min) list
                                where updateBounds x (loB, upB)
                                          | x   `greater` upB = (loB,   x)
                                          | loB `greater` x   = (x,   upB)
                                          | otherwise         = (loB, upB)

verzweigungsgrad :: MultiTree a -> Int
verzweigungsgrad (Leaf _)             = 0
verzweigungsgrad (Node _ _ childList) = max (len childList)
                                            (fold (\ x y -> max (verzweigungsgrad x) y) 0 childList)

datenListe :: MultiTree a -> [a]
datenListe (Leaf x)                        = [x]
datenListe (Node _ _ End)                  = []
datenListe (Node x y (Next tree treeList)) = datenListe tree ++ datenListe (Node x y treeList)

datenIntervalle :: MultiTree Int -> MultiTree Int
datenIntervalle (Leaf x)     = Leaf x
datenIntervalle (Node _ _ x) = Node min max x
                             where (Leaf min, Leaf max) = listBounds greaterTree (Leaf minBound) (Leaf maxBound) x
                                   greaterTree :: MultiTree Int -> MultiTree Int -> Bool
                                   greaterTree (Leaf a) (Leaf b) = a > b
                                   greaterTree a b               = 

