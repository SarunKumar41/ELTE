module exercises
import StdEnv

/////////////////////CHOCOLATE///////////////////////////////////////////////////////////////

// Given following three values, the task is to find the total number of maximum chocolates you can eat.

//     money : Money you have to buy chocolates
//     price : Price of a chocolate
//     wrap : Number of wrappers to be returned for getting one extra chocolate.

// It may be assumed that all given values are positive integers and greater than 1.

// EXAMPLE :
 
// Input :   money = 16, price = 2, wrap = 2
// Output :   15
// Price of a chocolate is 2. You can buy 8 chocolates from
// amount 16. You can return 8 wrappers back and get 4 more
// chocolates. Then you can return 4 wrappers and get 2 more
// chocolates. Finally you can return 2 wrappers to get 1
// more chocolate.
//Aux money price wrap count = Aux (money / price) +  ((money / price) / wrap) + 

wrap ::  Int Int -> Int
wrap  got w
| got < w = 0
= got/w + wrap (got/w) w

//Start = wrap 8 2

choco :: Int Int Int -> Int
choco 0 price wrappers = 0
choco money price wrappers = bought + (wrap bought wrappers)
where
    bought = money/price 

//Start = choco 16 2 2 //15
//Start  = choco 10 2 2//8

///////////////////////////COVERBOARD////////////////////////////////

// Given an area of N X M.
// You have infinite number of tiles of size 2^i X 2^i, where i = 0, 1, 2,� so on.
// The task is to find minimum number of tiles required to fill the given area with tiles.

areacalhelp :: Int -> Int
areacalhelp 0 = 0
areacalhelp area  = area - maxList (takeWhile (\x=x<=area) [(2*i)^2 \\ i<-[0,1..] ])  //+ areacalhelp (area - maxList[(2*i)^2 \\ i<- [0,1.. | (2*i)^2 < area] ]) 


areacal :: Int -> Int
areacal 0 = 0
areacal r 
| (areacalhelp r) <> 0  = 1 +  areacal (areacalhelp r)
= 1 

//Start = areacal 100

area :: Int Int -> Int
area r r1 = areacal (r*r1)

//Start = area 7 4

//////////////////////TRIANGLE//////////////////////////(areacalhelp r)

// Given an array of integers, print a sum triangle from it such that the first level has all array elements.
// From then, at each level number of elements is one less than the previous level
// and elements at the level is be the Sum of consecutive two elements in the previous level.

sumtriangle :: [Int] Int Int-> [[Int]]
sumtriangle [x,xx :xs] len incr
| len == 2 = [[x+xx]]
= (sumtriangle (take cap series) (cap) (incr*2) ) ++ [(take cap series)]
where
    nextval = x+xx
    cap = (len-1)
    series = [nextval,nextval+incr..]

//Start = sumtriangle [1,2,3,4,5] 5 2

triangle :: [Int] -> [[Int]]
triangle [] = [[]]
triangle list = (sumtriangle list (length list) 2) ++ [list]

//Start = triangle [1,2,3,4,5]    //[ [48],
                                //  [20, 28]
                                //  [8, 12, 16]
                                //  [3, 5, 7, 9]
                                //  [1, 2, 3, 4, 5] ]


/////////////////////MERGETREES//////////////////////// ++ [[x,xx :xs]]

// Given two binary trees and imagine that when you put one of them to cover the other, 
// some nodes of the two trees are overlapped while the others are not.
// You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, 
// then sum node values up as the new value of the merged node. 
// Otherwise, the NOT null node will be used as the node of new tree.



	// Tree 1                     Tree 2                  
    //       1                         2                             
    //      / \                       / \                            
    //     3   2                     1   3                        
    //    /                           \   \                      
    //   5                             4   7              

    //   Merged tree:
	//      3
	//     / \
	//    4   5
	//   / \   \ 
	//  5   4   7

:: Tree a = Node a (Tree a) (Tree a) | Leaf
Tree1 = Node 1 (Node 3 (Node 5 Leaf Leaf) Leaf)(Node 2 Leaf Leaf)
Tree2 = Node 2 (Node 1 Leaf (Node 4 Leaf Leaf))(Node 3 Leaf (Node 7 Leaf Leaf))
Tree3 = Node 1 (Node 1 Leaf Leaf) (Node 1 Leaf Leaf)
ourTree = Node 15(Node 3(Node 1 Leaf Leaf)(Node 10(Node 7 Leaf (Node 8 Leaf Leaf))(Node 13 (Node 11 Leaf Leaf) Leaf)))(Node 20 (Node 18 Leaf (Node 19 Leaf Leaf)) (Node 21 Leaf (Node 26 (Node 24 Leaf Leaf) (Node 28 Leaf Leaf))))

isLeaf :: (Tree Int) -> Bool
isLeaf Leaf = True
isLeaf _ = False

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
//add :: (Tree a) (Tree a) -> (Tree a) | + a

//Start = addTree Tree2 Tree1

////////////////PASSWORD/////////////////////////////////	

// A password is considered strong if below conditions are all met:

//     It has at least 6 characters and at most 20 characters.
//     It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
//     It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).

// Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM change required to make s a strong password. If s is already strong, return 0.

// Insertion, deletion or replace of any one character are all considered as one change.

checkOneUpper :: String -> Bool
checkOneUpper check = length ([x \\x<-:check | isUpper x]) >=1

checkOneLower :: String -> Bool
checkOneLower check =  length ([x \\x<-:check | isLower x]) >=1

checkOneDigit :: String -> Bool
checkOneLower check =  length ([x \\x<-:check | isDigit x]) >=1

checkTripple :: [Char] -> Bool
checkTripple [any,an,a : xs] =
| (any==an) && (an==an) = False
= True

stringToList :: String -> [Char] 
stringToList check
| [x \\x<-:check]

//Start = stringToList "Sarun"
//strongPasswordChecker :: String -> Int
//Start = strongPasswordChecker "abcdef6R"




