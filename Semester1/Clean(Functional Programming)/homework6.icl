module homework6
import StdEnv


/*
1. Given a list of triples consist of three integers, write a function which sorts it and 
returns list of triples. 

*/

make_tuples :: [Int] -> [(Int,Int,Int)]
make_tuples [] = []
make_tuples [a,b,c:as] = [(a,b,c):make_tuples as]

make_list :: [(Int,Int,Int)] -> [Int]
make_list [] = []
make_list [(a,b,c):as] = [a,b,c:make_list as]

sort_tuples :: [(Int,Int,Int)] -> [(Int,Int,Int)]
sort_tuples tuples = make_tuples (sort (make_list tuples))



//Start = sort_tuples [] // []
//Start = sort_tuples [(2,3,1),(12,3,2),(70,13,0),(28,34,1),(2,4,241)] // [(0,1,1),(2,2,2),(3,3,4),(12,13,28),(34,70,241)]
//Start = sort_tuples [(100,200,300),(30,24,13)] // [(13,24,30),(100,200,300)]


/*
2. Given an array of tuples of lists. Write a function that returns a list of arrays in the 
following form. If it is an empty list, write 0 in the array. If the list has one or 
more than one element, write sum of elements in the array. 

 {([2],[1,3,4]),([3],[4]),([5,4,1],[])} -> [{2,8},{3,4},{10,0}]

*/

checkAndWrite :: [Int] -> Int
checkAndWrite [] = 0
checkAndWrite list = sum list

flatten_tuple :: ([Int],[Int]) -> {Int}
flatten_tuple (a,b) = {checkAndWrite a, checkAndWrite b}

listToArr :: [Int] -> {Int}
listToArr list = {x \\ x <- list}

conversionArrayToList :: {([Int],[Int])} -> [{Int}]
conversionArrayToList arr = [flatten_tuple tuple \\ tuple <-: arr]


//Start = conversionArrayToList {([2],[1,3,4]),([3],[4]),([5,4,1],[])} // [{2,8},{3,4},{10,0}]
//Start = conversionArrayToList {([],[]),([3,4,5,6],[7,8,9,10])} // [{0,0},{18,34}]
//Start = conversionArrayToList {([1],[2]),([],[10,11,20]),([0,0],[]),([1,2],[101])} //[{1,2},{0,41},{0,0},{3,101}]


/*
3. Given a string. Write a function which modifies uppercase character to lowercase and
lowercase characters to uppercase.
*/

change :: Char -> Char
change ch
|isUpper ch = toLower ch
= toUpper ch

caseSwitch :: String -> String
caseSwitch word = toString [ change char  \\ char <-:word]


//Start = caseSwitch "BanaNa" // "bANAnA"
//Start = caseSwitch "Abraham Lincoln" // "aBRAHAM lINCOLN"
//Start = caseSwitch "elte21" // "ELTE21"

