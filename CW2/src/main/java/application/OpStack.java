package application;

/**
 * This class create a stack using Enty Symbol. The functionality of the methods are to call the
 * methods of Stack class.
 * 
 * @author papap
 *
 */
public class OpStack {

  private Stack opStack; // This is been use to inherit the functionality of Stack class
  private Entry entry; // This to use to obtain a a symbol as entry symbol.

  /**
   * This constructor inizialize a stack obj such that all the method int it,they can be called.
   */
  public OpStack() {
    this.opStack = new Stack();

  }

  /**
   * This method retreave the capability of push one from Stack class.
   * 
   * @param symbol is a key variable from Enum class.
   */
  public void push(Symbol symbol) {
    entry = new Entry(symbol);
    opStack.push(entry);

  }

  /**
   * This method use simply the top Stack method.
   * 
   * @return the element of the top of the stack.
   * @throws EmptyStack is been thorws if stack is empty.
   * @throws BadType
   * 
   */

  public Symbol top() throws EmptyStack, BadType {

    return opStack.top().getSymbol();
  }

  /**
   * This method return the size of the stack.
   * 
   * @return size of stack.
   */
  public int size() {

    return opStack.size();
  }

  /**
   * This method return a symbol value using calling pop method from Stack classs.
   * 
   * @return Entry symbol value.
   * @throws EmptyStack exception if try retrieve symbol with empty stack.
   * @throws BadType is been throw if a bad type is insert
   */


  public Symbol pop() throws EmptyStack, BadType {


    return opStack.pop().getSymbol();

  }

}
