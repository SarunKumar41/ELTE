definition module Q

import StdEnv, StdDebug

// define your implementation of Q here

::	Q  = { nom :: Int
         , den :: Int
         }  

mkQ :: Int Int -> Q

equalQ :: Q Q -> Bool

smallerQ :: Q Q -> Bool

plusQ :: Q Q -> Q

decrementQ :: Q Q -> Q

timesQ :: Q Q -> Q

divideQ :: Q Q -> Q

absoluteQ :: Q -> Q

signOfQ :: Q -> Int

negateQ :: Q -> Q

isIntQ :: Q -> Bool

IQ :: Int -> Q

QR :: Q -> Real
