package application;

/**
 * This class implement the calculation in form by using Stadard from.
 * 
 * @author papap
 *
 */
public class StandardCalc {

  RevPolCalc rpCalc;

  public StandardCalc() {

    this.rpCalc = new RevPolCalc();
  }

  /**
   * 
   * @param expression
   * @return
   * @throws InvalidExpression
   */
  public float evaluate(String expression) throws InvalidExpression {

    String[] token = expression.split(" ");


    return rpCalc.evaluate(token[0] + " " + token[2] + " " + token[1]);
  }



}


