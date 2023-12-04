package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;


class CalcControllerTest {

  CalcController calcContr;
  MockView view = new MockView();
  CalcModel model = new CalcModel();


  @Test
  // create MOCkView class and imported all method of ViewINteface class.
  // add set Expression in MockView.
  // Implemented handleCalculation and handleTypeChange such that the Interface can communicate with
  // the model.

  void test() {
    calcContr = new CalcController(model, view);
    view.setExpression("2 5 +");
    calcContr.handleTypeChange(OpType.REV_POLISH);
    calcContr.handleCalculation();
    assertEquals(Float.parseFloat(view.answer), 7f);



  }

}


