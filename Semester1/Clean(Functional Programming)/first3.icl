module first3  // same as file name first3.icl
import StdEnv

//Start = 42

f :: Int -> Int

f x = x / 2

//Start = f 5

g :: Real -> Real

g x = x / 2.0

//Start = g 5.0

f2 :: Int Int -> Int

f2 x y = x + y

//Start = f2 3 4

f3 :: Int Int Int -> Int
f3 a b c = a + 3*b*c

//Start = f3 4 3 2

f3r :: Real Real Real -> Real

f3r a b c = a + 3.0*b*c

//Start = f3r 4.0 3.0 2.0

b :: Bool -> Bool

b x = not x

//Start = b True

st :: String String -> String
st a b = a +++ b

//Start = st "Hello" " World!"

c :: Char -> Char
c x = x

//Start = c '%' //c 'W'

quad :: Real Real Real Real -> Real
quad a b c x = a*x*x + b*x + c

//Start = quad 1.0 2.0 1.0 1.0

//Start = abs  0 //-4 // 4
myabs x
| x > 0 = x
| x == 0 = 0
| x < 0 = ~x

//Start = myabs -4 

//Start = myabs 4 

// isEven isOdd 

div2 :: Int -> Bool

div2 x = x rem 2 == 0  // rem -remainder

//Start = div2 6
//Start = div2 7

div22 :: Int -> Bool

div22 x = (x/2)*2 == x

//Start = div22 5 
//Start = div22 4


//Exercises lab 1
// 1. Define a function maxi with two arguments that delivers the maximum of the two.
maxi :: Int Int -> Int
maxi x y 
| x > y = x
= y            // x <= y

//Start = maxi 34 56

maxi1 :: Int Int -> Int
maxi1 x y 
| x > y = x
| x == y = x
| y > x = y       

//Start = maxi1 34 56


// 2. Define a function mini that has two arguments that delivers the minimum of the two.
mini :: Int Int -> Int
mini x y
| x < y = x
= y

//Start = mini 34 56


// 3. Triple a number.
triple :: Int -> Int
triple x = 3*x

//Start = triple 3


// 4. Check if a number is odd.
isoddnr :: Int -> Bool
isoddnr x = (x rem 2 == 1)

/*
isoddnr x
| x rem 2 == 0 = True
= False */

//Start = isoddnr 6
//Start = isoddnr 7


// 5. Check if a number is the sum of two other given numbers.
issum :: Int Int Int -> Bool

issum a b c = (b + c == a) || (a + c == b) || (a + b == c)

//Start = issum 10 6 3
//Start = issum 10 6 4
 
 
// 6. Add 100 to a number.
add100 :: Int -> Int

add100 a = 100 + a

//Start = add100 5


// 7. Check if a number is multiple of 10.
ismult10 :: Int -> Bool

ismult10 a = a rem 10 == 0

//Start = ismult10 20
//Start = ismult10 202

// 8. Add the numbers from 1..N in a recursive function.
//addn :: Int -> Int
//addn n = n + addn (n-1)

//Start = addn 5


// 9. Compute the cube of a number
cube :: Int -> Int

//cube x = x*x*x
cube x = x^3

//Start = cube 4


// 10. Check if an integer is even - in two ways. To divide integer use /, for remainder use rem
//even1 :: Int -> Bool


//Start = even1 34
//Start = even1 45

//version 2.
//even2 :: Int -> Bool


//Start = even2 34
//Start = even2 45


 //11. Add the digits of a number e.g. for 123 is 6
isum :: Int -> Int
isum x = x rem 10 + isum x/10

Start = isum 1234