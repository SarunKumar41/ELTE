/*Implement the Stack data structrure (Links to an external site.) in the following way.

A Stack stores int values.
It provides the following two operations:
push(): inserts an element into the top of the stack;
pop(): removes the element from the top of stack (the one which was last pushed), and returns this value.
Then, it has an empty() method to check whether the stack is empty.
Finally, its size() method returns the number of elements stored in the stack.
If pop() is called on an empty stack, the method should throw a java.util.NoSuchElementException.
Test the implementation using the learnt test environment in the following way. Check that

the element pushed last is the one which is popped first;
a freshly constructed stack is empty;
a stack containing one element is not empty;
it is not possible to pop from an empty stack (i.e. whether the exception is thrown);
the size() method works properly in corner cases (0, 1);
if the last element is popped, the stack becomes empty.
*/
import java.util.NoSuchElementException;

public class Stack 
{   
    private int arr[];
    private int top;
    
    Stack(int size) 
    {
      arr = new int[size];
      top = -1;
    }

    public void push(int x) 
    {
        top++;
        arr[top] = x;
    }

    public int pop() 
    {
      if (isEmpty()) 
      {
        throw new NoSuchElementException();
      }
      top--;
      return arr[top+1];
    }
 
    public int size() 
    {
      return (top + 1);
    }
  
    public Boolean isEmpty() 
    {
      return (top == -1);
    }

    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<top;i++) 
        { 
            sb.append("[").append(arr[i]).append(",");
        }
        sb.append(arr[top]).append("]");
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}