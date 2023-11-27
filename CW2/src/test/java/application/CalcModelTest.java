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
 //Improving test randoming the numbers.
  @Test
  void evaluateStandCaldtest() throws InvalidExpression {
    
    String addExpre = "3 + 2"; 
    assertEquals(5f,calcMod.evaluate(addExpre,true));
    
    String subExpre = "6.3 - 2";
    assertEquals(4.3f,calcMod.evaluate(subExpre, true));
    
    String timeExpre = "6.3 * 2";
    assertEquals(12.6f,calcMod.evaluate(timeExpre, true));
    
    String divExpre = "6 / 2.8";
    assertEquals(2.142857f,calcMod.evaluate(divExpre, true));
      
 
  }
  
  //test 2. This test implement Rev polish calculation. 
  //
  //
  @Test 
  void evaluateRevPolCalctest() throws InvalidExpression {
    
    String subExpre = "6 2 -";
    assertEquals(4f,calcMod.evaluate(subExpre, false));
    
    String divExpre = "6.3 2 +";
    assertEquals(8.3f,calcMod.evaluate(divExpre, false));
    
    String devExpre = "6 2.8 /";
    assertEquals(2.142857f,calcMod.evaluate(devExpre, false));
    
    String timeExpre = "2 11 *";
    assertEquals(22f,calcMod.evaluate(timeExpre, false));
    
    
        
  }
   
  
  
}
