package application;

/**
 * This class ..
 * 
 * @author papap
 *
 */
public class RevPolCalc {

  private float result;
  private NumStack number;

  // addded
  public RevPolCalc(String expression) throws EmptyStack, BadType {
    this.result = evaluate(expression);

  }

  /**
   * 
   * @param expression
   * @return
   * @throws EmptyStack
   * @throws BadType
   */
  private float evaluate(String expression) throws EmptyStack, BadType {

    String[] tokens = expression.split("\\s+"); // string split substring based White space
                                                // character.
    number = new NumStack();

    for (String token : tokens) {
      if (token.matches("-?\\d+(\\.\\d+)?")) { // regex to match integers and floating-point numbers
        number.push(Float.parseFloat(token));
      } else {
        float secondOperand = number.pop(); // It's important to pop the second operand first
        float firstOperand = number.pop(); // because it's the first in the expression

        switch (token) {
          case "+":
            number.push(firstOperand + secondOperand);
            break;
          case "-":
            number.push(firstOperand - secondOperand);
            break;
        }
      }
    }
    return number.pop();
  }

  public float getResult() {
    return result;
  }

}
