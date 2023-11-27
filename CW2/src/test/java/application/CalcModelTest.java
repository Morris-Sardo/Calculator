package application;

import static org.junit.jupiter.api.Assertions.*;
//import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CalcModelTest {
  
  
 private CalcModel calcMod;
 //private Random random;
 
   
 @BeforeEach
   void seUp() {
   calcMod = new CalcModel();
 }
  //test 1. This test implement standards calculation.
 //create field in Calculator, create Constructor and fixed return value to 5.
  @Test
  void evaluateRevPolitest() throws InvalidExpression {
   
    String expression = "3 + 2"; 
    assertEquals(5f,calcMod.evaluate(expression,true));
    
 
  }
  
  //test 2. This test implement Rev polish calculation. 
  //
  @Test 
  void evaluateStandardCalctest() throws InvalidExpression {
    
    String expression = "6 2 -";
    assertEquals(4f,calcMod.evaluate(expression, false));
    
  }
}
