package net.bytesoup.playground.leetcode.jumpgame5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.IntStream;

public class Solution {

  public static int maxJumps(List<Integer> towers, int maxJump) {
    Map<Integer, Integer> cacheMap = new HashMap<>();
    return IntStream.rangeClosed(0, towers.size() - 1).map(idx -> {
          Stack<Integer> stack = new Stack<>();
          stack.push(idx);
          return maxJumps(towers, stack, maxJump, cacheMap);
        }
    ).max().orElse(0);
  }

  private static int maxJumps(List<Integer> towers, Stack<Integer> visited, int maxJump,
      Map<Integer, Integer> cache) {
    if (visited.size() == towers.size()) {
      return 1;
    }

    int currentTowerIdx = visited.peek();
    Map<Integer, Integer> maxJumpsList = new HashMap<>();
    for (int i = Math.max(0, currentTowerIdx - maxJump);
        i < Math.min(towers.size(), currentTowerIdx + maxJump + 1); ++i) {
      if (currentTowerIdx == i) {
        continue;
      }
      if (canJump(towers, currentTowerIdx, i)) {
        if (cache.containsKey(i)) {
          return cache.get(i);
        }
        visited.push(i);
        int value = maxJumps(towers, visited, maxJump, cache);
        cache.put(i, value + 1);
        maxJumpsList.put(i, maxJumpsList.getOrDefault(i, 1) + value);
        visited.pop();
      }
    }

    return maxJumpsList.values().stream().max(Integer::compareTo).orElse(1);
  }

  private static boolean canJump(List<Integer> towers, int fromIdx, int toIdx) {
    if (fromIdx == toIdx) {
      return false;
    }
    int current = towers.get(fromIdx);
    if (fromIdx < toIdx) {
      for (int i = fromIdx + 1; i <= toIdx; ++i) {
        int next = towers.get(i);
        if (current <= next) {
          return false;
        }
      }
    } else {
      for (int i = fromIdx - 1; i >= toIdx; --i) {
        int next = towers.get(i);
        if (current <= next) {
          return false;
        }
      }
    }
    return true;
  }

  private Solution() {
  }
}
