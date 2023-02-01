module firsthw1
import StdEnv 
/*
1- write GetLastPositive function which returns the last digit of the number if its positive 
and -1 if the number is negative
*/
GetLastPositive :: Int -> Int 
GetLastPositive a
|a >= 0 = x rem 10
= -1

Start = GetLastPositive 5856 // 6  
//Start = GetLastPositive 689255 // 5
//Start = GetLastPositive 0 // 0
//Start = GetLastPositive 8 // 8
//Start = GetLastPositive -8554 // -1
 
 
 
 

/*
2- Given two real numbers decide whether  the sum of the two numbers after the decimal points  of the two numbers is Even or not
assume there is only one number after the decimal point  
Hint : You can use (toInt) function .  
 
*/

deci ::Real -> Int
deci d = toInt(d*10.0) rem 10

IsEvenDecimal :: Real Real -> Bool 
IsEvenDecimal a b = (deci a + deci b)rem 2 == 0

//Start = IsEvenDecimal 5.3 4.6 // False
//Start = IsEvenDecimal 4.1 4.6 // False
//Start = IsEvenDecimal 1.2 6.6 // True




// 3-  Write a function that will take a digit (Int)
 
// and return the respective word for it (String).
// For example input of 1 should output One; input of 0 should output Zero; input of 5 should output Five.
// Anything that is not the digit (0-9) should output "Not a digit"
 
 
digit_to_string :: Int -> String
digit_to_string x
|x == 0 = "Zero"
|x == 1 = "One"
|x == 2 = "Two"
|x == 3 = "Three"
|x == 4 = "Four"
|x == 5 = "Five"
|x == 6 = "Six"
|x == 7 = "Seven"
|x == 8 = "Eight"
|x == 9 = "Nine"
= "Not a digit"
 
Start = digit_to_string 4 //"Four"
Start = digit_to_string 0 //"Zero"
//Start = digit_to_string 5 //"Five"
//Start = digit_to_string 10 //"Not a digit"
//Start = digit_to_string -1 //"Not a digit"
//Start = digit_to_string 42 //"Not a digit"