module hw8
import StdEnv



:: Tree a = Node a (Tree a) (Tree a) | Leaf


// Trees for testing, please do not remove them  . 
tree1 :: Tree Int
tree1 = (Node 4 (Node 10 (Node 6 Leaf Leaf)(Node 11 Leaf Leaf)) (Node 20 (Node 12 Leaf Leaf) Leaf))

tree2 :: Tree Int
tree2 = (Node 5 (Node 10 (Node 31 (Node 1 Leaf Leaf) Leaf) Leaf) (Node 17 (Node 31 (Node 14 (Node 12 Leaf Leaf) Leaf) Leaf) (Node 11 Leaf Leaf) ))

tree3 :: Tree Int
tree3 = (Node 12 (Node 11 (Node 11 (Node 32 Leaf Leaf) Leaf) Leaf) (Node 4 (Node 17 (Node 5 (Node 7 Leaf Leaf) Leaf) Leaf) (Node 3 Leaf (Node 4 Leaf Leaf)) ))

tree4 :: Tree Int
tree4 = (Node 7 (Node 11 tree1 tree2) (Node 5 tree3 tree2))

tree5 :: Tree Int
tree5 = Node 1 tree3 tree4





/* 1. Given the binary tree, find how many nodes are there such that they have exactly
3 grandchildren non-leaf nodes.
Ex.:  1
    /   \
    2    3
   / \  / \
  4   5 6  Leaf
1st node has exactly 3 grandchildrens, so it's a 'good' node.
*/


getLeft :: (Tree Int) -> (Tree Int)
getLeft (Node x l r ) = l

getRight :: (Tree Int) -> (Tree Int)
getRight (Node x l r ) = r

extractNode :: (Tree Int) -> Int
extractNode (Node root left right) = root

getChildrenAux :: (Tree Int) Int -> [Int]
getChildrenAux Leaf num = []
getChildrenAux (Node root left right) num
| (num == root) && (isLeaf left) = [extractNode (right)]
| (num == root) && (isLeaf right) = [extractNode (left)]  
| num == root = [extractNode (left)] ++ [ extractNode (right)]  
= getChildrenAux left num ++ getChildrenAux right num


getGrandChildren :: (Tree Int) Int -> Bool
getGrandChildren tree n = length (flatten [getChildrenAux tree x \\ x <- (getChildrenAux tree n) ]) == 3


//Start = getChildrenAux tree1 20
//Start = getGrandChildren tree1 4
isLeaf :: (Tree Int) -> Bool
isLeaf Leaf = True
isLeaf _ = False

countTripleParents :: (Tree Int) -> Int
countTripleParents Leaf  = 0
countTripleParents (Node root Leaf Leaf) = 0
countTripleParents (Node root left right)
| (getGrandChildren (Node root left right) root) && (isLeaf left) = 1 + countTripleParents right
| (getGrandChildren (Node root left right) root) && (isLeaf right) = 1 + countTripleParents left
| getGrandChildren (Node root left right) root = 1 + (countTripleParents left) + (countTripleParents right)
= (countTripleParents left) + (countTripleParents right)

//Start = CountChildren tree1
//Start = countTripleParents tree1 // 1
//Start = countTripleParents tree2 // 1
//Start = countTripleParents tree3 // 1
//Start = countTripleParents tree4 // 4
//Start = countTripleParents tree5 // 5




/*
2.Given binary search tree and Integer value, remove all the nodes from the tree which have this value
Resulting tree should maintain binary search tree property.
Note: Removing a node requires rearanging the tree and not placing Leaf instead
*/

//myFilterTrees :: (Tree Int -> Bool) Tree Int -> (Tree Int)
//myFilterTrees check tree 
//| cond = tree
//=

/*
ToList :: (Tree Int) ->  [Int]
ToList Leaf = []
ToList (Node root left right) =  [root] ++ ToList left  ++ ToList right
*/
//Start = ToList tree1

removeNum :: [Int] Int -> [Int]
removeNum  x num = filter ((<>) num) x
//Start = removeNum (ToList tree1) 4


//removeInt :: Int (Tree Int) -> (Tree Int)
//removeInt num Leaf = Leaf
//removeInt num (Node root left right)
//| num <> root = (Node root (removeInt left) (removeInt right))
//= (removeInt left) (removeInt right)
//Start = removeInt 5 (Node 4 (Node 3 (Node 3 (Node 2 (Node 1 Leaf Leaf) Leaf) Leaf) (Node 4 Leaf Leaf)) (Node 5 (Node 5 Leaf Leaf) (Node 6 Leaf Leaf)))
// (Node 4 (Node 3 (Node 3 (Node 2 (Node 1 Leaf Leaf) Leaf) Leaf) (Node 4 Leaf Leaf)) (Node 6 Leaf Leaf))
//Start = removeInt 1 (Node 1 (Node 1 (Node 1 (Node 1 (Node 1 (Node 1 Leaf Leaf) Leaf) Leaf) Leaf) Leaf) Leaf) // Leaf



// 3.
// Given a tree, traverse it in level order.
// starting at the root element, then all elements below (left to right), then all
// elements below those (left to right), etc.
// Example:
// 1
// / \
// 2 3
// / \ / \
// 4 5 6 7
// Should return [1,2,3,4,5,6,7]


traverse :: (Tree Int) ->  [Int]
traverse Leaf = []
traverse (Node root Leaf Leaf) = [] 
traverse (Node root left right) 
| ((isLeaf left)==False) && ((isLeaf right)==False) = removeDup(flatten[[root] ++ [extractNode left] ++ [extractNode right] ++ traverse left  ++ traverse right])
| (isLeaf left) && ((isLeaf right)==False) = removeDup(flatten[[root]++ [extractNode right] ++ traverse left  ++ traverse right])
| ((isLeaf left)==False) && (isLeaf right) = removeDup(flatten[[root] ++ [extractNode left] ++ traverse left  ++ traverse right])
= traverse left  ++ traverse right


//Start = traverse (Node 15(Node 3(Node 1 Leaf Leaf)(Node 10(Node 7 Leaf (Node 8 Leaf Leaf))(Node 13 (Node 11 Leaf Leaf) Leaf)))(Node 20 (Node 18 Leaf (Node 19 Leaf Leaf)) (Node 21 Leaf (Node 26 (Node 24 Leaf Leaf) (Node 28 Leaf Leaf))))) 
        // [15,3,20,1,10,18,21,7,13,19,26,8,11,24,28]
// Start = traverse (Node 4 (Node 3 (Node 3 (Node 2 (Node 1 Leaf Leaf) Leaf) Leaf) (Node 4 Leaf Leaf)) (Node 5 (Node 5 Leaf Leaf) (Node 6 Leaf Leaf))) 
           // [4,3,5,3,4,5,6,2,1]


