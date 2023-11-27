package application;

/**
 * Evaluates an expression - the evaluation can be Standard (infix) or reverse polish.
 */
public class CalcModel {
  
  //private Calculator revPol; //use to implement reversePol
  private Calculator standard; // use to implemtent Standard calculation.
  
  
 /**
  * Constructor..
  */
  public CalcModel() {
    //this.revPol = new RevPolCalc();
    this.standard = new StandardCalc();
    
  }
  /**
   * 
   * @param expression
   * @param infix
   * @return 
   * @throws InvalidExpression
   */
  public float evaluate(String expression, Boolean infix) throws InvalidExpression {
    
    return standard.evaluate(expression);
  }
}
