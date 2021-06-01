package com.owoez;

import java.util.*;

public class SmallestPositiveInteger {
  public static void main(String[] args) {
    //Define and populate arrays to test the function;
    Integer[] testArrayOne = {1, 2, 4, 6, 6, 10, 3, 1, 6};
    Integer[] testArrayTwo = {-2, -3, -4, -5, -10, 0, 2, 4};
    Integer[] testArrayThree = {-2, -3, -4, -5, -10, 1, 2, 4};
    Integer[] testArrayFour = {-2, -3, -4, -5, -10, 2, 4};

    // Call method on arrays declared above
    System.out.println(getMissingSmallestPositiveInteger(testArrayOne));
    System.out.println(getMissingSmallestPositiveInteger(testArrayTwo));
    System.out.println(getMissingSmallestPositiveInteger(testArrayThree));
    System.out.println(getMissingSmallestPositiveInteger(testArrayFour));
  }

  public static int getMissingSmallestPositiveInteger(Integer[] numbersArray) {
    /**
     *Check for all constraints and return appropriate values
     *First check the length of the array. Must be greater than zero and less than 100,001
     *Return Zero if condition is false */
    int arrayLength = numbersArray.length;
    if (arrayLength < 0 || arrayLength > 100000) {
      return 0;
    }

    /** *Convert array to set to remove duplicates
     * We use SortedSet to make sure values are sorted and TreeSort to be able to get the last element */
    SortedSet<Integer> numbersSet = new TreeSet<>(Arrays.asList(numbersArray));

    /**
     * Check if the last number in the set is negative and
     * If it is, it means all numbers are negative so return 1 */
    if (numbersSet.last() < 0) return 1;

    /**
     * Iterate through the set to check for missing value.
     * if no missing value is found, return the last element in set incremented by 1 */
    int currentValueInSet = 0;
    int nextValueInSet = 0;
    Iterator value = numbersSet.iterator();
    currentValueInSet = (Integer) value.next();
    nextValueInSet = (Integer) value.next();
    while (value.hasNext()) {
      /**
       * Return 0 if any value is grater than 1,000,000 or less than -1,000,000
       * Return 1 if current value is negative and next value is positive */
      if (currentValueInSet > 1000000 || currentValueInSet < -1000000) return 0;
      if (currentValueInSet <= 0 && nextValueInSet > 1) return 1;

      if (currentValueInSet + 1 < nextValueInSet && currentValueInSet > 0) {
        break;
      } else {
        currentValueInSet = nextValueInSet;
        nextValueInSet = value.hasNext() ? (Integer) value.next() : nextValueInSet;
      }
    }

    //Return the currentValueInSet variable incremented by 1
    return currentValueInSet + 1;
  }
}
