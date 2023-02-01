module extrag3


import StdEnv
// extra pt 1
/* Write a record "Entry" that will have
 * 2 fields a string "key" and integer "value".
 * Write a function that takes an array of entries and
 * returns the array that contains all the keys from the entries.
 */
:: Entry = {key :: String, value :: Int}

keySet :: {Entry} -> {String}
keySet arr = {x.key\\x<-:arr}
//Start = keySet {{key="A", value=1},{key="B", value=2}} // {"A","B"}
//Start = keySet {{key="A", value=1},{key="B", value=2},{key="C", value=2}} // {"A","B","C"}
//Start = keySet {} // {}

// extra pt 2
/*
The type MyList represents a list data structure, every element holds the element after it as a child
Create a toString instance for this type that converts it to a string that looks like a list
Elem 4 (Elem 3 (Elem 2 (Elem 1 (Empty) ) ) ) should output "[4,3,2,1]"
*/

:: MyList a = Elem a (MyList a) | Empty

instance toString (MyList a) | toString a
where
	toString Empty = "[]"
	toString (Elem x nextChild) = "[" +++ toString x +++ (toStringAux nextChild)
		where
		toStringAux :: (MyList a) -> String | toString a
		toStringAux Empty = "]"
		toStringAux (Elem x nextChild)  = "," +++ (toString x) +++ (toStringAux nextChild)


list1 :: (MyList Int)
list1 = Elem 4 (Elem 3 (Elem 2 (Elem 1 (Empty) ) ) )

list2 :: (MyList Int)
list2 = Elem 2 (Elem 6 (Elem 6 (Elem 8 (list1) ) ) )

list3 :: (MyList Int)
list3 = Empty


//Start = toString list1 // "[4,3,2,1]"
//Start = toString list2 //"[2,6,6,8,4,3,2,1]"
//Start = toString list3 // "[]"


