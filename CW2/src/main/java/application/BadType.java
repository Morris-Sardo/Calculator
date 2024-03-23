package application;

/**
 * This class throws exception when a type insert is wrong.
 *
 * @author papap
 * @version $Id: $Id
 */
public class BadType extends Exception {
  /**
   * <p>Constructor for BadType.</p>
   *
   * @param string a {@link java.lang.String} object
   */
  public BadType(String string) {
    super(string);
  }

}
