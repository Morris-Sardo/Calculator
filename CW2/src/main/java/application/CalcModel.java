package application;

/**
 * Evaluates an expression - the evaluation can be Standard (infix) or reverse polish.
 */
public class CalcModel {
  
  private Calculator revPol; //use to implement reversePol
  private Calculator standard; // use to implemtent Standard calculation.
  
  
  
  public CalcModel() {
    //this.revPol = new RevPolCalc();
    this.standard = new StandardCalc();
    
  }
  
  public float evaluate(String expression, Boolean infix) throws InvalidExpression {
    
    return 0.0f;
  }
}
