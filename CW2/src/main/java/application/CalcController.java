package application;


/**
 * This class is observer between the GUI interface and the model.
 * 
 * @author papap
 *
 */
public class CalcController {

  private CalcModel myModel; // use to set expression and decide and how calculating it.
  private ViewInterface myView; // GUI interface.
  private OpType type; // enum use to decide if calculate it in Standard or reverse.

  /**
   * This method get the expression and set the answer.
   * 
   */
  public void handleCalculation() {
    boolean t;
    if (type == OpType.STANDARD) {
      t = true;
    } else {
      t = false;
    }
    try {
      myView.setAnswer("" + myModel.evaluate(myView.getExpression(), t));

    } catch (InvalidExpression e) { // print text GUI calculator.
      myView.setAnswer(e.getMessage());
    }
  }

  /**
   * The method set the type of calculation.
   * 
   * @param type is been use to decide if a standard of reverse one.
   */
  public void handleTypeChange(OpType type) {
    this.type = type;
  }

  /**
   * Constructor registers handleCalculation and handleTypeChange to observers in my view.
   * 
   * @param myModel is calculate from calculate model.
   * @param myView is the GUI interface.
   */
  public CalcController(CalcModel myModel, ViewInterface myView) {
    this.myModel = myModel;
    this.myView = myView;
    // use from observe one to link an expression form interface and model one.
    myView.addCalculateObserver(this::handleCalculation);
    // use from observe one to link which kind of calculation you want to use from interface and
    // model one.
    myView.addTypeObserver(this::handleTypeChange);
  }



}
