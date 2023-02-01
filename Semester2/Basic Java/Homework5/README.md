
# Homework 5

## Exercise 1
Create an enumeration type Gender containing the two values Gender.MALE and Gender.FEMALE. Create class Person to hold personal data: surname, given name (both String), occupation (String), gender (Gender) and year of birth (int).

The class should have a constructor accepting initialisation values for all the attributes.

Create a method toString() in the class, with return type String. This method converts personal data to a formatted string.

Create a sameAs(Person that) method as well, which returns true if (and only if) the current person has the same personal data as the "Person that", passed as parameter. Be careful with a possibly null parameter. For such a parameter the method should return false.

The Person class and the Gender type should be in package person. Create a main program in package main. The main program should create two person objects, and checks whether they are the "same". The result of the comparison and the two objects should be printed on the standard output.

## Exercise 2
Create a class basics.Matrix, which represents matrices storing double values, with the following operations.

Construction of a matrix of size 𝑀×𝑁 containing zero elements.
Construction of a matrix of size 𝑀×𝑁, initialized in a row major order from an array (double[]) of length 𝑀⋅𝑁.
Construction of an identity matrix of size 𝑁×𝑁 implemented as a static method.
The transpose of a matrix.
The sum of two (equally sized) matrices.
The difference of two (equally sized) matrices.
The toString() method to represent the matrix textually. (Use the StringBuilder class!)
Create a main program to test the above operations!

## Exercise 3
Create a TelevisionShop enum. It's values are: SAMSUNG, LG, SKYWORTH, SONY, SHARP . First parameter in their constructors should be the number in stock, second and third are the minimal and maximal diagonal sizes available! Create methods that can return / print the minimal and maximal available television sizes regardless of the type (static) and one, which can print / return every size from a specific type! Create a static method which returns every information about the TVs in stock!

Use final whenever possible!

## Exercise 4
Extend the program written in Lab04 Exercise 2 with the following methods!

An append() method, which can add a new element to the end of the sequence. The implementation should create a new array, which is larger by one than the original array containing the numbers. The original sequence should be copied from the old array to the new array, and the parameter of append should also be written in the last element of the new array. This new array should become the new inner representation of the sequence.

A static sum() method, which takes two IntVector objects as parameters, and returns a third one, which is the element-wise sum of the parameter IntVectors.

## Exercise 5
Create JavaDoc for your code in Exercise 1-4. Comments should contain information about the method parameters and return values. Generate an HTML documentation!