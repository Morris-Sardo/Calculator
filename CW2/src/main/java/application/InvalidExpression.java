package application;


/**
 * This class throws exception if invalid expression has been written..
 *
 * @author papap
 * @version $Id: $Id
 */
public class InvalidExpression extends Exception {

  /**
   * <p>Constructor for InvalidExpression.</p>
   *
   * @param string a {@link java.lang.String} object
   */
  public InvalidExpression(String string) {
    super(string);
  }

}
