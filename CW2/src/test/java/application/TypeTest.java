package application;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

/**
 * This class test all keys' enum , keys' atrribute and meothos one.
 * 
 * @author papap
 *
 */
class TypeTest {

  @Test
  // test 1 create Type class enum.
  // Added toString method.
  void typeFloatEqualtest() {

    Type type = Type.FLOAT;
    assertEquals("It is float number", type.toString());

  }

  @Test
  // teast 2 feking test for description.
  void typeNotFloatltest() {

    Type type = Type.FLOAT;
    assertNotEquals("Is iInteger", type.toString());

  }

  @Test
  // test 3 create Type class enum.
  // Added.
  void typeStringEqualtest() {

    Type type = Type.STRING;
    assertEquals("It is a Strings", type.toString());

  }


  @Test
  // teast 4 feking test for description.
  void typeStringNotEqualtest() {

    Type type = Type.STRING;
    assertNotEquals("??", type.toString());

  }


  @Test
  // test 5 create SYMBOL enum.
  // Added.
  void typeSymboltest() {

    Type type = Type.SYMBOL;
    assertEquals("It is mathematical operator", type.toString());

  }

  @Test
  // test 6 ceating tet to see the argument is con be another one.
  void typeNotSymboltest() {

    Type type = Type.SYMBOL;
    assertNotEquals("It is an integer", type.toString());

  }

  @Test
  // test 7 create INVALID enum.
  void typeiNVALIDtest() {

    Type type = Type.INVALID;
    assertEquals("It is invalid input", type.toString());

  }



}
