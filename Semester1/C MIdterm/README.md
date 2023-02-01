
# Reverse Command

This is an implementation of the reverse command. The contents of files in command-line arguments or lines read from the console are printed to the standard output in reverse order with numbering and the lines mirrored.


## Usage

The program reads files given as command-line arguments. If an argument results in an error (i.e. file cannot be opened), it prints an error message (File opening unsuccessful!) to the standard error output and continues with the next argument. If no arguments are provided, the program reads lines from the standard input.

## Example

For example if the content of test.txt is this:

* apple
* peach
* plum

then the result of command reverse is:

3 mulp

2 hcaep

1 elppa

Example for multiple input files: if test.txt is given twice as command-line argument then the output is this:

3 mulp

2 hcaep

1 elppa

3 mulp

2 hcaep

1 elppa


## Implementation

* Dynamic array is used for storing lines. The array starts as a fixed value (e.g. 8), and doubles in size when the number of lines exceeds the current size.

* Memory allocation is checked and an error message (Memory allocation failed!) is printed if it is unsuccessful.

* The solution is separated into multiple translation units (.c and .h files).