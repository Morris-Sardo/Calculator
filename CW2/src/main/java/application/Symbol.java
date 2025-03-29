package application;

/**
 * This class is been used for mathematical symbol you can have in your calculator.
 *
 * @author papap
 * @version $Id: $Id
 */
public enum Symbol {
  LEFT_BRACKET("("), RIGHT_BRACKET(")"), TIME("*"), DIVISION("/"), PLUS("+"), MINUS("-"), INVALID(
      "invalid");

  private String string;

  Symbol(String string) {
    this.string = string;
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {

    return string;
  }
}
