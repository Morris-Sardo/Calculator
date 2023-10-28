package application;

import java.util.ArrayList;
import java.util.List;



/**
 * This class is responsible to add, retrive specific values in specific point of a stack.
 * 
 * @author papap
 *
 */
public class Stack {

  private List<Entry> entries = new ArrayList<>(); // Use to store all the entry.
  private int size = 0; // Use as index of the array.


  /**
   * This method add alement on the top of the stack.
   * 
   * @param entry can be float, Integero or mathematical symbol.
   */
  public void push(Entry entry) {

    this.entries.add(entry); // Add element at the top of stack.
    this.size++; // Now size has beee increase.

  }



  /**
   * This method is responsible to keep track of dimention of the stack.
   * 
   * @return number of element store into tthe stack.
   */
  public int size() {
    return size;
  }



  /**
   * This method return the element top of stack.
   * 
   * @return element at the top of stack.
   * @throws EmptyStack accure when try obtain element with empty stack.
   */
  public Entry top() throws EmptyStack {
    if (size == 0) { // Base case(Exception if stack is empty).
      throw new EmptyStack("Stack is Empty");
    } else {
      return entries.get(size - 1);
    }
  }



  /**
   * This method obtain and remove elemenent at top of stack.
   * 
   * @return element at the top of the stack.
   * @throws EmptyStack accure if stack has not enough element.
   */
  public Entry pop() throws EmptyStack {
    if (size == 0 || size == 1) { // Base case(Exception if stack less then 1 element).
      throw new EmptyStack("Stack is Empty");
    } else {

      Entry tmp = entries.get(size - 1); // It is use to store the element temporarily.
      entries.remove(size - 1); // Remove element at the top stak.
      size--; // decrease size - 1.
      return tmp;
    }
  }
}


