package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

/**
 * This class test all enum keys, attributes and methods.
 * @author papap
 *
 */
class SymbolTest {

  @Test
  // test 1 create class enum with
  // faking test key right instead left.
  // add toString in Enum class.
  void leftBrackettest() {

    Symbol symbol1 = Symbol.LEFT_BRACKET;

    assertEquals("(", symbol1.toString());


  }

  @Test
  // test 2 is base case is not left brakcet.
  void notLeftBrackettest() {

    Symbol symbol1 = Symbol.LEFT_BRACKET;

    assertNotEquals(")", symbol1.toString());


  }

  @Test
  // test 3 is base case is not left brakcet.
  void nightBrackettest() {

    Symbol symbol2 = Symbol.RIGHT_BRACKET;

    assertEquals(")", symbol2.toString());


  }

  @Test
  // test 4 is base case is not left brakcet.
  void notRighttBrackettest() {

    Symbol symbol2 = Symbol.LEFT_BRACKET;

    assertNotEquals(")", symbol2.toString());


  }

  @Test
  // test 5 create TIME enum..
  void timetest() {

    Symbol symbol3 = Symbol.TIME;

    assertEquals("*", symbol3.toString());


  }


  @Test
  // test 6 not not time operator.
  void notTimetest() {

    Symbol symbol2 = Symbol.TIME;

    assertNotEquals(")", symbol2.toString());


  }

  @Test
  // test 7 is base case division opator.
  // I hava add DIVIDE enum.
  void divisiontest() {

    Symbol symbol2 = Symbol.DIVISION;

    assertEquals("/", symbol2.toString());


  }

  @Test
  // test 8 is base case division opator.
  // I hava add DIVIDE enum.
  void notDivisiontest() {

    Symbol symbol2 = Symbol.DIVISION;

    assertNotEquals("*", symbol2.toString());


  }

  @Test
  // test 9 is base case division opator.
  // I hava add PLUS enum.
  void plustest() {

    Symbol symbol2 = Symbol.PLUS;

    assertEquals("+", symbol2.toString());


  }


  @Test
  // test 10 is base case division opator.
  // add DIVIDE enum.
  void notPlustest() {

    Symbol symbol2 = Symbol.PLUS;

    assertNotEquals(")", symbol2.toString());


  }

  @Test
  // test 11 is base case division opator.
  // I hava add MINUS enum.
  void minustest() {

    Symbol symbol2 = Symbol.MINUS;

    assertEquals("-", symbol2.toString());


  }


  @Test
  // test 12 is base case minus opator.
  // .
  void notMinusstest() {

    // Symbol symbol2 = Symbol.MINUS;

    assertNotEquals(")", Symbol.MINUS);


  }



  @Test
  // test 13 is base case division opator.
  // I hava add INVALID enum.
  void invalidstest() {

    Symbol symbol2 = Symbol.INVALID;

    assertEquals("invalid", symbol2.toString());


  }

}


