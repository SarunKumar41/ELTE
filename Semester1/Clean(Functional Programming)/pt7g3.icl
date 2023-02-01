module pt7g3
import StdEnv

/* Given the list of tuples, where each tuple
 * contains name and the points of the student.
 * Write a function that adds 5 points to those
 * student's grades that have less than 50 points
 * and returns updated list.
 */
//task :: [(String, Int)] -> [(String,Int)]
//task [(x,y):ls] = [(x ,y+5) \\ x<- [(x,y):ls] & y <- [(x,y):ls] |  (y < 50) ]

task :: [(String, Int)] -> [(String,Int)]
task [] = []
task [(x,y) : ls]
| y< 50 = [(x,y+5) : task ls]
= [(x,y) : task ls]

//Start = task [("A",91),("B", 35),("C",78)] // [("A",91),("B", 40),("C",78)]
//Start = task [("A",91),("B", 35),("C",78),("D",12),("E",34)] // [("A",91),("B", 40),("C",78),("D",17),("E",39)]
//Start = task [] // []
//Start = task [("A",100),("B", 85),("C",78)] // [("A",100),("B", 85),("C",78)]
//Start = task [("A",12)] // [("A",17)]

tuplee ::  [Int] -> ([Int], [Int])
tuplee [] = ([],[])
tuplee x = (x, reverse x)

Start = tuplee [1,2,3,4,5]