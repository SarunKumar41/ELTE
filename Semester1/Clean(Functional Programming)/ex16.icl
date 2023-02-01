module ex16

import StdEnv


// 1. Create using an input list of tuples a new list of tuples like:
// [(1,1), (2,6), (3,9)] -> [(1,1,2), (2,6,8), (3,9,12)] 

create :: [(Int, Int)] -> [(Int, Int, Int)]
create [] = []
create [(x,y) : ts] = [(x,y,(x+y)) : create ts]
//Start =  create [(1,1), (2,6), (3,9)]
 

// 2. Compute the average of tuple elements using map
//averages :: [(Int, Int)] -> [Int]
//averages [] = []
//averages [(x,y) : ts] = [ map (\x= (x+y)/2) [x,y] : averages ts]
//Start = averages [(1,1), (2,6), (3,9)]


// 3. Put the product of the sublist elements in a list, you must use foldr
sublistsp :: [[Int]] -> [Int]
sublistsp [] = []
sublistsp [x:xs] = [ foldr (*)1 x : sublistsp xs]
//Start = sublistsp [[1, 2, 3], [3, 4], [5, 7, 1]] // [6,12,35]


// 4. Generate the following list of lists
// [[1],[2,1],[3,2,1],[4,3,2,1],[5,4,3,2,1]]
//genNlist :: Int -> [[Int]]

//Start = genNlist 5


// 5. "Reverse" a number: 1234 -> 4321
getDigits :: Int -> [Int]
getDigits 0 = []
getDigits x = [x rem 10 : getDigits (x/10)]

revnr :: Int -> [Int]
revnr 0 = []
revnr x = getDigits x
Start = revnr 1234


// 6. Delete every second element of a list
// e.g. [1,2,3,4,3,2,4,5] -> [1,3,3,4]
//delsecond :: [Int] -> [Int]

//Start = delsecond [1,2,3,4,3,2,4,5]


// 7. Insert a value after every element of a list 
// [1,2,3,4,5] 0 -> [1,0,2,0,3,0,4,0,5,0]
//insertx :: [Int] Int -> [Int]/

//Start = insertx [1,2,3,4,5] 0


// 8. Insert 0 after every digit of a number: 123 -> 102030
//digit0 :: Int -> Int

//Start = digit0 123 

