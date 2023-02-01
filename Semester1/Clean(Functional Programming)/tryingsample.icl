module tryingsample
import StdEnv

primeInt :: Int -> Bool
primeInt 1 = False
primeInt x
| length [x rem (x-1) == 0] <= 2 = True
= False
Start = 7