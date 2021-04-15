package net.bytesoup.playground.leetcode.wildcardmatching;

import com.google.common.truth.Truth;
import org.junit.Test;

public class WildcardMatcherTest {

  /*
  Example 1:

  Input: s = "aa", p = "a"
  Output: false
  Explanation: "a" does not match the entire string "aa".
  */
  @Test
  public void example1() {
    Truth.assertThat(WildcardMatcher.isMatch("aa", "a")).isFalse();
  }

  /*
Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
*/
  @Test
  public void example2() {
    Truth.assertThat(WildcardMatcher.isMatch("aa", "*")).isTrue();
  }

  /*
  Example 3:

  Input: s = "cb", p = "?a"
  Output: false
  Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
  */
  @Test
  public void example3() {
    Truth.assertThat(WildcardMatcher.isMatch("cb", "?a")).isFalse();
  }

  /*
  Example 4:

  Input: s = "adceb", p = "*a*b"
  Output: true
  Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
  */
  @Test
  public void example4() {
    Truth.assertThat(WildcardMatcher.isMatch("adceb", "*a*b")).isTrue();
  }

  /*
  Example 5:

  Input: s = "acdcb", p = "a*c?b"
  Output: false
   */
  @Test
  public void example5() {
    Truth.assertThat(WildcardMatcher.isMatch("acdcb", "a*c?b")).isFalse();
  }

}
