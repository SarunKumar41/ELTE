
# Homework 8

## Exercise 1
Prerequisites: Point.java, and Circle.java from lab 6, task 4.

Task: Create the ColouredPoint class, which extends Point. Add a nested enum called ColouredPoint.Colour, with the following values: RED, GREEN, BLUE. The ; class has a private Colour field, provide public read/write access to this field. Additionally, create a ColouredCirlce class inheriting Circle. The colour of the circle is determined by its center stored as a ColouredPoint instance, provide a getter for the colour. Test the two newly created classes with white-box principals.

## Exercise 2
In this exercise, we'll be simulating a cafe. For this, we need a Barista who'll be serving our Guests. There are two types of guests: Adult and Minor, both inherit Guest. The barista servers Beverages to guests.

First, implement the Beverage class with the following fields:

name, a non-empty string
legalAge, a positive integer
Create a constructor that receives these values and sets them, throw an IllegalArgumentException if either field is incorrect. Additionally, create getters for them.

The Guest class has two protected visibility fields:

name, string
age, int
Both of these fields should have getters.

The barista has a public method called order, it takes a Beverage and a Guest as parameters and returns a boolean value. It's false when the legalAge of a drink is 18 and the Guest isn't an Adult

## Exercise 3
Write a Stream class that will produce character sequences, and a Logger which will log these strings.

The Logger class has a single function with no return value:

log, it takes a String parameter, leave it's body empty
The Stream class takes the following arguments and stores the as private fields, throw an IllegalArgumentException if an argument is incorrect:

The maximum length of a char-sequence (maxStringLenght)
The number of strings to generate (stringNumber)
A Logger which receives the generated strings
First, create a public startStreaming function, which calls Logger::log stringNumber times with the generated random string.

Create 3 subclasses of Logger: ConsoleLogger, ConsoleCipherLogger, and FileLogger. Each subclass should override the log function.

ConsoleLogger::log prints received string to standard out.
ConsoleCipherLogger::log is identical to ConsoleLogger but it "encrypts" the string with a Caesar cipher.
FileLogger::log writes the received strings to a file, line by line
The Main class tests these classes.

