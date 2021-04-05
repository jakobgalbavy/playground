package net.bytesoup.playground.leetcode.common;

public class ListNodes {

  private ListNodes() {
  }

  public static int getVal(ListNode node) {
    return node != null ? node.getVal() : 0;
  }
}
