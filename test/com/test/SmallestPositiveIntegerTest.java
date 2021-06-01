package com.test;

import com.owoez.*;
import jdk.jfr.Description;
import junit.framework.TestCase;
import org.junit.Test;

public class SmallestPositiveIntegerTest extends TestCase {
  Integer[] testArrayOne = {1, 2, 4, 6, 6, 10, 3, 1, 6};
  Integer[] testArrayTwo = {-2, -3, -4, -5, -10, 0, 2, 4};
  Integer[] testArrayThree = {-2, -3, -4, -5, -10, 1, 2, 4};
  Integer[] testArrayFour = {-2, -3, -4, -5, -10, 2, 4};

  @Test()
  @Description("Tests for correct responses")
  public void testGetMissingSmallestPositiveInteger() {
    assertEquals(5,SmallestPositiveInteger.getMissingSmallestPositiveInteger(testArrayOne));
    assertEquals(1,SmallestPositiveInteger.getMissingSmallestPositiveInteger(testArrayTwo));
    assertEquals(3,SmallestPositiveInteger.getMissingSmallestPositiveInteger(testArrayThree));
    assertEquals(1,SmallestPositiveInteger.getMissingSmallestPositiveInteger(testArrayFour));
  }
}