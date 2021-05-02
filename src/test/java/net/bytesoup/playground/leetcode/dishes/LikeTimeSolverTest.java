package net.bytesoup.playground.leetcode.dishes;

import com.google.common.truth.Truth;
import java.util.List;
import org.junit.Test;

public class LikeTimeSolverTest {

  @Test
  public void example1() {
    Truth.assertThat(LikeTimeSolver.getMaxSatisfaction(List.of(-1, -8, 0, 5, -9))).isEqualTo(14);
  }

  @Test
  public void example2() {
    Truth.assertThat(LikeTimeSolver.getMaxSatisfaction(List.of(4, 3, 2))).isEqualTo(20);
  }

  @Test
  public void example3() {
    Truth.assertThat(LikeTimeSolver.getMaxSatisfaction(List.of(-1, -4, -5))).isEqualTo(0);
  }

  @Test
  public void example4() {
    Truth.assertThat(LikeTimeSolver.getMaxSatisfaction(List.of(-2, 5, -1, 0, 3, -3))).isEqualTo(35);
  }
}
