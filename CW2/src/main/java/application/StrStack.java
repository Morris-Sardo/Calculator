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

    this.numStack = new Stack();

  }

  /**
   * This method get entry as parameter and store it into ste stack.
   * 
   * @param entry is a string.
   */

  public void push(Entry entry) {
    
    numStack.push(entry);


  }
  
  



}
