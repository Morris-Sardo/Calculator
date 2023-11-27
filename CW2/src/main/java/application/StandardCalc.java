package application;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * This class implement the calculation in form by using Stadard from.
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
   * @param expr is equasion to evaluate.
   * @return the valuer of espression after evaluated.
   * @throws EmptyStack exception is threw if try evaluate an expression with empty stack.
   * @throws BadType exception is threw is type is not right.
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


    // loop use to convert the espression form normal to reverse one.
    // the conversion is been handle by hashmaps that in base of the prioriy assigned to the
    // operators it decide in collaboration with queue when adding into StringBuilder.
    // The paranthesis won't be added in thr BuilderString.
    // Is been throw excetpion if the the parentesis are not matched.
    String[] tokens = expr.split("\\s+");
    boolean lastWasDigit = false; // Added to track consecutive numbers

    for (String token : tokens) {
      char c = token.charAt(0);

      if (Character.isDigit(c)) {
        // new statement that handle the expression in revece polish.
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


