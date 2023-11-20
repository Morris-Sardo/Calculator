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
  void RevPolClacClasstest() throws EmptyStack, BadType {
    
    polCal = new RevPolCalc("1 2 +");
    
  }
  
  //test 2 if constructor evaluate espression and store result.
  //Create constructor and getResult() method.
  //Modified test 1( added agrguement).
  //test 3 add return different value.
  //added throw exception in test 1.
  
  //
  @Test
  void EvalutateExpressionAdditiontest() throws EmptyStack, BadType {
    
    polCal = new RevPolCalc("3 4 +");
    assertEquals(7.0,polCal.getResult());
    assertNotEquals(7.2, polCal.getResult());
    
    polCal = new RevPolCalc("5 1 2 + 4 + + 3 + ");
    assertEquals(15.0,polCal.getResult());
    
  }
  
  //test 4 test subtraction operation.
  //test 5 added complex calculation.
  //Added case minuns is switch statement.
  @Test
  void EvalutateExpressionSubtractiontest() throws EmptyStack, BadType {
    
    polCal = new RevPolCalc("4 3 -");
    assertEquals(1.0,polCal.getResult());
    assertNotEquals(7.2, polCal.getResult());
    
    polCal = new RevPolCalc("5 1 2 - - ");
    assertEquals(6.0,polCal.getResult());
    
  }  
  
  //test 6 test motiplication operation.
  @Test
  void EvalutateExpressionMotilplicationtest() throws EmptyStack, BadType {
    
    polCal = new RevPolCalc("4 3 *");
    assertEquals(12.0,polCal.getResult());
    
    
 
  
  }
}

