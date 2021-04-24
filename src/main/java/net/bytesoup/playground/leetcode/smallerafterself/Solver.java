package net.bytesoup.playground.leetcode.smallerafterself;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solver {

  private static final int NOT_SET = -1;

  public static List<Integer> countSmaller(List<Integer> nums) {
    List<Integer> returnList = new ArrayList<>(Collections.nCopies(nums.size(), -1));
    for (int i = 0; i < nums.size(); ++i) {
      if (returnList.get(i) == NOT_SET) {
        returnList.set(i, countSmaller(i, nums, returnList));
      }
    }
    return returnList;
  }

  private static int countSmaller(int currentIdx, List<Integer> numsToCheck,
      List<Integer> resultList) {
    int currentValue = numsToCheck.get(currentIdx);
    int currentCount = 0;
    for (int i = (numsToCheck.size() - 1); i > currentIdx; --i) {
      if (resultList.get(i) > NOT_SET) {
        continue;
      }

      int currentValueInList = numsToCheck.get(i);
      if (currentValueInList < currentValue) {
        ++currentCount;
      } else if (currentValueInList == currentValue) {
        resultList.set(i, currentCount);
      }
    }
    return currentCount;
  }
}
