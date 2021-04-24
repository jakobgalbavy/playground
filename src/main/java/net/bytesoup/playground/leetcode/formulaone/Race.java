package net.bytesoup.playground.leetcode.formulaone;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.Builder;
import lombok.Data;

public class Race {

  private Race() {
  }

  private static double calculateBestRaceTime(int laps, Tire tire) {
    return IntStream.range(0, laps).asDoubleStream()
        .map(e -> tire.getLapTime() * Math.pow(tire.getDegradation(), e)).sum();
  }

  public static double calculateBestRaceTime(int laps, Collection<Tire> tires) {
    return tires.stream().map(t -> calculateBestRaceTime(laps, t)).min(Double::compareTo)
        .orElseThrow();
  }

  public static double calculateBestRaceTimeWithPit(int laps, double pitTime,
      Collection<Tire> tires) {
    List<Stint> stints = tires.stream().map(t -> mapStint(t, pitTime)).collect(Collectors.toList());
    Stint fastestStint = stints.stream().min(Comparator.comparingDouble(Stint::getTime))
        .orElseThrow();
    int lapsDone = Math.floorDiv(laps, fastestStint.laps);
    int lapsToGo = laps - lapsDone;
    double timePassed = fastestStint.time * lapsDone;
    return timePassed + calculateBestRaceTime(lapsToGo, tires);
  }

  private static Stint mapStint(Tire tire, double pitTime) {
    Stint stint = Stint.builder().tire(tire).build();
    if (tire.getDegradation() == 1) {
      return stint;
    }
    double lastLaptime = tire.getLapTime();
    while (lastLaptime - tire.getLapTime() < pitTime) {
      lastLaptime = tire.getLapTime() * Math.pow(tire.getDegradation(), stint.laps++);
      stint.time += lastLaptime;
    }
    return stint;
  }

  @Data
  @Builder
  private class Stint {

    private Tire tire;
    private int laps = -1;
    private double time = -1;
  }
}
