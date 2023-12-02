package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * The meaning of this class is test MockView class.
 * @author papap
 *
 */
class MockViewTest {
  private MockView mockView;
  
//  @BeforeEach
//  void setUp() {
//    mockView = new MockView();
//  }
  
  //test 1 create MockView class.
  //test 2 create field expression to test.
  @Test
  void test() {
    mockView = new MockView();
    String testExpression = "8 * 5";
    mockView.expression = testExpression; 
    assertEquals(testExpression, mockView.getExpression());
  }

}
