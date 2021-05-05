package net.bytesoup.playground.leetcode.jumpgame5;

import com.google.common.truth.Truth;
import java.util.List;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void example1() {
    Truth.assertThat(Solution.maxJumps(List.of(6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12), 2))
        .isEqualTo(4);
  }

  @Test
  public void example2() {
    Truth.assertThat(Solution.maxJumps(List.of(3, 3, 3, 3, 3), 3)).isEqualTo(1);
  }

  @Test
  public void example3() {
    Truth.assertThat(Solution.maxJumps(List.of(7, 6, 5, 4, 3, 2, 1), 1)).isEqualTo(7);
  }

  @Test
  public void example4() {
    Truth.assertThat(Solution.maxJumps(List.of(7, 1, 7, 1, 7, 1), 2)).isEqualTo(2);
  }

  @Test
  public void example5() {
    Truth.assertThat(Solution.maxJumps(List.of(66), 1)).isEqualTo(1);
  }
}
