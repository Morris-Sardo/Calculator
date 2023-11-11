package application;

/**
 * This class is...
 * 
 * @author papap
 *
 */

public class NumStack {

  private Stack numStack;
 

  public NumStack() {
    this.numStack = new Stack();
  }

  /**
   * This metod is responsible to add and entry float into stack.
   * 
   * @param number is a paramenter to add all the number into calulator.
   */

  public void push(float number) {
    Entry entry = new Entry(number);
    numStack.push(entry);

  }

  /**
   * This method is use to return the element on the top of the stack.
   * 
   * @return element at the top of the stack.
   * @throws EmptyStack is exception throw everytime you try retreave a number with empty stack.
   */
  public Entry top() throws EmptyStack {
    
    return numStack.top();
  }
  
  
  public Integer size() {
   
    return numStack.size();
  }

  public Entry pop() throws EmptyStack {
    return numStack.pop();
  }

}
