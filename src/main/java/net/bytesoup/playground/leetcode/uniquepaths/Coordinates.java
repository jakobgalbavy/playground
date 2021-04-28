package net.bytesoup.playground.leetcode.uniquepaths;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Coordinates {

  private int x;
  private int y;

  public Coordinates add(Coordinates coordinates) {
    return new Coordinates(x + coordinates.x, y + coordinates.y);
  }
}
