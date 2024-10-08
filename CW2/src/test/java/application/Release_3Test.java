package application;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * This class test the system implemented in Model development.
 * 
 * @author papap
 *
 */
class Release_3Test {

  private Entry string;
  private Stack stack = new Stack();
  private NumStack numStack = new NumStack();
  private Random testValue = new Random();
  private OpStack opStack = new OpStack();
  private StrStack strStack = new StrStack();
  private RevPolCalc polCalc = new RevPolCalc();
  private StandardCalc standCalc = new StandardCalc();
  private CalcModel calcMod = new CalcModel();

  @Test
  // test 1. Test entry class.
  void Entrytest() throws BadType {
    Random rand = new Random();
    String[] arrString = {"a", "bra", "ciao", "CAMILLO"};
    int randLength = rand.nextInt(4);
    string = new Entry(arrString[randLength]);
    assertEquals(string.getString(), arrString[randLength]);

  }

  @Test
  // test 2 test Entry exception.
  void getStringThrowsBafTypeEsceptiontest() {
    Entry entry = new Entry(1.5f);
    BadType e = assertThrows(BadType.class, () -> entry.getString());
    assertEquals("It is not a string", e.getMessage());
  }

  @Test
  // test 3. test increase size in stack class.
  void encreaseSizetest() throws BadType {

    Entry entry = new Entry("ciao");
    stack.push(entry);
    assertEquals(stack.size(), 1);
  }

  @Test
  // test 4. test size method on the stack class.
  void Sizetest() throws BadType, EmptyStack {

    int i = 0;
    do {
      Random rand = new Random();
      String[] arrString = {"a", "bracket", "ciao", "CAMILLO"};
      int randLength = rand.nextInt(4);
      Entry string = new Entry(arrString[randLength]);
      stack.push(string);


      i++;
    } while (i < 10);
    assertEquals(stack.size(), 10);

    i = 0;
    do {
      Random rand = new Random();
      String[] arrString = {"a", "bracket", "ciao", "CAMILLO"};
      int randLength = rand.nextInt(4);
      Entry string = new Entry(arrString[randLength]);
      stack.push(string);


      i++;
    } while (i < 10);
    assertNotEquals(stack.size(), i);

  }

  @Test
  // test 5. test pop and push method
  void popAndPushMethodtest() throws BadType, EmptyStack {
    Entry entry = new Entry("hi");
    Entry entry1 = new Entry("bye");
    stack.push(entry);
    stack.push(entry1);
    Entry pop = stack.pop();
    assertEquals(entry1, pop);

  }

  @Test
  // test 6.test push method in numStack class.
  void Pushtest() throws EmptyStack, BadType {

    float randFloat = testValue.nextFloat() * (float) 100.0;
    numStack.push(randFloat);
    assertEquals(randFloat, numStack.top());

  }

  @Test
  // test 7. test throw exception when numbStack is empty.
  void topThrowsEmptyExceptionWhenEmpty() throws EmptyStack, BadType {

    float randFloat = testValue.nextFloat() * (float) 100.0;
    numStack.push(randFloat);
    assertDoesNotThrow(() -> numStack.top());
    numStack.pop();
    EmptyStack e = assertThrows(EmptyStack.class, () -> numStack.top());
    assertEquals("Stack is Empty", e.getMessage());

  }

  @Test
  // test 8. test size and pop of OpStack class.
  void OpStackClassSizeTest() throws EmptyStack, BadType {

    Symbol symbol = Symbol.DIVISION;
    opStack.push(symbol);
    assertEquals(1, opStack.size()); // confirm the the element has been add into the stack.
    opStack.pop();
    assertEquals(0, opStack.size()); // confirm the pop stack work proerly.

  }

  @Test
  // test 9. test push method in StrStack class.
  void PuhStringtest() throws BadType, EmptyStack {

    testValue = new Random();
    String arr[] = {"+", "?", "/", "*", "?", "bye", ""};
    int index = testValue.nextInt(arr.length - 1);
    strStack.push(arr[index]);

    String retriveString = strStack.top().toString();

    assertEquals(arr[index].toString(), retriveString);

    assertEquals(1, strStack.size());

  }

  @Test
  // test 10. test the exception in StrStack class.
  void StrStackThrowExceptionWhenStackIsEmptytest() throws EmptyStack {


    EmptyStack e = assertThrows(EmptyStack.class, () -> numStack.top());
    assertEquals("Stack is Empty", e.getMessage());



  }


  @Test
  // test 11 test addition operation in reverse polish class.
  void EvalutateExpressionAdditiontest() throws InvalidExpression {


    assertEquals(15f, polCalc.evaluate("5 1 2 4 3 + + + + "));

  }

  @Test
  // test 12 test subtraction operation in reverse polish class.
  void EvalutateExpressionSubtractiontest() throws InvalidExpression {

    assertEquals(1f, polCalc.evaluate("4 3 -"));



  }

  @Test
  // test 14 test division operation in reverse polish class.
  void EvalutateExpressionMotiplicationtest() throws InvalidExpression {

    assertEquals(12f, polCalc.evaluate("4 3 *"));



  }

  @Test
  // test 14 test division operation in reverse polish class.
  // modify test after added Math.round() in revPol class.
  void EvalutateExpressionDivisiontest() throws InvalidExpression {

    assertEquals(0.75f, polCalc.evaluate("3 4 /"));

  }

  @Test
  // test 15 test division by zero in reverse polish class.
  void EvalutateExpressionDivisionByZerotest() throws InvalidExpression {

    assertThrows(InvalidExpression.class, () -> polCalc.evaluate("4 0 /"));

  }

  @Test
  // test 16 test wrong formatting expression reverse polish class.
  void EvalutateExpressionWrongFormattingtest() throws InvalidExpression {

    assertThrows(InvalidExpression.class, () -> polCalc.evaluate("4  / 3"));
    assertThrows(InvalidExpression.class, () -> polCalc.evaluate("( 4  3 * )"));


  }

  @Test
  // test 17 test addition operation in StandardCalc class.
  void EvalutateStancdardCalcExpressionAdditiontest() throws InvalidExpression {


    assertEquals(15f, standCalc.evaluate("5 + 1 + 2 + 4 + 3 "));

  }


  @Test
  // test 18 test subtraction operation in StandardCalc class.
  void EvalutateStancdardCalcExpressionSubtractiontest() throws InvalidExpression {


    assertEquals(-1f, standCalc.evaluate("5 - 1 - 2 - 3 "));

  }

  @Test
  // test 19 test multiplication operation in StandardCalc class.
  void EvalutateStancdardCalcExpressionMultiplicationtest() throws InvalidExpression {


    assertEquals(15f, standCalc.evaluate("5 * 3"));

  }

  @Test
  // test 20 test division operation in StandardCalc class.
  // Update the RevPolClass such the it truncate number to 2 decimal point.
  void EvalutateStancdardCalcExpressionDivisiontest() throws InvalidExpression {

    assertEquals(1.33f, standCalc.evaluate("4 / 3"));

  }


  @Test
  // test 21 test division operation in StandardCalc class.
  void EvalutateStancdardCalcExpressionDivisionByZerotest() throws InvalidExpression {


    assertThrows(InvalidExpression.class, () -> standCalc.evaluate("6 / 0"));



  }

  @Test
  // test 22 test division operation in StandardCalc class.
  void EvalutateStancdardCalcExpressionWithWrongOperandOrOperetortest() throws InvalidExpression {


    assertThrows(InvalidExpression.class, () -> standCalc.evaluate("(6 / 2.3"));
    assertThrows(InvalidExpression.class, () -> standCalc.evaluate("(6 0 *"));
    assertThrows(InvalidExpression.class, () -> standCalc.evaluate("((6 / 7)"));
    assertThrows(InvalidExpression.class, () -> standCalc.evaluate("(6 / 0)))"));



  }

  @Test
  // test 23 test standard calculation in CalcModel class.
  void evaluateCalcModelClassStandCalctest() throws InvalidExpression {

    String addExpre = "3.33 + 2";
    assertEquals(5.33f, calcMod.evaluate(addExpre, true));

    String subExpre = "6.3 - 2";
    assertEquals(4.3f, calcMod.evaluate(subExpre, true));

    String timeExpre = "6.3 * 2 * 3";
    assertEquals(37.8f, calcMod.evaluate(timeExpre, true));

    String divExpre = "6 / 2.8";
    assertEquals(2.14f, calcMod.evaluate(divExpre, true));


  }



  @Test
  // test 24 test reverse polish calculation CalcModel class.
  void evaluateCalcModelClassRevPolCalctest() throws InvalidExpression {

    String subExpre = "6.33 2 3 - -";
    assertEquals(7.33f, calcMod.evaluate(subExpre, false));

    String divExpre = "6.3 2 +";
    assertEquals(8.3f, calcMod.evaluate(divExpre, false));

    String devExpre = "6 2.8 /";
    assertEquals(2.14f, calcMod.evaluate(devExpre, false));

    String timeExpre = "2.33 11 *";
    assertEquals(25.63f, calcMod.evaluate(timeExpre, false));



  }



  @Test
  // test 25 test Exception in standard form.
  void ExceptionCalcModelStandardFormtest() throws InvalidExpression {

    String lessOperator = "6 + 2 - 2.22 43"; // less operator.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(lessOperator, true));

    String NotOper = "3 4 6 6";// no operator.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(NotOper, true));

    String TooManyOper = "6.3 / / / / 2 + / *"; // many operators.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(TooManyOper, true));

    String Parenthesys1 = "((6 * 2.8) * 3"; // Mismatch parentheses.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(Parenthesys1, true));

    String Parenthesys2 = "((6 * )2.8)))) * 3"; // Mismatch parentheses.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(Parenthesys2, true));

    String devByZero = "6 / 0"; // by zero.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(devByZero, true));

    String RevForm = "6 0 /"; // RevForm.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(RevForm, true));



  }



  @Test
  // test 26 test Exception in reverse polish form.
  void ExceptionReversePolishFormtest() throws InvalidExpression {

    String lessOperator = "6 2 2.3 43 33 4 0.5 + /"; // less operator.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(lessOperator, false));

    String NotOper = "3.99 4"; // no operator.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(NotOper, false));

    String TooManyOper = "6.3 + 2 + / * / / *"; // many operators.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(TooManyOper, false));

    String Parenthesys = "((((((6 * 2.8) * 3"; // Parentheses no accepted.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(Parenthesys, false));

    String devByZero = "6 0 /"; // by zero.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(devByZero, false));

    String StandardForm = "6 0 /"; // StandardFrom.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(StandardForm, false));

  }



}
