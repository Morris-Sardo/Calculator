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
  @Test
  void AdditionTest() throws InvalidExpression {
    
    
    assertEquals(5, calc.evaluate("2 + 3"));
  }
  
  //test 2
  //evalute long enxpression.
  @Test
  void LongAdditionTest() throws InvalidExpression {
    
    assertEquals(20,calc.evaluate("2 + 3 + 4 + 5 + 6"));
  }
  
  


}
