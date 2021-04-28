package net.bytesoup.playground.leetcode.uniquepaths;

import com.google.common.truth.Truth;
import java.util.Arrays;
import org.junit.Test;

public class UniquePathsTest {

  @Test
  public void example1() {
    Truth.assertThat(UniquePaths.solve(
        Arrays.asList(Arrays.asList(1, 0, 0, 0), Arrays.asList(0, 0, 0, 0),
            Arrays.asList(0, 0, 2, -1))
    )).isEqualTo(2);
  }

  @Test
  public void example2() {
    Truth.assertThat(UniquePaths.solve(
        Arrays
            .asList(Arrays.asList(1, 0, 0, 0), Arrays.asList(0, 0, 0, 0), Arrays.asList(0, 0, 0, 2))
    )).isEqualTo(4);
  }

  @Test
  public void example3() {
    Truth.assertThat(UniquePaths.solve(
        Arrays.asList(Arrays.asList(0, 1), Arrays.asList(2, 0))
    )).isEqualTo(0);
  }
}
