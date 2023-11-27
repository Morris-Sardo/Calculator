package application;

/**
 * Evaluates an expression - the evaluation can be Standard (infix) or reverse polish.
 */
public class CalcModel {

  private Calculator revPol; // use to implement reversePol
  private Calculator standCalc; // use to implemtent Standard calculation.


  /**
   * Constructor..
   */
  public CalcModel() {
    this.revPol = new RevPolCalc();
    this.standCalc = new StandardCalc();

  }

  /**
   * This method evaluate a Standard form or Reverse Polish form.
   * 
   * @param expression use as user input.
   * @param infix used to decise whitch kind espreassion evaluate.
   * @return reult of calcualtion.
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
