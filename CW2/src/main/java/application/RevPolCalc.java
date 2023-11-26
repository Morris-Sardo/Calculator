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
  @Override
  public float evaluate(String expression) throws InvalidExpression {


    try {
      String[] tokens = expression.split("\\s+"); // string splited between white space.


      for (String token : tokens) {
        if (token.matches("-?\\d+(\\.\\d+)?")) { // accept integers and floating-point numbers.


          number.push(Float.parseFloat(token));

        } else {
          float secondOperand = number.pop(); // pop the second operand first.
          float firstOperand = number.pop(); // pop first one.


          // evaluate different operations.
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
              if (secondOperand == 0) { // base case if devide by zero.
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

      if (number.size() != 1) { // base case if the enad couptation stack if different then zero.
        throw new InvalidExpression("Insufficient operators");
      }


      return number.pop();
    } catch (Exception e) { // use to hadle emptystack exception.
      throw new InvalidExpression("Invalid expression");
    }
  }

}
