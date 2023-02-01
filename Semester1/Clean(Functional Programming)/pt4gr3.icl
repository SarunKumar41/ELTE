module pt4gr3 

import StdEnv

/*
1.Given a list of tuples, where the first element is a number
and the second is a string. Return the list of strings from tuples where first element
is even.
*/

stringInEven :: [(Int,String)] -> [String]
stringInEven [] = []
stringInEven [(x,y) : ls] = [y \\ y <- (x,y) | x rem 2 == 0]

Start = stringInEven [(1,"A"), (2,"B"), (3,"C"), (11,"D"), (3,"E"), (5,"F")] // ["B"]
//Start = stringInEven [(1,"A"), (2,"B"), (3,"C"), (2,"D"), (8,"E"), (5,"F")] // ["B","D","E"]
//Start = stringInEven [(1,"A"), (2,"B"), (10,"F")] // ["B","F"]
//Start = stringInEven [(1,"A"), (3,"B"), (5,"F")] // []

