module g3
import StdEnv

:: Tree a = Node a (Tree a) (Tree a) | Leaf

bestTree :: (Tree Int)
bestTree = Node 10(Node 6(Node 1 Leaf(Node 5(Node 2 Leaf(Node 4(Node 3 Leaf Leaf)Leaf))Leaf))Leaf)(Node 14(Node 11 Leaf(Node 13(Node 12 Leaf Leaf)Leaf))(Node 17(Node 15 Leaf(Node 16 Leaf Leaf))(Node 19(Node 18 Leaf Leaf)(Node 20 Leaf Leaf))))
ourTree :: (Tree Int)
ourTree = Node 15(Node 3(Node 1 Leaf Leaf)(Node 10(Node 7 Leaf (Node 8 Leaf Leaf))(Node 13 (Node 11 Leaf Leaf) Leaf)))(Node 20 (Node 18 Leaf (Node 19 Leaf Leaf)) (Node 21 Leaf (Node 26 (Node 24 Leaf Leaf) (Node 28 Leaf Leaf))))
shortTree :: (Tree Int)
shortTree = Node 14(Node 11 Leaf(Node 13 Leaf Leaf))(Node 17(Node 15 Leaf Leaf)Leaf)
noTree :: (Tree Int)
noTree = Leaf
unitTree :: (Tree Int)
unitTree = Node 1337 Leaf Leaf

/* 
Write a function that takes a tree as an argument and counts "half-terminal"
nodes. A node is "half-terminal" if it has exactly one Leaf as a child.
*/

/*
isLeaf :: (Tree Int) -> Bool
isLeaf Leaf = True
isLeaf _ = False

halfTerminal :: (Tree Int) -> Int
halfTerminal Leaf = 0
halfTerminal (Node root left right)
| (isLeaf left == True) && (isLeaf right == False) = 1 + (halfTerminal right) 
| (isLeaf right == True) && (isLeaf left == False) = 1 + (halfTerminal left)
= (halfTerminal right) + (halfTerminal left) 
*/

/*
halfTerminal :: (Tree Int) -> Int
halfTerminal Leaf = 0
halfTerminal (Node x left right)
| (left == Leaf) && ( right <> Leaf) = 1 + (halfTerminal right) 
| ( right == Leaf) && ( left <> Leaf) = 1 + (halfTerminal left)
= (halfTerminal right) + (halfTerminal left) 

//instance == Bool
//where (==) a b = True 
*/  

//Start = halfTerminal bestTree // 8
//Start = halfTerminal ourTree // 4
//Start = halfTerminal shortTree // 2
//Start = halfTerminal unitTree // 0
Start = halfTerminal noTree // 0
