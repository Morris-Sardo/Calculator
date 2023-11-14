package application;

/**
 * This class implement stack using only Entry number. The class in each method it call
 * 
 * 
 * @author papap
 *
 */

public class NumStack {

  private Stack numStack; //  use to call to store numbres into stack.
  private Entry entry;

  /**
   * Yhis constructor use to initialize the object stack.
   */
  public NumStack() {
    this.numStack = new Stack();
  }

  /**
   * This metod is responsible to add and entry float into stack, calling pop method of Stack class.
   * 
   * @param number is a paramenter to add all the number into calulator.
   */

  public void push(float number) {
    entry = new Entry(number);
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

  /**
   * This method keep track of of the dimention of the stack.
   * 
   * @return number of the element into the stack.
   */
  public int size() {

    return numStack.size();
  }

  /**
   * This method retun the element on the top of stack calling the pop method int.
   * 
   * @return obtain and return element on the stack.
   * @throws EmptyStack throw exception if element is in the first r second porsiozion
   */
  public Entry pop() throws EmptyStack {
    return numStack.pop();
  }

}
