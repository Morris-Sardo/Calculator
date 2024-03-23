package application;

/**
 * This class throws exception when try obtain element with empty stack.
 *
 * @author papap
 * @version $Id: $Id
 */
public class EmptyStack extends Exception {
  /**
   * <p>Constructor for EmptyStack.</p>
   *
   * @param string a {@link java.lang.String} object
   */
  public EmptyStack(String string) {
    super(string);
  }

}
