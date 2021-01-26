data MultTree a = Nil
                | TNode (a, a) (MultTree a)
                | Leaf a
                | Child (MultTree a) (MultTree a)
                deriving Show

-- Child beliebige Anzahl an Verzweigungen
-- TNode Wurzel mit Datentyp (a,a), also Index- Knoten
-- Leaf := Daten- Knoten

--a
t1 :: MultTree Int
t1 = TNode (3, 42) (Child (TNode (3,15) (Child (Leaf 3) (Child (Leaf 11) (Leaf 12)))) (TNode (19, 42) (Child (Leaf 42)(Leaf 23))))

--b
verzweigungsgrad :: MultTree a-> Int
verzweigungsgrad (TNode _ b) = 1 + verzweigungsgrad(b)
verzweigungsgrad (Child (b) (bs)) = max (verzweigungsgrad(b)) (verzweigungsgrad (bs))
verzweigungsgrad (Leaf _) = 1
verzweigungsgrad Nil = 0

--c
datenListe :: MultTree a -> [a]
datenListe (TNode _ (b)) = [] ++ datenListe (b)
datenListe (Child (bs) (bss)) = [] ++ datenListe(bs) ++ datenListe (bss)
datenListe (Leaf w) = w : []
datenListe Nil = []

--d
allLeaf :: MultTree Int -> [Int] --HilfsF : fügt alle Blätter aus Zweig/ Ebene in eine Liste
allLeaf (Leaf a)= a:[]
allLeaf (Child a b) = allLeaf a ++ allLeaf b
allLeaf (Nil)= []
allLeaf (TNode _ _)= []

maxLeaf :: [Int] -> Int                  --HilfsF : max element list
maxLeaf (a: as) = max a (maxLeaf as)
maxLeaf [] = minBound                        

minLeaf :: [Int] -> Int                  --HilfsF : min element list
minLeaf (a: as) = min a (minLeaf as)
minLeaf [] = maxBound

isTNode :: MultTree Int -> Bool          -- HilfsF : if all childs == TNode = True
isTNode (TNode _ _ ) = True
isTNode (Child a b) = isTNode a  && isTNode b
isTNode Nil = True
isTNode (Leaf a) = False                                   


minimalIntervall :: MultTree Int -> MultTree Int                 --HilfsF : kleinster Wert eines Datenknotens ersetzt durch kleinster Wert Blatt
minimalIntervall (TNode (a, b) (Leaf c)) | a>b = TNode (a, c) (Leaf c)
                                         | otherwise = TNode (c, b) (Leaf c)
minimalIntervall (TNode (a ,b) (Child c d ) ) | isTNode (Child c d) == True = TNode (a , b) (minimalIntervall (Child c d))           -- falls alle Kinder TNodes
                                              | a>b = TNode (a , minLeaf (allLeaf(Child c d))) (minimalIntervall (Child c d))
                                              | a<=b = TNode (minLeaf (allLeaf(Child c d)), b) (minimalIntervall (Child c d))
minimalIntervall (Leaf a)= Leaf a
minimalIntervall (Nil) = Nil
minimalIntervall (Child a b) = datenIntervalle (Child a b)
minimalIntervall (TNode (a, b) (Nil)) = (TNode (maxBound, minBound) (Nil))


datenIntervalle :: MultTree Int -> MultTree Int
datenIntervalle (TNode (a,b) (Leaf c)) | a>b  = TNode (c, b) (Leaf c)
                                       | otherwise = TNode (a,c) (Leaf c) 
datenIntervalle (TNode (a,b) (Child c d)) | isTNode (Child c d) == True = TNode (a, b) (datenIntervalle (Child c d))                  -- falls alle Kinder TNodes
                                          | a>b = TNode (maxLeaf (allLeaf(Child c d)), b) (datenIntervalle (Child c d))  
                                          | a<=b = TNode (a, maxLeaf (allLeaf(Child c d))) (datenIntervalle (Child c d)) 
datenIntervalle (Leaf a) = Leaf a
datenIntervalle (Nil) = Nil
datenIntervalle (Child a b) = Child (datenIntervalle a) (minimalIntervall b)
datenIntervalle (TNode (a, b) (Nil)) = (TNode (maxBound, minBound) (Nil))



--e
isIntervall :: (Int, Int) -> Int -> Bool
isIntervall (a,b) i | a == i || i == b = True
                    | (a /= i || b /= i ) && (a < b) = isIntervall (a+1, b) i
                    | otherwise = False

isinLeafs:: [Int] -> Int -> Bool
isinLeafs  (a :as) i | a == i = True
                     | otherwise = False || isinLeafs as i
isinLeafs [] i = False

contains :: MultTree Int -> Int -> Bool
contains Nil i = False
contains (TNode (a,b) c) i | isIntervall (a,b) i == True = isinLeafs (datenListe (TNode (a,b) c) ) i
                             | otherwise = False

g x ( y: ys ) = g ( y x ) ys
g x y = x []
