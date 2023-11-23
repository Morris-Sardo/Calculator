package application;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;


/**
 * The meaning of this class is testing all possible operations allowed by the calculator and to
 * test the various possible faults.
 * 
 * @author papap
 *
 */
class SandardCalcTest {
  
  
  StandardCalc calc = new StandardCalc();
  
  //test 1
  //I have create class StandardCalss class.
  //Create created hashmap such that it will keep track of priority of operator.
  //use a BuilderString to save the expression converted in Reverse polish on.
  //I used queue such that the operand i could push and pop of both side(this is good 
  //because if a operand was behind to another one it could puch it into from the another side of it).
  //Inside the loop variuos if and else statement with sopme of them with while loop. 
  //In addition the loop check if elelent is operando or operator. If it s a operator check in hashmap
  //which prioprit has(Higher number hegher priority) and add them in the back of number into BuildString.
  //If it s parantesis check grup all numbers and operator into it.
  //Is is been throw an exception if a parentesist is mismatched.
  @Test
  void AdditionTest() throws InvalidExpression{
    
    assertEquals(61f, calc.evaluate("2 * 32 + 3 - 6"));
  }
  
  //test 2
  //evaluate long esxpression with addition of parentheses. 
  
  @Test
  void LongAdditionTest() throws InvalidExpression{
    
    assertEquals( 10f, calc.evaluate("( 2 * 3 ) + 4"));
  }
  
  
  //test 3 
  //test if epression implemented by StandardCalc is compatible 
  //with RevPolCalss class.
  //Modified evaluate method form string to float.
  //create contrutor use to inizialise RevPolCalc's object.
  //Test 1 and test 2 now are failed as evaluate type is not String anymore.
  
  @Test
  void StandCalcCompatibleWithRevPolCalctest() throws InvalidExpression {
    
    assertEquals(5f,calc.evaluate("3 + 2"));
  }
  
  
  //test 4
  //mismatch operand.
  //this test testing it the oprand are less then suppose to many.
  @Test
  void MismatchOperandtest() {
    
    assertDoesNotThrow(() -> calc.evaluate("2 + 3"));
    assertThrows(InvalidExpression.class, () -> calc.evaluate("2 + + 3"));
    assertThrows(InvalidExpression.class, () -> calc.evaluate("2 * 3 4"));
    
    
  }
}

