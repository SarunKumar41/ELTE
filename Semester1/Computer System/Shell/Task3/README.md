
# Task 3

Create a shell script 3.sh which waits a file name from the command line (use parameter) and count how many integer numbers contains digit 3 in the file. 
Check the file existance. If there is no file - write an error message!  



## Example implementation

Suppose the name of the file is 3.sh then, it should work in the following way when the input file name is mixed.txt 



| Input(File Content)  &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|       Expected Output |              
| --------------------------------- | ------------------------ |
|   apple       |           not an integer |
| a3pple  |          not an integer, but there is 3 in it  |
| 13    |                             integer and digit 3 |
| 3 |  1 |
| xxxx.txt  | no such file    |


