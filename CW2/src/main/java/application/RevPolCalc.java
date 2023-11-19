package application;

/**
 * This class ..
 * 
 * @author papap
 *
 */
public class RevPolCalc {
  
  private float result;
  
  public RevPolCalc(String expression) {
    this.result = evaluate(expression);
    
  }
  
  private float evaluate(String expression) {
    
    return 7.0f;
  }

  public float getResult() {
    return result;
  }

}
