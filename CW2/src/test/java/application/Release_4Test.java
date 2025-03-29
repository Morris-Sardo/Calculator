package application;


import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class test system test for all system in View and Model development.
 * 
 * @author papap
 *
 */
class Release_4Test {

  private Random testValue = new Random();
  private StrStack strStack;
  private RevPolCalc polCalc;
  private CalcController calcCont;
  private MockView view;
  private CalcModel model;


  @BeforeEach
  void steUp() {

    strStack = new StrStack();
    polCalc = new RevPolCalc();
    view = new MockView();
    model = new CalcModel();
    calcCont = new CalcController(model, view);
  }


  @Test
  // test 1 test general expression.
  void TestCalcContRevercePolish() {
    view.setExpression("22 * 3 / 2");
    calcCont.handleTypeChange(OpType.STANDARD);
    calcCont.handleCalculation();
    assertEquals(Float.parseFloat(view.answer), 33f);

    view.setExpression("11 3 55 / +");
    calcCont.handleTypeChange(OpType.REV_POLISH);
    calcCont.handleCalculation();
    assertEquals(Float.parseFloat(view.answer), 11.05f);


  }

  @Test
  // test 2 test division.
  void TestCalcContStandard() {
    view.setExpression("22 2 /");
    calcCont.handleTypeChange(OpType.REV_POLISH);
    calcCont.handleCalculation();
    assertEquals(Float.parseFloat(view.answer), 11f);

    view.setExpression("");

  }

  @Test
  // test 3 test the invalid expression is cached.
  void TestCalcContDivideByZero() {
    view.setExpression("22 0 /");
    calcCont.handleTypeChange(OpType.REV_POLISH);
    calcCont.handleCalculation();
    assertEquals(view.answer, "Invalid expression");

    view.setExpression("8.2 / 0");
    calcCont.handleTypeChange(OpType.STANDARD);
    calcCont.handleCalculation();
    assertEquals(view.answer, "Invalid expression");

  }

  @Test
  // test 4 test addition operation in reverse polish class.
  void EvalutateExpressionAdditiontest() throws InvalidExpression {


    assertEquals(14f, polCalc.evaluate("5 2 4 3 + + + "));

  }

  @Test
  // test 5. test push method in StrStack class.
  void PuhStringtest() throws BadType, EmptyStack {

    testValue = new Random();
    String arr[] = {"+", "?", "/", "*", "?", "bye", ""};
    int index = testValue.nextInt(arr.length - 1);
    strStack.push(arr[index]);

    String retriveString = strStack.top().toString();

    assertEquals(arr[index].toString(), retriveString);

    assertEquals(1, strStack.size());

  }



}
