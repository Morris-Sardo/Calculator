package application;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class ...
 * 
 * @author papap
 *
 */
class RevPolCalcTest {
  
  Random number = new Random();
  private RevPolCalc polCal;
  private String firstOp;
  private String secondOp;
  private int index;
  private int index2;
  
  @BeforeEach
  void setup() {
    polCal = new RevPolCalc();
    String[] arr = {"0","1","2","3","40","33","345","22","-1","-2","-3","2"};
    index = number.nextInt(arr.length);
    index2 = number.nextInt(arr.length);
    firstOp = arr[index];
    secondOp = arr[index2];
    
    
  }

  // test 1 if class exist.
  //change test such that the object does not get any argument
  @Test
  void RevPolClacClasstest() {
    
    polCal = new RevPolCalc();

  }

  // test 2 if constructor evaluate espression and store result.
  // Create constructor and getResult() method.
  // Modified test 1( added agrguement).
  // test 3 add return different value.
  // added throw exception in test 1.
  
  //Update method. deleted the parameter into the obj and deleted the getResult() method.
  //this update i the methods are free from BadType and EmptyStack exception.
  //this motdification has been done at all test.

  @Test
  void EvalutateExpressionAdditiontest() throws InvalidExpression {

    assertEquals(7.0, polCal.evaluate("3 4 +"));
    assertNotEquals(7.2, polCal.evaluate("3 4 +"));

   
    assertEquals(15.0, polCal.evaluate("5 1 2 + 4 + + 3 + "));

  }

  // test 4 test subtraction operation.
  // Added case "-" is switch statement.
  // test 5 create random entries. Generalize the the method. 
  
  //
  @Test
  void EvalutateExpressionSubtractiontest() throws InvalidExpression  {
   
    assertEquals(1.0, polCal.evaluate("4 3 -"));
    assertNotEquals(7.2, polCal.evaluate("4 3 -"));

    assertEquals(6.0, polCal.evaluate("5 1 2 - - "));

  }

  // test 6 test motiplication operation.
  // test added case"*" in switch statement.
  
  @Test
  void EvalutateExpressionMotilplicatiThrowsExceptiontest() throws InvalidExpression {
      
    float result = Float.parseFloat(firstOp) * Float.parseFloat(secondOp); 
      assertEquals(result, polCal.evaluate(firstOp+" "+secondOp+" "+"*"));
 

  }
  
  //test 7 test division.
  //added case"/" in switch state.
  // 
  @Test
  void EvalutateExpressionDivisiontest() throws InvalidExpression {

    float result = Float.parseFloat(firstOp) / Float.parseFloat(secondOp); 
      assertEquals(result, polCal.evaluate(firstOp+" "+secondOp+" "+"/"));
 

  }
  
  //test 8 test throw exception if division by 0 number. 
  @Test
  void throwInvalidExpressiontst () throws InvalidExpression  {

   assertThrows(InvalidExpression.class, () -> polCal.evaluate("4 0 /")); 

  }

  
  
}

