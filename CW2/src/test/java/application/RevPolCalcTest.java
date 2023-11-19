package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
/**
 * This class ...
 * @author papap
 *
 */
class RevPolCalcTest {
  
  private RevPolCalc polCal; // ust to store the expression.

 
  //test 1 if class exist.
  @Test
  void RevPolClacClasstest() {
    
    polCal = new RevPolCalc("12+");
    
  }
  
  //test 2 if constructor evaluate espression and store result.
  //Create constructor and getResult() method.
  //Modified test 1( added agrguement).
  //Test 3 add retrun different value.
  @Test
  void constructorEvaluateExpressiontest() {
    
    polCal = new RevPolCalc("34+");
    assertEquals(7.0,polCal.getResult());
    assertNotEquals(7.2, polCal.getResult());
    
    polCal = new RevPolCalc("512+4*+3-");
    assertEquals(14.0,polCal.getResult());
    
  }

}
