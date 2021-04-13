package net.bytesoup.playground.leetcode.reversenodes;

import static net.bytesoup.playground.leetcode.common.ListNodes.getLinkedList;

import com.google.common.truth.Truth;
import lombok.extern.slf4j.Slf4j;
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
}
