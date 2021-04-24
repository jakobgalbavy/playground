package net.bytesoup.playground.leetcode.wildcardmatching;

import java.util.AbstractMap;
import java.util.stream.IntStream;

public class WildcardMatcher {

  public static final String WILDCARD_ANY = "*";
  public static final String WILDCARD_SINGLE = "?";

  public static boolean isMatch(String s, String p) {
    if (WILDCARD_ANY.equals(p)) {
      return true;
    }
    IntStream.range(0, s.length()).mapToObj(i ->
        new AbstractMap.SimpleEntry<>(
            i, isStringEqual(s, p, i)

        )

    );
    return false;
  }

  private static boolean isStringEqual(String s, String p, int index) {
    String sAtIndex = String.valueOf(s.charAt(index));
    String pAtIndex = String.valueOf(p.charAt(index));

    return p.isBlank() ||
        s.equals(p) ||
        (!s.isBlank() &&
            (WILDCARD_ANY.equals(p) || WILDCARD_SINGLE.equals(p)
            ));
  }
}
