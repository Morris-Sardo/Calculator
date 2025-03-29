package application;



/**
 * This class manage initialisation if type plus comparison plus if input is proper insert.
 * 
 * @author papap
 *
 */
public class Entry {
  
  //Try test...
  private String str; // Use to store string.
  private float number; // Use to store float number.
  private Type type; // Use to store the type.
  private Symbol other; // Use to store the symbol.

  /**
   * Constructor use for matching string with data type String.
   * 
   * @param string is use to initialise the input from the user.
   */
  public Entry(String string) {
    this.str = string; // Initialisation field string.
    this.type = Type.STRING; // Initialisation field type.
  }

  /**
   * Constructor use for matching float number with data type float.
   * 
   * @param value is use to initialise float input from user.
   */
  public Entry(float value) {
    this.number = value; // Initialisation field float number.
    this.type = Type.FLOAT;
  }

  /**
   * Constructor use for matching mathematical operator with data type symbol.
   * 
   * @param which is variable use to initialise a variable symbol.
   */
  public Entry(Symbol which) {
    this.other = which; // Initialisation field mathematical symbol.
    this.type = Type.SYMBOL;
  }

  /**
   * This method use to obtain a string needed by other class.
   * 
   * @return str is value inserted by the user.
   * @throws BadType ensures that method return only a string.
   */
  public String getString() throws BadType {
    if (type != Type.STRING) { // Base case(If two type are not the same).
      throw new BadType("It is not a string");
    } else {

      return str;
    }
  }

  /**
   * This method use to obtain number(float one) needed by other class.
   * 
   * @return float number inserted by the user.
   * @throws BadType ensures that method return only a flaot number.
   */
  public float getFloat() throws BadType {
    if (type != Type.FLOAT) { // Base case.
      throw new BadType("It is not a float number");
    } else {

      return number;
    }
  }

  /**
   * This method use to obtain mathematical symbol by other class.
   * 
   * @return mathematical symbol insert by the user.
   * @throws BadType ensure that method return only mathematical symbol.
   */
  public Symbol getSymbol() throws BadType {
    if (type != Type.SYMBOL) { // Base case.
      throw new BadType("the symbol is wrong");
    } else {

      return other;
    }
  }

  /**
   * This method is been use obtain the input by user.
   * 
   * @return argument of the enum used verified when try to obtain value, string, symbol.
   */
  public Type getType() {

    return type;
  }



  /**
   * This method use for comparing two object and assigning with they assigning integer.
   *
   */
  @Override
  public int hashCode() {

    int result = 17; // It is a arbitrary number.
    if (type == Type.FLOAT) { // Base case.
      result = 31 * result + Float.hashCode(number); // integer calculated from float number.
    } else if (type == Type.STRING) { // Base case.
      result = 31 * result + str.hashCode(); // Integer calculated from float number.
    } else if (type == Type.SYMBOL) { // Base case.
      result = 31 * result + other.hashCode(); // integer calculated from float number.
    }
    return result; // return integer.

  }

  /**
   * This method is been to compare two object.
   * 
   * @param o is a object used for comparison.
   * @return false is two object are different type is null otherwise true.
   */
  public boolean equal(Object o) {
    if (o == null) { // Base case(Object null).
      return false;
    }
    if (o.getClass() != this.getClass()) { // Base case(Different type).

      return false;
    }
    Entry other = (Entry) o; // cast object o to Entry
    return this.type == other.type;
  }


}
