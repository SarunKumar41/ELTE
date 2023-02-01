module HW6
import StdEnv 



/*1. Given the list of integers, modify it in a following way:
I. Remove all numbers which are multiple of 3
II. Sort remaining list in descending order
III. Swap 1st and 2nd elements, 3rd and 4th, 5th and 6th and so on.
*/

removemultiple :: [Int] -> [Int]
removemultiple xs = [a \\ a<- xs | a rem 3 <> 0]
//Start = removemultiple [4,2,2,1,23,3,6,3,76,3,30,36,45,1,6,8,9,10,11,12] 

sortdesc :: [Int] -> [Int]
sortdesc xs = [a \\ a <- reverse(sort(xs))]
//Start = sortdesc [1,2,3,4,5,5,6,67,8,9,29,292,2929,27,534]

listpair :: [Int] -> [Int]
listpair [] = []
listpair xs = reverse(take 2 xs) ++ listpair (drop 2 xs) 
//Start = listpair [1,2,3,4,5,6,7,8] 

shuffleSort :: [Int] -> [Int]
shuffleSort xs =  listpair (sortdesc (removemultiple xs)) 
 
//Start = shuffleSort [4,3,2] // [2,4]
//Start = shuffleSort [4,1,3,2,5,6,7] // [5,7,2,4,1]
//Start = shuffleSort [3,6,3,9,12] // []
//Start = shuffleSort [2,4,5,7,14,17] // [14,17,5,7,2,4]
//Start = shuffleSort [] // []
 

// 2. Calculate Euler's totient function phi(m).
// Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r < m) that are coprime with m.
// Example: m = 10: r = 1,3,7,9; thus phi(m) = 4. Note the special case: phi(1) = 1.
// Two integers a and b are coprime, if the only positive integer that divides (is a divisor of) both of them is 1.

coprimelist :: Int -> [Int]
coprimelist m = [gcd a m \\ a<-[1..m] | (gcd a m) == 1]
//Start = coprimelist 10

phi :: Int -> Int
phi 1 = 1 
phi m = length(coprimelist m)

//Start = phi 1 // 1
//Start = phi 10 // 4
//Start = phi 12414 // 4136
//Start = phi 100 // 40
//Start = phi 1000000 // 400000
 

// 3.
// Write function that takes String as input and removes vowels from it

removevow :: [Char] -> [Char]
removevow [] = []
removevow [c:ch]
| (c<>'a') && (c<>'e') && (c<>'i') && (c<>'o') && (c<>'u') = [c : removevow ch]
= removevow ch
//Start = toString (removevow ['a','b','c'])

charlist :: String -> [Char]
charlist ch = [a \\ a<-:ch]
//Start = charlist "apple"

removeVowels :: String -> String
removeVowels remaining = toString [ strin \\ strin <-: toString (removevow (charlist(remaining)))]

//Start = removeVowels "Xola" // "Xl"
//Start = removeVowels "Functional Programming" // "Fnctnl Prgrmmng"
//Start = removeVowels "Clean is the best" // "Cln s th bst"
//Start = removeVowels "Not really" // "Nt rll"
//Start = removeVowels "" // ""
//Start = removeVowels "N vwls hr" // "N vwls hr"