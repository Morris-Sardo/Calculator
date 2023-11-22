package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * This class will implement standard calculation
 * 
 * @author papap
 *
 */
class StandardCalcTest {
  
  private StandardCalc calc;
  
  
  @BeforeEach
  void setUp() {
    
    calc = new StandardCalc();
    
    
  }
  
  //test 1
  //Test addiction.
  
  @Test
  void AdditionTest() {
    asserEquals(5, calc.evaluate("2 + 4"));
  }
 


}
