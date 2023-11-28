package application;

/**
 * This class throws exception if en envalid expression has been written..
 * 
 */

public class InvalidExpression extends Exception {

  public InvalidExpression(String string) {
    super(string);
  }

}
