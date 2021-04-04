package net.bytesoup.playground.leetcode.medianofsortedarrays;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Median {

  public static double calculateMedian(int[] array1, int[] array2) {
    List<Integer> integerList = IntStream.concat(IntStream.of(array1), IntStream.of(array2))
        .distinct().boxed()
        .sorted()
        .collect(Collectors.toList());

    if (integerList.size() == 0) {
      return 0;
    }

    if (integerList.size() == 1) {
      return integerList.get(0);
    }

    double mid = ((double) integerList.size()) / 2;
    log.debug("Mid is {}", mid);

    if (integerList.size() % 2 == 1) {
      return integerList.get((int) Math.ceil(mid) - 1);
    }

    return ((double) integerList.get((int) mid - 1) + integerList.get((int) mid))
        / 2;
  }
}
