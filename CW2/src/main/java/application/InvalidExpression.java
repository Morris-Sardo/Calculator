package application;


/**
 * This class throws exception if invalid expression has been written..
 * 
 * @author papap
 *
 */
public class InvalidExpression extends Exception {

  public InvalidExpression(String string) {
    super(string);
  }

}
