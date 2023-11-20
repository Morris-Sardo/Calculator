package application;

/**
 * This class accepts a string expression and it return the result of the calculation.
 * 
 * @author papap
 *
 */
public class RevPolCalc {

  // private float result; //store the result of equasion.
  private NumStack number; // Used to to store the operand after converted in float.

  // addded
  // modofication of constructor. The cosnstructor wont take anymore the expression
  public RevPolCalc() {
    this.number = new NumStack();

  }

  /**
   * This method get equation is input and return the result of it.
   * 
   * @param expression is equasion to evaluate.
   * @return the valuer of espression after evaluated.
   * @throws EmptyStack exception is threw if try evaluate an expression with empty stack.
   * @throws BadType exception is threw is type is not right.
   */
  public float evaluate(String expression) throws InvalidExpression {


    try {
      String[] tokens = expression.split("\\s+"); // string splited between white space.

      number = new NumStack();
      for (String token : tokens) {
        if (token.matches("-?\\d+(\\.\\d+)?")) { // regex match integers and floating-point numbers
          number.push(Float.parseFloat(token));
        } else {
          float secondOperand = number.pop(); // pop the second operand first.
          float firstOperand = number.pop(); // pop first one.

          switch (token) {
            case "+":
              number.push(firstOperand + secondOperand);
              break;
            case "-":
              number.push(firstOperand - secondOperand);
              break;
            case "*":
              number.push(firstOperand * secondOperand);
              break;

            case "/":
              if (secondOperand == 0) {
                throw new InvalidExpression("Division by zero");
              } else {
                number.push(firstOperand / secondOperand);
              }
              break;
            default:
              throw new InvalidExpression("Invalid expression");

          }
        }
      }
      return number.pop();
    } catch (Exception e) {
      throw new InvalidExpression("Invalid expression");
    }
  }

}
