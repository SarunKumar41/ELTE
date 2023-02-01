module assignment2
import StdEnv 

/*
1- Given a list consisting of 4 real values (first two values are one of the vertices of a rectangle x and y coordinate,
third is the rectangle's width and the fourth is the rectangle' height (width and height can be negative too). For example,
in case of  x =1, y=5, width=6, height=-2,
the bottom left vertex coordinates will be 1 and 3.
Define topLeft, topRight , bottomRight, and bottomLeft functions returning
the corresponding vertex of the rectangle as a list consisting of  x , y represinting the point of the resulting function.
*/
max:: [Real] -> Real
max [x]=x //the base case
max [x:xs]
| x > max [ xs] = x


Start = max [2.0, 3.0, 5.0.7.0]
//topLeft :: [Real] -> [Real]

//topRight :: [Real] -> [Real]
//bottomLeft:: [Real] -> [Real]
//bottomRight:: [Real] -> [Real]
 
//Start = topLeft[3.0 , 5.0 , 1.0 , -7.0] ++  topRight[3.0 , 5.0 , 1.0 , -7.0] ++ bottomLeft [3.0 , 5.0 , 1.0 , -7.0] ++ bottomRight[3.0 , 5.0 , 1.0 , -7.0]  
          //[3.0 ,5.0 , 4.0 , 5.0  , 3.0 , -2.0 ,  4.0 ,  -2.0  ]
//Start = topLeft[2.0,8.0,-4.0,-7.0] ++  topRight[2.0,8.0,-4.0,-7.0] ++ bottomLeft[2.0,8.0,-4.0,-7.0] ++ bottomRight[2.0,8.0,-4.0,-7.0]
         // [-2.0,8.0,2.0,8.0,-2.0,1.0,2.0,1.0]
//Start = topLeft[1.0,6.0,4.0,2.0] ++  topRight[1.0,6.0,4.0,2.0] ++ bottomLeft[1.0,6.0,4.0,2.0] ++ bottomRight[1.0,6.0,4.0,2.0]
		  // [1.0,8.0,5.0,8.0,1.0,6.0,5.0,6.0]







/*2. Given a list of numbers, multiply every even number of the list by 2,
and every odd number of the list by 3*/

multiply :: [Int] -> [Int]
multiply [] = []
multiply [x:xs]
| x rem 2 == 0 = [x*2 : multiply xs]
= [x*3 : multiply xs]
//Start = multiply [14, 22, 45, 56] // [28, 44, 135, 112]
//Start = multiply [13, 27, 44] // [39, 81, 88]
//Start = multiply [] // []
 
 
 
 
 
 
 
/*
3. Given two lists of integers of the same length, 
check if the elements on the same positions in the two lists are of the same property: both even or both odd.
Return True for empty lists. */ 

same:: [Int] [Int]  -> Bool
same [] [] = True
same [x:xs] [y: ys]
|( ( x rem 2 == 0 && y rem 2 ==0 ) || (x rem 2 == 1 && y rem 2 == 1) ) && same xs ys = True
= False
//Start = same [1,2,3] [2,4,6] // False
//Start = same [1,2,3,4] [3,8,5,12] // True
//Start = same [] [] // True


 
 
 