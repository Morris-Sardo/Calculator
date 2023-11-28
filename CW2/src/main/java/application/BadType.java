package application;

/**
 * This class throws exception when a type insert is wrong.
 * 
 * @author papap
 *
 */
public class BadType extends Exception {
  public BadType(String string) {
    super(string);
  }

}