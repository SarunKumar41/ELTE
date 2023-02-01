module Endterm
import StdEnv

:: Tree a = Node a (Tree a) (Tree a)
			| Leaf
:: Month = January | February  | March   | April    | May | June | July
         | August  | September | October | November | December

bestTree = Node 10(Node 6(Node 1 Leaf(Node 5(Node 2 Leaf(Node 4(Node 3 Leaf Leaf)Leaf))Leaf))Leaf)(Node 14(Node 11 Leaf(Node 13(Node 12 Leaf Leaf)Leaf))(Node 17(Node 15 Leaf(Node 16 Leaf Leaf))(Node 19(Node 18 Leaf Leaf)(Node 20 Leaf Leaf))))
ourTree = Node 15(Node 3(Node 1 Leaf Leaf)(Node 10(Node 7 Leaf (Node 8 Leaf Leaf))(Node 13 (Node 11 Leaf Leaf) Leaf)))(Node 20 (Node 18 Leaf (Node 19 Leaf Leaf)) (Node 21 Leaf (Node 26 (Node 24 Leaf Leaf) (Node 28 Leaf Leaf))))		
noTree = Leaf
unitTree = Node 1337 Leaf Leaf
myTree = Node 8 (Node 4 (Node 2 Leaf Leaf) (Node 6 (Node 5 Leaf Leaf)(Node 7 Leaf Leaf)))(Node 10 (Node 9 Leaf Leaf) (Node 11 Leaf Leaf))

//Write a function that takes a tree as a parameter and returns a list of leaves.
// An empty tree will return [] and a single element tree will return a list of one element.

isLeaf :: (Tree Int) -> Bool
isLeaf Leaf = True
isLeaf _ = False

leaves :: (Tree Int) -> [Int]
leaves  Leaf = []
leaves (Node root left right)
| isLeaf (left) && isLeaf (right) = [root]
= (leaves left) ++ (leaves right)

//Start = leaves bestTree //[3,12,16,18,20]
//Start = leaves ourTree //[1,8,11,19,24,28]
//Start = leaves unitTree //[1337]
//Start =  leaves noTree //[]

//Write a function that takes a binary search tree, and removes its node.
//Note, the original tree connections must be preserved.

extractNode :: (Tree Int) -> Int
extractNode (Node root left right) = root

minTree :: (Tree Int) -> Int
minTree (Node root left right)
| isLeaf left = root
= minTree left
//Start = minTree myTree

getRight :: (Tree Int) -> (Tree Int)
getRight (Node root left right) = right

getLeft :: (Tree Int) -> (Tree Int)
getLeft (Node root left right) = left

remMin :: (Tree Int) -> (Tree Int)
remMin (Node root Leaf right) = right
remMin (Node root left right)
| extractNode left == minTree (Node root left right) = (Node root (getRight left) right)
= (Node root (remMin left) right)
//Start = remMin myTree

remRoot :: (Tree Int) -> (Tree Int)
remRoot Leaf = Leaf
remRoot (Node root left right)
| isLeaf left && isLeaf right = Leaf
| isLeaf left = right
| isLeaf right = left
= (Node (minTree right) left (remMin right))

//Start = remRoot ourTree //(Node 18 (Node 3 (Node 1 Leaf Leaf) (Node 10 (Node 7 Leaf (Node 8 Leaf Leaf)) (Node 13 (Node 11 Leaf Leaf) Leaf))) (Node 20 (Node 19 Leaf Leaf) (Node 21 Leaf (Node 26 (Node 24 Leaf Leaf) (Node 28 Leaf Leaf)))))
//Start = remRoot bestTree //(Node 11 (Node 6 (Node 1 Leaf (Node 5 (Node 2 Leaf (Node 4 (Node 3 Leaf Leaf) Leaf)) Leaf)) Leaf) (Node 14 (Node 13 (Node 12 Leaf Leaf) Leaf) (Node 17 (Node 15 Leaf (Node 16 Leaf Leaf)) (Node 19 (Node 18 Leaf Leaf) (Node 20 Leaf Leaf)))))
//Start = remRoot unitTree //Leaf
//Start = remRoot noTree //Leaf

//Write a function that takes a condition testing function (such as isPrime, isEven, etc)
//and a binary search tree, and filters the tree according to the condition.
//That is, you must remove the nodes that do not meet the condition and keep those that do
//while preserving the original tree connections.

filterTree :: (Int -> Bool) (Tree Int) -> (Tree Int)
filterTree func Leaf = Leaf
filterTree func (Node root left right)
| (func root) = (Node root (filterTree func left) (filterTree func right) )
= remRoot (Node root (filterTree func left) (filterTree func right) )
//Start =  filterTree isEven bestTree //(Node 10 (Node 6 (Node 2 Leaf (Node 4 Leaf Leaf)) Leaf) (Node 14 (Node 12 Leaf Leaf) (Node 18 (Node 16 Leaf Leaf) (Node 20 Leaf Leaf))))
//Start = filterTree isEven ourTree //(Node 18 (Node 10 (Node 8 Leaf Leaf) Leaf) (Node 20 Leaf (Node 26 (Node 24 Leaf Leaf) (Node 28 Leaf Leaf))))
//Start = filterTree ((>)10) unitTree //Leaf
//Start = filterTree isOdd noTree //Leaf

//Write a function that takes a month and a natural number
//then returns that number of months later.
//For example, monthIterate January 10 = November

monthToInt :: Month -> Int
monthToInt January = 0
monthToInt February = 1
monthToInt March = 2
monthToInt April = 3
monthToInt May = 4
monthToInt June = 5
monthToInt July = 6
monthToInt August = 7 
monthToInt September = 8 
monthToInt October = 9
monthToInt November = 10
monthToInt December = 11

IntToMonth :: Int -> Month
IntToMonth 0 = January
IntToMonth 1 = February
IntToMonth 2 = March
IntToMonth 3 = April
IntToMonth 4 = May
IntToMonth 5 = June
IntToMonth 6 = July
IntToMonth 7 = August
IntToMonth 8 = September
IntToMonth 9 = October
IntToMonth 10 = November
IntToMonth 11 = December

monthCalculation :: Int Int -> Month
monthCalculation mon num
| (mon + num) <12 = IntToMonth(mon+num)
= IntToMonth((mon+num) rem 12)  

monthIterate :: Month Int -> Month
monthIterate mon num = monthCalculation (monthToInt mon) num

//Start = monthIterate January 5 //June
//Start = monthIterate May 134 //July
//Start = monthIterate July 120000002 //September

//Write a function that takes a list of months and sorts them.
//Duplicates can be kept.

instance < Month
where
    < a b = (monthToInt a) < (monthToInt b)

instance == Month
where
    == a b = (monthToInt a) == (monthToInt b)

monthSort :: [Month] -> [Month]
monthSort list = sort list
//Start = monthSort [February, October, January, June, December, May, April, October] //[January,February,April,May,June,October,October,December]
//Start = monthSort [] //[]

//Given a list of arrays, sort them by their highest number.
//The order of elements in the arrays must be preserved.
//In the case of arrays with equal highest numbers, their original order must be preserved.

toList :: {Int} -> [Int]
toList lund = [x \\ x<-: lund] 

instance < {Int}
where 
    < a b = maxList(toList a) < maxList(toList b)

instance == {Int}
where 
    == a b = maxList(toList a) == maxList(toList b)

sortArrays :: [{Int}] -> [{Int}]
sortArrays hogya = sort hogya


//Start = sortArrays [{4,2,5,6},{1,4,2},{5,2,1,0,3,2}] //[{1,4,2},{5,2,1,0},{4,2,5,6}]
//Start = sortArrays [{1,2,3},{2},{2,5,2},{3,1},{1,2},{0}] //[{0},{2},{1,2},{1,2,3},{3,1},{2,5,2}]
//Start = sortArrays [] //[]

//Given a month, generate an array of months from that month til the end of the year.
//The months must be in order.

toArray :: [Int] -> {Int}
toArray ajji = {x \\ x<-ajji} 

makelistmonth :: Month -> [Int]
makelistmonth mon = [(monthToInt mon)..11]

//Start = makelistmonth January

yearEnd :: Month -> {Month}
yearEnd mon = {IntToMonth x \\x<- [monthToInt mon..11] }

     

//Start = yearEnd January //{January,February,March,April,May,June,July,August,September,October,November,December}
//Start = yearEnd July //{July,August,September,October,November,December}
//Start = yearEnd December //{December}
