module testing

import StdEnv 

:: LinkedList a = Node a (LinkedList a) | Tail

list0 = Tail
list1 = Node 5 Tail
list2 = Node 2 (Node 5 Tail)
list3 = (Node 2 (Node 3 (Node 4 (Node 12 (Node 34 (Node 1 Tail))))))

/*
Write a function that takes a list as an
argument and returns the LinkedList with
same values in same order.
For example: [] -> Tail
             [1] -> Node 1 Tail
             [5,6] -> Node 5 (Node 6 Tail)
             and so on.
*/

listToLinkedList :: [a] -> (LinkedList a)
listToLinkedList [] = Tail
listToLinkedList [x:xs] = Node x (listToLinkedList xs) 

// Start = listToLinkedList [] // Tail
//Start = listToLinkedList [5] // (Node 5 Tail)
//Start = listToLinkedList [2,5] // (Node 2 (Node 5 Tail))
//Start = listToLinkedList [2,3,4,12,34,1] // (Node 2 (Node 3 (Node 4 (Node 12 (Node 34 (Node 1 Tail))))))



/*
Write '+' operator for lists.
If both lists are sorted in increasing order you should merge them
in a way that resulting list is sorted too.
Ex.: [1,3,6] + [2,4,5,7] -> [1,2,3,4,5,6,7]
If list is not sorted than it is considered empty.
Ex.: [1,3,6] + [2,3,1] -> [1,3,6] + [] -> [1,3,6]
Ex.: [2,9,7] + [5,4,3] -> [] + [] -> []


isSorted :: [Int] -> Bool
isSorted list = (sort list == list)

instance + [Int]
where
	(+) [x:xs] [y:ys]
	| (isSorted [x:xs]) && (isSorted [y:ys]) && x <= y = merge [x:xs] [y:ys]
	| isSorted [x:xs] 
	

Start = [1,2,3] + [1,3,6] // [1,1,2,3,3,6]
//Start = [1,3,6] + [2,4,5,7] // [1,2,3,4,5,6,7]
//Start = [1,3,6] + [2,3,1] // [1,3,6]
//Start = [5,1] + [1,3,6] // [1,3,6]
//Start = [] + [1] // [1]
//Start = [2,3,1] + [12,3,1] // []
//Start = [] + [] // []
*/