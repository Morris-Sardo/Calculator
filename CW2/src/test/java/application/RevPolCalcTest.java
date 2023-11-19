package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 * This class ...
 * @author papap
 *
 */
class RevPolCalcTest {

  
  //test 1 if class exist.
  @Test
  void RevPolClacClasstest() {
    
    RevPolCalc polCal = new RevPolCalc();
    
  }
  
  //test 2 if constructor evaluate espression and store result.s
  @Test
  void constructorEvaluateExpressiontest() {
    
    RevPolCalc polCal = new RevPolCalc("34+");
    assertEquals(7.0,polCal.getResult());
    
  }

}
