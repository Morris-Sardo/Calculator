package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;


// import static org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

/**
 * This class will implement standard calculation
 * 
 * @author papap
 *
 */
class StandardCalcTest {
  
  // test 1 fake test.
  // I made up that evluate method retrun a string expression.  
  @Test
  void EvaluateMethodString() {
   
    String expression = "1234";
    StandardCalc calculation = new StandardCalc();
    assertEquals(Float.parseFloat(expression),calculation.evaluate(expression));
  }
 
  //test 2 return convert the expression in intger.
  //change the return itype in float one.
  //test 1 Update Casted espression to be float number.
  @Test
  void EvaluateMethodsConvertiToFloat() {
    
    String expression = "1234";
    
    StandardCalc calculation = new StandardCalc();
    
    assertEquals(1234f,calculation.evaluate(expression));
  }
  
  //Fix tihs stest. and think how to fix entry problem.
//  @Test
//  void EvaluateMethodAddexpressionIntoStacktest(){
//    
//    StrStack expression = new StrStack();
//    String input = "1+2";
//    
//    expression.push(input);    
//    StandardCalc calculation = new StandardCalc();
//    
//    assertEquals(1234f,calculation.evaluate(input));
//  }



}
