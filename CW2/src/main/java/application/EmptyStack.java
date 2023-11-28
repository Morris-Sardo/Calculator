package application;

/**
 * This class throws exception when try obtain element with empty stack.
 * 
 * @author papap
 *
 */
public class EmptyStack extends Exception {
  public EmptyStack(String string) {
    super(string);
  }

}
