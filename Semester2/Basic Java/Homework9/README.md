
# Homework 9

## Exercise 1
Make a data structure representing a list of whole numbers, and call it IntList.

* a 
 Implement an IntList with an array.

It stores these fields:

currentSize: int
maxSize: int
array: int[]
The constructor gets the max size as a parameter.

The class proivdes the following methods:

add takes and int and stores it in our list
concat takes another IntList instance and adds it's contents to the end of this list, provided this list has sufficent capacity. If the current list doesn't have enough capacity, throw an IllegalStateException.
removeItemsGreaterThan takes an int (limit), and removes every element that's greater than the limit.
Override toString to show a comma-separated list of numbers found in our IntList. If the list is empty print 'empty'.

* b
Implement the same IntList but this time it should be backed by either an ArrayList or a LinkedList. (What are some of the benefits of this implementation over the one from A)) Additionally create a constructor that initializes the IntList with an integer array. Write a getData() method returning the stored integers. Take care do not let the internal state out from the object.

* c
Extend the IntList class from sub-task B). Call it NamedIntList and add a name (String) field. Add a name parameter to both constructors. Finally, override the toString method inherited from it's super class to indicate the name of the NamedIntList.

## Exercise 2
Write a function returning the letter statistics of the parameter string: contains the number of occurrences for each letter in the string. Use Java's HashMap data structure where the keys are the string's characters, values are the key's occurrences. For example for the input string "Helloworld" one possible ouput is "r(1)d(1)e(1)w(1)H(1)l(3)o(2)" (the order doesn't matter now).

## Exercise 3
Write a function getting an ArrayList of strings and returning a copy which doesn't include those strings whose length are an even number.