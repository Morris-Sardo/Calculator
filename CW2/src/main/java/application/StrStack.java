package application;

/**
 * This class create a stack using Entry number. The functionality of the methods are to call the
 * methods of Stack class.
 * 
 * @author papap
 *
 */
public class StrStack {

  private Stack numStack; // use to store entry string.

  private Entry entry; // use to convert string string to Entry one.

  /**
   * This constructor initialise StrStack.
   */
  public StrStack() {

    this.numStack = new Stack(); // It use to call all methods required in the Stack class.

  }

 
  /**
   * This method add a string into the Stack.
   * @param string is value used to type in the initial expression.
   */
  //Modification. Change Argument ..
  public void push(String string) {
    
    entry = new Entry(string);
    numStack.push(entry);


  }

  /**
   * This method retrieve the element on the top of the stack.
   * 
   * @return entry in the top of the stack.
   * @throws EmptyStack throws exception if entry type is not a string.
   * @throws BadType  is throws exception is there is not the right one.
   */
  
  //Modified..refactor. Change type return from Entry to String one.
  public String top() throws EmptyStack, BadType { 

    return numStack.top().getString();
  }

  /**
   * This method retrieve the element of the top of the stack.
   * 
   * @throws EmptyStack will throw an exception every time you pop but stack is empty.
   * @throws BadType  is bees throw it when type is not the right one.
   */
  
  //Modified..
  public String pop() throws EmptyStack, BadType {

    return numStack.pop().getString();


  }

  /**
   * The meaning of the method is retrieve the size of the stack.
   * 
   * @return the size of the stack at the actual time.
   */
  public int size() {

    return numStack.size();
  }



}
