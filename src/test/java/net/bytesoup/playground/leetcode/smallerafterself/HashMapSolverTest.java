package net.bytesoup.playground.leetcode.smallerafterself;

import com.google.common.truth.Truth;
import java.util.List;
import org.junit.Test;

public class HashMapSolverTest {

  @Test
  public void example1() {
    Truth.assertThat(HashMapSolver.countSmaller(List.of(5, 2, 6, 1)))
        .isEqualTo(List.of(2, 1, 1, 0));
  }

  @Test
  public void example2() {
    Truth.assertThat(HashMapSolver.countSmaller(List.of(-1))).isEqualTo(List.of(0));
  }

  @Test
  public void example3() {
    Truth.assertThat(HashMapSolver.countSmaller(List.of(-1, -1))).isEqualTo(List.of(0, 0));
  }
}
