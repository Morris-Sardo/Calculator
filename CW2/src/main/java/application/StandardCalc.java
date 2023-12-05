package application;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * This class implement the calculation in form by using Standard form.
 * 
 * @author papap
 *
 */
public class StandardCalc implements Calculator {

  private RevPolCalc rpCalc; // used to calculate expression

  public StandardCalc() {
    this.rpCalc = new RevPolCalc();
  }

  /**
   * This method get equation is input and return the result of it.
   * 
   * @param expr is equation to evaluate.
   * @return the value of expression after evaluated.
   * @throws InvalidExpression if the expression is not right format.
   */
  @Override
  public float evaluate(String expr) throws InvalidExpression {
    Map<Character, Integer> precedence = new HashMap<>();
    precedence.put('+', 1);
    precedence.put('-', 1);
    precedence.put('*', 2);
    precedence.put('/', 2);
    precedence.put('(', -1);
    precedence.put(')', -1);

    StringBuilder output = new StringBuilder();
    Deque<Character> stack = new LinkedList<>();


    // loop use to convert the expression form normal to reverse one.
    // the conversion is been handle by hashmaps that in base of the priority assigned to the
    // operators it decide in collaboration with queue when adding into StringBuilder.
    // The parenthesis won't be added in the BuilderString.
    // Is been throw exception if the the parenthesis are not matched.
    String[] tokens = expr.split("\\s+");
    boolean lastWasDigit = false; // Added to track consecutive numbers

    for (String token : tokens) {
      char c = token.charAt(0);

      if (Character.isDigit(c)) {
        // new statement that handle the expression in reverse polish.
        if (lastWasDigit) {
          throw new InvalidExpression("Invalid Expression");
        }
        output.append(token).append(' ');
        lastWasDigit = true;
      } else {
        lastWasDigit = false;
        if (c == '(') {
          stack.push(c);
        } else if (c == ')') {
          while (!stack.isEmpty() && stack.peek() != '(') {
            output.append(stack.pop()).append(' ');
          }
          if (!stack.isEmpty() && stack.peek() == '(') {
            stack.pop();
          } else {
            throw new InvalidExpression("Invalid Expression");
          }
        } else {
          
          //If the character is either lower precedence or the same of the top stack, it keeps add to the string
          //the character popped by stack and added with space.
          while (!stack.isEmpty()
              && precedence.getOrDefault(stack.peek(), -1) >= precedence.getOrDefault(c, -1)) {
            output.append(stack.pop()).append(' ');
          }
          stack.push(c);
        }
      }
    }

    while (!stack.isEmpty()) {
      if (stack.peek() == '(') {
        throw new InvalidExpression("Invalid Expression");
      }
      output.append(stack.pop()).append(' ');
    }

    return rpCalc.evaluate(output.toString().trim());
  }
}


