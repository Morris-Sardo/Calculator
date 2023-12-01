package application;

import java.text.DecimalFormat;

/**
 * This class accepts a string expression and it return the result of the calculation.
 * 
 * @author papap
 *
 */
public class RevPolCalc implements Calculator {

  // private float result; //store the result of equation.
  private NumStack number; // Used to to store the operand after converted in float.
  // private DecimalFormat df = new DecimalFormat();

  // Added
  // Modification of constructor. The constructor wont take anymore the expression
  public RevPolCalc() {
    this.number = new NumStack();

  }

  /**
   * This method get equation is input and return the result of it.
   * 
   * @param expression is equation to evaluate.
   * @return the valuer of expression after evaluated.
   * @throws InvalidExpression if the expression is not right format.
   */
  @Override
  public float evaluate(String expression) throws InvalidExpression {

    // df.setMinimumFractionDigits(2);


    try {
      String[] tokens = expression.split("\\s+"); // string splitted between white space.


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
              if (secondOperand == 0) { // base case if device by zero.
                throw new InvalidExpression("Division by zero");
              } else {

                // float num = (float) (Math.round((firstOperand / secondOperand) * 100.0) / 100.0);
                // number.push(num);
                number.push(firstOperand / secondOperand);
              }
              break;
            default:
              throw new InvalidExpression("Invalid expression");

          }
        }
      }

      if (number.size() != 1) { // base case if the end computation stack if different then zero.
        throw new InvalidExpression("Insufficient operators");
      }


      return (float) (Math.round(number.pop() * 100.0) / 100.0);
    } catch (Exception e) { // use to handle emptystack exception.
      throw new InvalidExpression("Invalid expression");
    }
  }

}
