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
public class StandardCalc{
  
  private RevPolCalc rpCalc; //used to calculater expression
  
  public StandardCalc() {
    
    this.rpCalc = new RevPolCalc();
  }
  
  
  //THIS IS NOT THE FINAL VERSION OF THE CLASS.
  //@Override
  public float evaluate(String expr) throws InvalidExpression {
    
      //keep track od priority between all operator.
      Map<Character, Integer> precedence = new HashMap<>();
      precedence.put('+', 1);
      precedence.put('-', 1);
      precedence.put('*', 2);
      precedence.put('/', 2);
      precedence.put('(', -1); 
      precedence.put(')', -1);

      StringBuilder output = new StringBuilder(); //it used the final Reverved expression.
      Deque<Character> stack = new LinkedList<>(); //it use to to handle the operator.

      String[] tokens = expr.split("\\s+");
      
      //loop use to convert the espression form normal to reverse one.
      //the conversion is been handle by hashmaps that in base of the prioriy assigned to the 
      //operators it decide in collaboration with queue when adding into StringBuilder.
      //The paranthesis won't be added in thr BuilderString.
      //Is been throw excetpion if the the parentesis are not matched. 
      //THIS 
      for (String token : tokens) {
          char c = token.charAt(0);

          if (Character.isDigit(c)) {
              output.append(token).append(' ');
          } else if (c == '(') {
              stack.push(c);
          } else if (c == ')') {
              while (!stack.isEmpty() && stack.peek() != '(') {
                  output.append(stack.pop()).append(' ');
              }
              if (!stack.isEmpty() && stack.peek() == '(') {
                  stack.pop();
              } else {
                  throw new InvalidExpression("Mismatched parentheses");
              }
          } else {
              while (!stack.isEmpty() && precedence.getOrDefault(stack.peek(), -1) >= precedence.getOrDefault(c, -1)) {
                  output.append(stack.pop()).append(' ');
              }
              stack.push(c);
          }
      }

      while (!stack.isEmpty()) {
          if (stack.peek() == '(') {
              throw new InvalidExpression("Mismatched parentheses");
          }
          output.append(stack.pop()).append(' ');
      }

      return rpCalc.evaluate(output.toString().trim());
  }
}



