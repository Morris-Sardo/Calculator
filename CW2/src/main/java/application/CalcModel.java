package application;

/**
 * Evaluates an expression - the evaluation can be Standard or reverse polish.
 * 
 * @author papap
 *
 */
public class CalcModel {

  private Calculator revPol; // use to implement reversePol
  private Calculator standCalc; // use to implement Standard calculation.

  /**
   * Constructor initialise Reverse polish and standard one.
   */
  public CalcModel() {
    this.revPol = new RevPolCalc();
    this.standCalc = new StandardCalc();

  }

  /**
   * This method evaluate a Standard form or Reverse Polish form.
   * 
   * @param expression use as user input.
   * @param infix used to decide which kind expression evaluate.
   * @return result of calculation.
   * @throws InvalidExpression if the expression is not right format.
   */
  public float evaluate(String expression, Boolean infix) throws InvalidExpression {

    if (infix) {
      return standCalc.evaluate(expression);
    } else {
      return revPol.evaluate(expression);
    }
  }
}
