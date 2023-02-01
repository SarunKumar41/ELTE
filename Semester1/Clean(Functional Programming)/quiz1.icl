module quiz1
import StdEnv

/*
Given a list of integer numbers, divide every even number by 2.
*/

divideEven :: [Int] -> [Int]
divideEven [] = []
divideEven [x:xs] 
| x rem 2 == 0  = [x/2 : divideEven xs]
=  [ x :divideEven xs]  

Start = divideEven [1,2,3,4] // [1,1,3,2]
//Start = divideEven [2,4,8,16,32] // [1,2,4,8,16]
//Start = divideEven [1,3,5]  // [1,3,5]
//Start = divideEven [] // []


