package net.bytesoup.playground.leetcode.wildcardmatching;

import java.util.HashMap;
import java.util.Map;

public class WildcardMatcher {

  public static final String WILDCARD_ANY = "*";
  public static final String WILDCARD_SINGLE = "?";

  public static boolean isMatch(String s, String p) {
    if (WILDCARD_ANY.equals(p)) {
      return true;
    }
    Map<Integer, Integer> pointers = new HashMap<>();
    for (Character c : s.toCharArray()) {
      var string = String.valueOf(c);
      for (var entry : pointers.entrySet()) {
        if (isStringEqual(string, p.substring(entry.getValue(), entry.getValue() + 1))) {
          entry.setValue(entry.getValue() + 1);
          if (entry.getValue() >= p.length()) {
            return true;
          }
        }
      }
      if (isStringEqual(string, p.substring(0, 1))) {
        if (p.length() == 1) {
          return true;
        }
        pointers.put(pointers.size(), 1);
      }
    }
    return false;
  }

  private static boolean isStringEqual(String s1, String s2) {
    return s2.isBlank() ||
        s1.equals(s2) ||
        (!s1.isBlank() &&
            (WILDCARD_ANY.equals(s2) || WILDCARD_SINGLE.equals(s2)
            ));
  }
}
