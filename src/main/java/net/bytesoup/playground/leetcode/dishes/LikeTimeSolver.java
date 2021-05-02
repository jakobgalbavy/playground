package net.bytesoup.playground.leetcode.dishes;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LikeTimeSolver {

  public static int getMaxSatisfaction(List<Integer> satisfactions) {
    List<Integer> sortedInputList = new ArrayList<>(satisfactions);
    sortedInputList.sort(Integer::compareTo);
    return getMaxSatisfaction(sortedInputList, 0);
  }


  private static int getMaxSatisfaction(List<Integer> satisfactions, int index) {
    if (index >= satisfactions.size()) {
      int result = 0;
      int time = 0;
      for (Integer satisfaction : satisfactions) {
        result += (++time * satisfaction);
      }
      return result;
    }
    int with = getMaxSatisfaction(new ArrayList<>(satisfactions), index + 1);
    satisfactions.remove(index);
    int without = getMaxSatisfaction(new ArrayList<>(satisfactions), index);
    return Math.max(with, without);
  }
}
