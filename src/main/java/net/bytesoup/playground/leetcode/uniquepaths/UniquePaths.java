package net.bytesoup.playground.leetcode.uniquepaths;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UniquePaths {

  private static final int START = 1;
  private static final int FINISH = 2;
  private static final int OBSTACLE = -1;

  public static int solve(List<List<Integer>> board) {
    Map<Coordinates, Node> nodes = new HashMap<>();
    Node start = null;
    Node finish = null;
    for (int i = 0; i < board.size(); ++i) {
      for (int j = 0; j < board.get(0).size(); ++j) {
        Node node = Node.builder()
            .coordinates(new Coordinates(j, i))
            .state(board
                .get(i)
                .get(j))
            .build();

        if (OBSTACLE != node.getState()) {
          nodes.put(node.getCoordinates(), node);
        }

        if (START == node.getState()) {
          start = node;
        } else if (FINISH == node.getState()) {
          finish = node;
        }
      }
    }
    if (null == start) {
      log.warn("No start node found!");
      return -1;
    }
    if (null == finish) {
      log.warn("No finish node found!");
      return -1;
    }

    attachAllNeighbors(start, nodes, new HashSet<>());

    nodes.remove(start.getCoordinates());
    return explore(start,
        new HashSet<>(nodes.values()),
        new Stack<>());
  }

  private static int explore(Node start, Set<Node> allNodes, Stack<Node> currentPath) {
    allNodes.remove(start);
    if (FINISH == start.getState()) {
      return allNodes.isEmpty() ? 1 : 0;
    }

    currentPath.push(start);
    int result = start.getNeighbors().stream().filter(Predicate.not(currentPath::contains))
        .mapToInt(n -> explore(n, new HashSet<>(allNodes), currentPath)).sum();
    currentPath.pop();
    allNodes.add(start);

    return result;
  }

  private static void attachAllNeighbors(Node start, Map<Coordinates, Node> allNodes,
      Set<Node> visited) {
    visited.add(start);
    start.setNeighbors(findAllNeighbors(start, allNodes));
    start.getNeighbors().stream().filter(Predicate.not(visited::contains))
        .forEach(n -> attachAllNeighbors(n, allNodes, visited));
  }

  private static List<Node> findAllNeighbors(Node node, Map<Coordinates, Node> allNodes) {
    return Arrays.stream(new Coordinates[]{
        new Coordinates(-1, 0),
        new Coordinates(0, -1),
        new Coordinates(0, 1),
        new Coordinates(1, 0)
    })
        .map(node.getCoordinates()::add)
        .filter(allNodes.keySet()::contains)
        .map(allNodes::get)
        .filter(n -> OBSTACLE != n.getState())
        .collect(Collectors.toList());
  }
}
