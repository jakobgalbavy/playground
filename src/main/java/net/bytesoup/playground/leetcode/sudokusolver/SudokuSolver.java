package net.bytesoup.playground.leetcode.sudokusolver;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SudokuSolver {

  private static final String BLANK = ".";

  public static List<List<String>> solve(List<List<String>> board) {
    List<List<String>> workBoard = new ArrayList<>();
    Deque<Node> queue = new LinkedList<>();
    for (int row = 0; row < 9; ++row) {
      workBoard.add(row, new ArrayList<>(board.get(row)));
      for (int column = 0; column < 9; ++column) {
        String field = board.get(row).get(column);
        if (BLANK.equals(field)) {
          queue.addLast(new Node(column, row));
        }
      }
    }
    int lastSize = -1;
    while (!queue.isEmpty()) {
      Node node = queue.removeFirst();
      if (lastSize == queue.size()) {
        log.warn("PANIC!\n**************\nQueue:\n{}\nBoard:\n{}", queue, board);
        return board;
      }
      if (!evaluateNode(node, workBoard)) {
        queue.addLast(node);
      }
      lastSize = queue.size();
    }
    return workBoard;
  }

  private static boolean evaluateNode(Node node, List<List<String>> board) {
    // Lines
    board.get(node.y).stream().filter(s -> !BLANK.equals(s))
        .forEach(node.possibleValues::remove);
    if (checkAndSetNode(node, board)) {
      return true;
    }

    // Rows
    board.stream().map(l -> l.get(node.x)).filter(s -> !BLANK.equals(s))
        .forEach(node.possibleValues::remove);
    if (checkAndSetNode(node, board)) {
      return true;
    }

    // Squares
    int columnMultiplier = Math.floorDiv(node.x, 3);
    int rowMultiplier = Math.floorDiv(node.y, 3);
    board.subList(3 * rowMultiplier, 3 + (3 * rowMultiplier)).stream()
        .flatMap(l -> l.subList(3 * columnMultiplier, 3 + (3 * columnMultiplier)).stream())
        .filter(s -> !BLANK.equals(s))
        .forEach(node.possibleValues::remove);
    return checkAndSetNode(node, board);
  }

  private static boolean checkAndSetNode(Node node, List<List<String>> board) {
    if (node.possibleValues.size() > 1) {
      return false;
    }

    board.get(node.y).set(node.x, Iterables.getOnlyElement(node.possibleValues));
    return true;
  }

  @Data
  @RequiredArgsConstructor
  private static class Node {

    private final int x;
    private final int y;
    private Set<String> possibleValues = new HashSet<>(
        Set.of("1", "2", "3", "4", "5", "6", "7", "8", "9"));
  }
}
