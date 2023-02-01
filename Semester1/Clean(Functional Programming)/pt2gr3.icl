module pt2gr3

import StdEnv

/*
Given a positive integer number, split the number's digits into a list
and filter the odd digits from the list, keeping only the even digits
e.g: 14423 = [4,4,2]
*/	
f2 :: Int -> Int
f2 x = x rem 10 
evenSplit :: Int -> [Int]
evenSplit 0 = [0]
evenSplit x
|  x rem 2 == 0 = [x] ++ evenSplit (f2(x/10))
= evenSplit (f2 (x/10))



//Start = evenSplit 5445 // [4,4]
Start = evenSplit 345678 // [4,6,8]
//Start = evenSplit 86 // [8,6]
//Start = evenSplit 0 // [0]
