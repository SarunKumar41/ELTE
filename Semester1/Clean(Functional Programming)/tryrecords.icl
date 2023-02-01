module tryrecords
import StdEnv
:: Person = { name :: String
            , birthdate :: (Int,Int,Int)
			, fpprogramer :: Bool }
GetName :: Person → String
GetName p = p.name
GetName2 :: Person → String
GetName2 {name} = name
ChangeN :: Person String → Person
ChangeN p s={p & name=s}
Start = ChangeN {name = "XY", birthdate = (1,1,2000), fpprogramer = True} "Alex"