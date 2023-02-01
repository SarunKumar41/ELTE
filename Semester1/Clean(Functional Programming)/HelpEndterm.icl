module HelpEndterm
import StdEnv

:: Tree a = Node a (Tree a) (Tree a)
			| Leaf

tree1 :: Tree Int
tree1 = (Node 1 (Node 2 (Node 4 Leaf Leaf)(Node 5 Leaf Leaf)) (Node 1 (Node 6 Leaf Leaf) Leaf))

tree2 :: Tree Int
tree2 = (Node 4 (Node 3 (Node 11 (Node 2 Leaf Leaf) Leaf) Leaf) (Node 0 (Node 2 (Node 13 (Node 15 Leaf Leaf) Leaf) Leaf) (Node 1 Leaf Leaf) ))

tree3 :: Tree Int
tree3 = (Node -1 (Node -3 (Node -11 (Node -2 Leaf Leaf) Leaf) Leaf) (Node -16 (Node -22 (Node -13 (Node -15 Leaf Leaf) Leaf) Leaf) (Node -100 Leaf (Node -1 Leaf Leaf)) ))
// Above are sample testers!!!!! Don't take above

// 1. Extract Node Element (root)
extractNode :: (Tree Int) -> Int
extractNode (Node root left right) = root

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
// 2. Extract Left child of the tree (left)
getLeft :: (Tree Int) -> (Tree Int)
getLeft (Node root left right) = left

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
// 3. Extract Right Child of the tree (right)
getRight :: (Tree Int) -> (Tree Int)
getRight (Node root left right) = right

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

// 4. Checks if the the tree is Leaf
isLeaf :: (Tree Int) -> Bool
isLeaf Leaf = True
isLeaf _ = False

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

// 5. To get the minimum tree
minTree :: (Tree Int) -> Int
minTree (Node root left right)
| isLeaf left = root
= minTree left
// Required Functions: isLeaf 

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

//6. To remove minimum node
remMin :: (Tree Int) -> (Tree Int)
remMin (Node root Leaf right) = right
remMin (Node root left right)
| extractNode left == minTree (Node root left right) = (Node root (getRight left) right)
= (Node root (remMin left) right)
// Required Functions: extractNode, minTree , getRight 

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
// 7. To remove the first Node in Binary Search Tree 
remRoot :: (Tree Int) -> (Tree Int)
remRoot Leaf = Leaf
remRoot (Node root left right)
| isLeaf left && isLeaf right = Leaf
| isLeaf left = right
| isLeaf right = left
= (Node (minTree right) left (remMin right))

// Required Functions: extractNode, getRight , minTree, remMin 

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

//8. To convert list to array
toArray :: [a] -> {a} 
toArray ajji = {x \\ x<-ajji} 

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

//9. To convert array to list
toList :: {a} -> [a] 
toList lund = [x \\ x<-: lund] 

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

//10. To transform tree to list

treeToList :: (Tree Int) -> [Int]
treeToList Leaf = []
treeToList (Node root left right) =  treeToList left ++ [root] ++ treeToList right

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

// 11. To make a binary search tree from unsorted list

makeBST :: [Int] -> (Tree Int)
makeBST [] = Leaf
makeBST [x:xs] = (Node mid (makeBST (take (half)(sortedl))) (makeBST (drop (half+1)(sortedl))))  
where
    half = (length[x:xs])/2
    mid = (sortedl)!!(half)  
    sortedl = sort[x:xs]
 
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

//12. To add tree while preserving the format

addTree :: (Tree a) (Tree a) -> (Tree a) | + a
addTree Leaf Leaf = Leaf
addTree Leaf (Node root1 left1 right1) = (Node root1 left1 right1)
addTree (Node root left right) Leaf = (Node root left right)
addTree (Node root Leaf Leaf) (Node root1 Leaf Leaf) = (Node (root+root1) Leaf Leaf)
addTree (Node root left right) (Node root1 Leaf Leaf) = (Node (root+root1) left right)
addTree (Node root Leaf Leaf) (Node root1 left1 right1) = (Node (root+root1) left1 right1)
addTree (Node root Leaf right) (Node root1 left1 right1) = (Node (root+root1) left1 (addTree right right1))
addTree (Node root left Leaf) (Node root1 left1 right1) = (Node (root+root1) (addTree left left1) right1)
addTree (Node root left right) (Node root1 left1 Leaf) = (Node (root+root1) (addTree left left1) right)
addTree (Node root left Leaf) (Node root1 Leaf right1) = (Node (root+root1) left (addTree left right1) )
addTree (Node root left right) (Node root1 left1 right1) =  (Node (root+root1) (addTree left left1) (addTree right right1))

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

// 13. To filter a binary search tree

filterTree :: (Int -> Bool) (Tree Int) -> (Tree Int)
filterTree func Leaf = Leaf
filterTree func (Node root left right)
| (func root) = (Node root (filterTree func left) (filterTree func right) )
= remRoot (Node root (filterTree func left) (filterTree func right) )

// Required Functions: extractNode, getRight , minTree, remMin , remRoot

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

//14. To check prime number

primeList :: [Int] -> [Int]
primeList list = [y \\ y<-list | ((length [x \\ x <- [1..y] | (y rem x == 0)]) == 2) ]

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

//15. To check Length of String

myShortCheck :: String -> Bool
myShortCheck str = (length [x \\x<-:str]) < 6 
//Same Category------------------------------------------------------------------------------------------
isShort :: String -> Bool 
isShort str = (size str) < 6 // size is a built in function for String size
//Same Category------------------------------------------------------------------------------------------
stringToList :: String -> [Char]
stringToList str = [x \\x<-:str]

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
//universityGPA :: University -> Real
//universityGPA uni = toReal(sum((flatten[toList(stu.grades) \\ stu<-uni.students])))/ toReal(length(flatten[toList(stu.grades) \\ stu<-uni.students]))
//--------------------------------------- make list for yourself                  --------------------------   same                                 -------------


// ||\\  || 
// || \\ || ----->>>> "+++" is for concatinating strings
// ||  \\||

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

//16. Sample of class difinition  

class MyMultDiv a
where
	 (*~) :: a a -> a
	 (/~) :: a a -> a
	 myOne :: a 

instance MyMultDiv Char
where 
	(*~):: Char Char -> Char
	(*~) a b = toChar ((toInt(a) * toInt(b)) rem 255)
	
	(/~):: Char Char -> Char
	(/~) a b = toChar ((toInt(a) / toInt(b)) rem 255)

	myOne :: Char
	myOne = toChar 1
	
//Start = 'a' *~ 'b' //'G'
//Start = 'k' *~ myOne //'k'
//Start= 'z' /~ 'A' //'' //''

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

//17.  Check if a number exists in a tree as a root (for all tree)

Checknum :: Int (Tree Int) -> Bool
Checknum num Leaf = False
Checknum num (Node root left right)
| num == root = True
= (Checknum num left) || (Checknum num right) 


//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

// 18. Gives level of any number in the root of any tree 

/*
	Given a key determine in which level it is stored in the Tree.
	
	
		 07           <- Level 0
	   /   \          
	 02	    20        <- Level 1
	 /\	    / \ 
	01 04  10 30 	  <- Level 2
*/

getLevel :: Int (Tree Int) -> Int
getLevel num Leaf = -1
getLevel num (Node root left right)
| Checknum num left = 1 + (getLevel num left)
| Checknum num right = 1 + (getLevel num right)
| useChecknum && (num == root) = 1 + getLevel num Leaf
= -1
where useChecknum = Checknum num (Node root left right)

// Required Functions: Checknum
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

// 19. Check if the number is notprime

notPrime :: Int -> Bool
notPrime x
| x <= 1 = True
= not(isEmpty[n\\n<-[2..(x-1)]|x rem n == 0])

