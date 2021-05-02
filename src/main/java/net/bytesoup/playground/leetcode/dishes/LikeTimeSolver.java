package net.bytesoup.playground.leetcode.dishes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LikeTimeSolver {

  private static BiFunction<Integer, Integer, Integer> likeTimeFn = (time, like) -> time * like;

  public static int getMaxSatisfaction(List<Integer> satisfactions) {
    log.info("Invoked as {} ", satisfactions);
    List<Integer> sortedInputList = new ArrayList<>(satisfactions);
    sortedInputList.sort(Integer::compareTo);
    return getMaxSatisfaction(sortedInputList, 0);
  }


  private static int getMaxSatisfaction(List<Integer> satisfactions, int index) {
    log.info("getMaxSatisfaction({}, {})", satisfactions, index);
    if (index >= satisfactions.size()) {
      int result = 0;
      int time = 0;
      for (Integer satisfaction : satisfactions) {
        result += likeTimeFn.apply(++time, satisfaction);
      }
      log.info("Input {} transformed to {}", satisfactions, result);
      return result;
    }
    int with = getMaxSatisfaction(new ArrayList<>(satisfactions), index + 1);
    Integer whatWasIt = satisfactions.remove(index);
    int without = getMaxSatisfaction(new ArrayList<>(satisfactions), index);
    log.info("Figuring out max of {} ({} + {}) and {} ({})", with, whatWasIt, satisfactions,
        without, satisfactions);
    return Math.max(with, without);
  }
}
