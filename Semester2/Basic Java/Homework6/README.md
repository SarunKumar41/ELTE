
# Homework 6

## Exercise 1
We have a text file with each line containing one integer number and, after that, a list of integer numbers separated by commas.

Read the file and find the lines that contain a list of integers such that the sum of two of them is exactly the integer in the first column.

Write the result into a text file: Each line must contain the first integer in the input file and the two integers in the list that are its summands. If the list contains no such numbers print the string "none" after the first integer instead.

Example:

in.txt:

7 2,5,-7,6,9
-2 2,5,-7,6,9
12 2,5,-7,6,9
out.txt:

7 2 5
-2 5 -7
12 none

## Exercise 2
Create a program that prints characters to the standard output from some text file (in.txt)!

Read the number of characters to be printed from the standard input! An integer value can be provided as command line argument that specifies how many lines shall be skipped after each read character (use the skip() method of the BufferedReader class).

Use the BufferedReader class's read() method to read a file character-by-character!

Handle exceptions arising during reading, or parsing of the command line argument, and during reading from console (NoSuchElementException, InputMismatchException)!

## Exercise 3
Create a program using the NIO API. Read numbers from a text file called nums.txt using a BufferedReader object and print their parity to the file called out.txt using a BufferedWriter object. The resulting file shall look like this:

x is an even number
y is an odd number
where x and y are some integers. The input file has one integer per line. Use the try-with-resources idiom!

## Exercise 4
Create a simple Color enum with three values: RED , GREEN , BLUE .

Create a Car class, which contains the followings:

license plate ( String )
color ( Color )
maximal speed ( int )
Create a constructor which gets initial values for the fields specified above. The class should contain a counter, which increases every time a new Car is created.

Create a constructor without parameters, which creates a new object with values of AAA-000 , BLUE and 120 .

Create a class method which can compare two cars, it returns true if the first one is faster than the second.

Put the Color enum into the car.utils package and the Car class into the car package!

Create an input.txt file with cars in it, one car in every line, separated by commas. Example: ABC-123, RED, 100 DEF-456, BLUE, 140 GHI-789, GREEN, 50

Create a Main class outside of the packages, which will contain the tests. The main() method should read a file and store the cars in an array.

## Exercise 5
Create the Time class already known from the lectures. You can use any representation you like. Handle the exceptions and also create a method, which returns the time as String .

Create a Pizza class where every field is private and final . It has a total of four fields: one for its diameter ( double ), one for the toppings ( String[] ), one for the time it needs to be baked ( Time ) and another one for the delivery time ( Time ). Create a constructor which can calculate the baking time based on the diameter and the toppings by the following formula:

For every topping the sum of: - length of the topping multiplied by the diameter of the pizza (one second for each character in the topping and one second for each centimeter).

Example: A 32cm pizza with "cheese" toppings: 32*6 = 192 , which should be rounded upwards to 4 minutes. Constructor should throw an exception if a paramater is not valid. TypeNoePresentException should be thrown if the topping is not one of these: beef, cheese, corn, fish, ham, mushroom, salami, tomato . The TypeNotPresentException is a checked exception that should be handled by the caller. Use the throws keyword for this.

Create a Main class with a static method that can read orders from the file which name was given as a parameter. It should create every possible pizza, then calculates how long should the chefs cook that day. Handle the exceptions which can raise during Pizza creation.

Demonstrate the static methods in the main() function of the Main class!