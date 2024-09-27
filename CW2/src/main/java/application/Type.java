package application;

/**
 * This class has been used for different kind of type you can have in your calculator.
 * 
 * @author papap
 *
 */
public enum Type {
  FLOAT("It is float number"), STRING("It is a Strings"), SYMBOL(
      "It is mathematical operator"), INVALID("It is invalid input");

  private String string;            //Use to store variable string.

  Type(String string) {             
    this.string = string;           //Inizialization  of variable string..

  }

  @Override
  public String toString() {        //Keep override the string.
    return string;

  }

}
