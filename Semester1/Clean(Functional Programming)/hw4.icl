module hw4
import StdEnv



/// GENERAL::: PLEASE NAME THE FILE AFTER YOUR NAME!




/*

Task 1: 
Given a list of tuples and a list of integers. Return the tuples that have all
their numbers found in the integer list.

e.g: [(1,2,3), (3,3,3)] [1,3,4,4] -> [(3,3,3)]
// (1,2,3) is not since there is no '2' in the numbers list
*/

task1 :: [(Int,Int,Int)] [Int] -> [(Int,Int,Int)]
task1 [] [l:ls] = []
task1 [(x,y,z) : ts] [] = []  
task1 [(x,y,z) : ts] [l:ls] 
| (x == l) && (y == l) && (z ==l) = [(x,y,z) : task1 ts ls ]
= task1 ts ls 



//Start = task1 [(1,2,3), (3,3,3)] [1,3,4,4] // [(3,3,3)]
//Start = task1 [(1,1,1), (3,3,3)] [1,3,4,4] // [(1,1,1), (3,3,3)]
//Start = task1 [(1,2,3), (3,4,5)] [10,9,8,7,6] // []





/*
Task 2:

Given a tuple '(x,y,r)', and a list of tuples "[(x,y)]". 
The first input represents a circle coordinates (x,y,r), where (x,y) are
	 the circles center, while r is the circle radius.
	
The second input represents points in 2D cartesian space (x,y).

Return a list in which it contains +1, 0, -1 for each of the points. 
which: 
	+1 means that the point is outside the
	0 means that the point is on the circle circumferance
	-1 means that the point is inside the circle
*/



task2 :: (Int,Int,Int) [(Int,Int)] -> [Int]
task2 (h,k,r) [] = []
task2 (h,k,r) [(x,y) : xs]
| Check > Equals =  [1] ++ task2 (h,k,r) xs
| Check == Equals = [0] ++ task2 (h,k,r) xs
= [-1] ++ task2 (h,k,r) xs
where Check = (x*x) + (h*h) - (2*x*h) + (y*y) + (k*k) - (2*k*y)
      Equals = (r*r)

//Start = task2 (0,0,1) [(1,1), (1,0), (0,0)] // [1,0,-1]
//Start = task2 (1,1,2) [(2,2), (1,-1), (0,0), (3,3)] // [-1,0,-1,1]





/*
Task 3:
Given a list of names, where every 2 consequent names form a full name. e.g:
[firstname_1, lastname_1, firstname_2, lastname_2 ..]

Return: The a list with tuples in it where each tuple form a full name. e.g:
[(firstname_1, lastname_1), (firstname_2, lastname_2) ...]
*/

task3 :: [String] -> [(String,String)]
task3 [] =[]
task3 [firstname,lastname : lastone]  = [(firstname,lastname) : task3 lastone ]
//Start = task3 ["Mohido","The Mohido", "Tariq", "Beka", "Someone", "sonsomeone"] //[("Mohido","The Mohido"),("Tariq","Beka"),("Someone","sonsomeone")]






