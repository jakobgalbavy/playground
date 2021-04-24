package net.bytesoup.playground.leetcode.smallerafterself;

import com.google.common.collect.ImmutableMultimap;
import java.util.ArrayList;
import java.util.List;

public class HashMapSolver {

  public static List<Integer> countSmaller(List<Integer> nums) {
    var memoMapBuilder = ImmutableMultimap.<Integer, Integer>builder();
    for (int i = 0; i < nums.size(); ++i) {
      memoMapBuilder.put(nums.get(i), i);
    }

    var result = new ArrayList<>(nums);
    var memoMap = memoMapBuilder.build();

    for (int i = 0; i < nums.size(); ++i) {
      final int currentValue = result.get(i);
      final int currentIdx = i;

      result.set(i,
          memoMap.keys().stream()
              .filter(k -> k < currentValue)
              .mapToInt(idx -> (int) memoMap.get(idx)
                  .stream()
                  .filter(v -> v > currentIdx)
                  .count())
              .sum()
      );
    }

    return result;
  }
}
