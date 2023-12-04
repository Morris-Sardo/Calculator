package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;


class CalcControllerTest {

  CalcController calcContr;
  MockView view = new MockView();
  CalcModel model = new CalcModel();


  @Test
  // test 1 test that calcController an expression in RevPolish. 
  // create MoCkView class and imported all method of ViewINteface class.
  // add set Expression in MockView.
  // Implemented handleCalculation and handleTypeChange such that the Interface can communicate with
  // the model.

  void CalcControllerReversePolishtest() {
    calcContr = new CalcController(model, view);
    view.setExpression("2 5 +");
    calcContr.handleTypeChange(OpType.REV_POLISH);
    calcContr.handleCalculation();
    assertEquals(Float.parseFloat(view.answer), 7f);



  }
  
  @Test
  //test 2 test that calcController an expression in Standard.
  void CalcControllerInStandardtest() {
    calcContr = new CalcController(model, view);
    view.setExpression("2 * 5");
    calcContr.handleTypeChange(OpType.STANDARD);
    calcContr.handleCalculation();
    assertEquals(Float.parseFloat(view.answer), 10f);



  }
  
  
  @Test
  //test 3 test that calcController an expression in Standard.
  void CalcControllerInvalidExpressionest() {
    calcContr = new CalcController(model, view);
    view.setExpression("2 * 5");
    calcContr.handleTypeChange(OpType.STANDARD);
    calcContr.handleCalculation();
    assertNotEquals(view.answer, "Invalid Expression");
    view.setExpression("2 5");
    calcContr.handleTypeChange(OpType.STANDARD);
    calcContr.handleCalculation();
    assertEquals(view.answer, "Invalid Expression");
    



  }
  
  

}


