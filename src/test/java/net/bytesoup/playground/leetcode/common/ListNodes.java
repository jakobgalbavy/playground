package net.bytesoup.playground.leetcode.common;

import com.google.common.truth.Truth;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListNodes {

  public static ListNode getLinkedList(int... list) {
    var rootNode = new ListNode();
    var currentNode = rootNode;

    for (int number : list) {
      currentNode.setNext(ListNode.builder()
          .val(number)
          .build());
      currentNode = currentNode.getNext();
    }

    log.debug("Created Linkedlist {} from {}", rootNode, list);
    return rootNode.getNext();
  }

  public static void assertList(ListNode actual, int... expected) {
    ListNode current = actual;
    for (int i : expected) {
      Truth.assertThat(current).isNotNull();
      Truth.assertThat(current.getVal()).isEqualTo(i);
      current = current.getNext();
    }
  }
}
