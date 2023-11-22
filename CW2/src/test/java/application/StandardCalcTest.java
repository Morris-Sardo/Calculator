package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class StandardCalcTest {
  
  private StandardCalc calc;
  
  
  @BeforeEach
  void setUp() {
    
    calc = new StandardCalc();
    
    
  }
  
  //test 1
  //Test addiction.
  //create evaluate Method thre return 5.0.
  //test 2 I am goint to improve evaluat method such the
  //it will return the value pop from NumStak.
  @Test
  void AdditionTest() {
    
    
    assertEquals(5, calc.evaluate("2 + 3"));
  }
  
  


}
