package net.bytesoup.playground.leetcode.ksortedlists;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import net.bytesoup.playground.leetcode.common.ListNode;

public class PriorityQueueSortedLists {

  public static ListNode sortLists(ListNode[] lists) {
    if (lists.length < 1) {
      return new ListNode();
    }

    Queue<ListNode> queue = new PriorityQueue<>(
        Comparator.comparingInt(ListNode::getVal)
    );
    for (ListNode node : lists) {
      ListNode current = node;
      while (current != null) {
        queue.add(current);
        current = current.getNext();
      }
    }
    ListNode returnQueue = queue.remove();
    ListNode current = returnQueue;
    while (!queue.isEmpty()) {
      current.setNext(queue.remove());
      current = current.getNext();
    }
    return returnQueue;
  }
}
