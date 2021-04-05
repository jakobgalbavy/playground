package net.bytesoup.playground.leetcode.reversenodes;

import com.google.common.truth.Truth;
import lombok.extern.slf4j.Slf4j;
import net.bytesoup.playground.leetcode.common.ListNode;
import org.junit.Test;

@Slf4j
public class ReverseNodesTest {

  @Test
  public void example4_swapOne_noSwaps() {
    var reversedValue = ReverseNodes.reverseKGroup(getLinkedList(1), 1);
    Truth.assertThat(reversedValue).isEqualTo(getLinkedList(1));
  }

  @Test
  public void example3_swapOne_noSwaps() {
    var reversedValue = ReverseNodes.reverseKGroup(getLinkedList(1, 2, 3, 4, 5), 1);
    Truth.assertThat(reversedValue).isEqualTo(
        getLinkedList(1, 2, 3, 4, 5)
    );
  }

  @Test
  public void example2_swapThree_multipleSwaps() {
    var reversedValue = ReverseNodes.reverseKGroup(getLinkedList(1, 2, 3, 4, 5), 3);
    Truth.assertThat(reversedValue).isEqualTo(
        getLinkedList(3, 2, 1, 4, 5)
    );
  }

  @Test
  public void example1_swapTwo_multipleSwaps() {
    var reversedValue = ReverseNodes.reverseKGroup(getLinkedList(1, 2, 3, 4, 5), 2);
    Truth.assertThat(reversedValue).isEqualTo(
        getLinkedList(2, 1, 4, 3, 5)
    );
  }

  @Test
  public void simple_swapTwo_oneLeft() {
    var reversedValue = ReverseNodes.reverseKGroup(getLinkedList(1, 2, 3), 2);
    Truth.assertThat(reversedValue).isEqualTo(getLinkedList(2, 1, 3));
  }

  @Test
  public void simple_swapTwo() {
    var reversedValue = ReverseNodes.reverseKGroup(getLinkedList(1, 2), 2);
    Truth.assertThat(reversedValue).isEqualTo(getLinkedList(2, 1));
  }

  @Test
  public void simple_swapOne() {
    var reversedValue = ReverseNodes.reverseKGroup(getLinkedList(1, 2), 1);
    Truth.assertThat(reversedValue).isEqualTo(getLinkedList(1, 2));
  }

  private ListNode getLinkedList(int... list) {
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
}
