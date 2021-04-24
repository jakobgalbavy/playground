package net.bytesoup.playground.leetcode.formulaone;

import com.google.common.truth.Truth;
import java.util.List;
import org.junit.Test;

public class RaceTest {

  @Test
  public void oneLap_fastestTireWins() {
    Double result = Race.calculateBestRaceTime(1, List.of(
        Tire.builder().lapTime(1).degradation(2).build(),
        Tire.builder().lapTime(2).degradation(1.1).build()
    ));

    Truth.assertThat(result).isEqualTo(1);
  }

  @Test
  public void twoLaps_fastestTireWins() {
    Double result = Race.calculateBestRaceTime(2, List.of(
        Tire.builder().lapTime(1).degradation(2).build(),
        Tire.builder().lapTime(2).degradation(1.1).build()
    ));

    Truth.assertThat(result).isEqualTo(3);
  }

  @Test
  public void threeLaps_slowerTireWins() {
    Double result = Race.calculateBestRaceTime(3, List.of(
        Tire.builder().lapTime(1).degradation(2).build(),
        Tire.builder().lapTime(2).degradation(1.1).build()
    ));

    Truth.assertThat(String.format("%.2f", result)).isEqualTo("6.62");
  }

  @Test
  public void calculateWithPits() {

  }
}
