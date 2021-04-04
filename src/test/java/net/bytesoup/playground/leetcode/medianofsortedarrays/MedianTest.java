package net.bytesoup.playground.leetcode.medianofsortedarrays;


import com.google.common.truth.Truth;
import org.junit.Test;

public class MedianTest {

  @Test
  public void emptyTest_returnsZero() {
    double median = Median.calculateMedian(new int[]{}, new int[]{});
    Truth.assertThat(median).isEqualTo(0);
  }

  @Test
  public void onlyOneValueLeft_returnsCorrect() {
    double median = Median.calculateMedian(new int[]{1}, new int[]{});
    Truth.assertThat(median).isEqualTo(1);
  }

  @Test
  public void onlyOneValueRight_returnsCorrect() {
    double median = Median.calculateMedian(new int[]{}, new int[]{1});
    Truth.assertThat(median).isEqualTo(1);
  }

  @Test
  public void oddNumberOfValues_returnsCorrect() {
    double median = Median.calculateMedian(new int[]{1, 2, 3}, new int[]{4, 5});
    Truth.assertThat(median).isEqualTo(3);
  }

  @Test
  public void evenNumberOfValues_returnsCorrect() {
    double median = Median.calculateMedian(new int[]{1, 3}, new int[]{2, 4});
    Truth.assertThat(median).isEqualTo(2.5);
  }

  @Test
  public void allZeros_returnsZero() {
    double median = Median.calculateMedian(new int[]{0, 0}, new int[]{0, 0, 0, 0, 0, 0, 0, 0});
    Truth.assertThat(median).isEqualTo(0);
  }
}
