package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// import static org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

/**
 * This class will implement standard calculation
 * 
 * @author papap
 *
 */
class StandardCalcTest {
    
   //StandardCalc calculation = new StandardCalc();

  // test 1 fake test.
  // I made up that evluate method retrun a string expression.  
  @Test
  void StandardCalculatoreConstructtest() {
    
    String expression = "1+2-1=4";
    StandardCalc calculation = new StandardCalc();
    String testString = calculation.evaluate(expression);
    assertEquals(expression,testString.toString());
  }



}
