package application;

/**
 * The meaning of this class is add or retrive String form stack. All the method will call the
 * method of the stack to work.
 * 
 * @author papap
 *
 */
public class StrStack {

  private Stack numStack; // use to store entry string.
  private Entry entry; // use to convert string string to Entry one.
  private String string; // varible use as to enntry string.

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
   * The meaning of thi method is retreave the size of the stack.
   * @return the size of the stack at the actual time.
   */
  public int size() {

    return numStack.size();
  }



}
