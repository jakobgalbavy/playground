package net.bytesoup.playground.leetcode.uniquepaths;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@EqualsAndHashCode
@ToString
class Node {

  private Coordinates coordinates;
  @EqualsAndHashCode.Exclude
  private int state;
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private List<Node> neighbors;
}
