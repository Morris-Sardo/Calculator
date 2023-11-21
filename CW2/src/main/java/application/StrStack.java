package application;

/**
 * This class create a stack using Enty number. The functionality of the methods are to call the
 * methods of Stack class.
 * 
 * @author papap
 *
 */
public class StrStack {

  private Stack numStack; // use to store entry string.

  /**
   * This conctructor inizialize Srtack.
   */
  public StrStack() {

    this.numStack = new Stack(); // It use to call all methods required in the Stack class.

  }

  /**
   * This method get entry as parameter and store it into ste stack.
   * 
   * @param entry is a string.
   */

  public void push(Entry entry) {

    numStack.push(entry);


  }

  /**
   * This method retrive the element on the top of the stack.
   * 
   * @return entry in the top of the stack.
   * @throws EmptyStack throws exception if entry type is not a string.
   */

  public Entry top() throws EmptyStack {

    return numStack.top();
  }

  /**
   * This method retrieve the element of the trop of the stack.
   * 
   * @throws EmptyStack will throw an exception every time you pop but stack is empty.
   */
  public void pop() throws EmptyStack {

    numStack.pop();


  }

  /**
   * The meaning of thi method is retreave the size of the stack.
   * 
   * @return the size of the stack at the actual time.
   */
  public int size() {

    return numStack.size();
  }



}
