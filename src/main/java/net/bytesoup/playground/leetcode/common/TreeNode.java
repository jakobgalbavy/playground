package net.bytesoup.playground.leetcode.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TreeNode {

  private final int value;
  private TreeNode left;
  private TreeNode right;
}
