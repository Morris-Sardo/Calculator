package application;


/**
 * This class create a stack using Enty number. The functionality of the methods are to call the
 * methods of Stack class.
 *
 * @author papap
 *
 */

public class NumStack {

  private Stack numStack; // use to call to store numbres into stack.

  private Entry entry; // it to add numver in Stack.


  /**
   * This constructor use to initialize the object stack.
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
   * @throws BadType exception has been throws if entry is not the right one.
   */

  public float top() throws EmptyStack {

    try {
      return numStack.top().getFloat();
    } catch (BadType e) {
      e.printStackTrace();
      return -1;
    }
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
   * This method is use to return the element on the top stakc and decrease it of one.
   * 
   * @return element of the top of stack.
   * @throws EmptyStack exception threw if try retreave alement with empty stack.
   */
  public float pop() throws EmptyStack {
    try {
      return numStack.pop().getFloat();
    } catch (BadType e) {
      e.printStackTrace();
      return -1;
    }

  }


}
