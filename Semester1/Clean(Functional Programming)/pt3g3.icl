module pt3g3
import StdEnv

/*

Given 3 numbers: L, R and K. Find count of such numbers
that belong interval [L,R] and dividing them by K has
even result.
For example: 
if L, R and K are 1, 10 and 3, good numbers are:
1,2,6,7 and 8. They belong interval [1,10]
and 1/3==2/3==0, 6/3==7/3==8/3==2
hence for 1,10,3 answer woould be 5.*/


f :: Int Int Int -> Int
f l 0 k = []
f l r k 
| (l rem k) rem 2 == 0 = (+)1 + f (l+1) (r-1) k
= f (l+1) r k

Start = f 1 10 3 // 5
// Start = f 2 100 11 // 53
// Start = f 121 5215 52 // 2547
// Start = f 11 11 11 // 0

/*f :: Int Int Int -> [Int]
f l 0 k = []
f l n k
| (l rem k) rem 2 == 0 = foldr (+)0 [1 : f (l+1) (n-1) k)] 
= f (l+1) n k
Start = f 1 10 3 // 5*/