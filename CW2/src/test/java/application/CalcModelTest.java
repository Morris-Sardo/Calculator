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
  //test 1. this test implement standards calculation.
  //the test will test also the exception.
  @Test
  void evaluateRevPolitest() throws InvalidExpression {
   
    String expression = "3 + 2"; 
    assertEquals(5f,calcMod.evaluate(expression,true));
    
    

    
    
    
  }

}
