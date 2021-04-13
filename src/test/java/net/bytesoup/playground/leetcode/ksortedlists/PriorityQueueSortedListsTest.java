package net.bytesoup.playground.leetcode.ksortedlists;

import com.google.common.truth.Truth;
import lombok.extern.slf4j.Slf4j;
import net.bytesoup.playground.leetcode.common.ListNode;
import net.bytesoup.playground.leetcode.common.ListNodes;
import org.junit.Test;

@Slf4j
public class PriorityQueueSortedListsTest {

  /**
   * Input: lists = [[1,4,5],[1,3,4],[2,6]] Output: [1,1,2,3,4,4,5,6] Explanation: The linked-lists
   * are: [ 1->4->5, 1->3->4, 2->6 ] merging them into one sorted list: 1->1->2->3->4->4->5->6
   */
  @Test
  public void example1Test() {
    ListNode result = PriorityQueueSortedLists.sortLists(
        new ListNode[]{
            ListNodes.getLinkedList(1, 4, 5),
            ListNodes.getLinkedList(1, 3, 4),
            ListNodes.getLinkedList(2, 6)
        });
    log.debug("Resulted List: {}", result);
    ListNodes.assertList(result, 1, 1, 2, 3, 4, 4, 5, 6);
  }

  /**
   * Input: lists = [] Output: []
   */
  @Test
  public void example2Test() {
    ListNode result = PriorityQueueSortedLists.sortLists(
        new ListNode[]{});
    log.debug("Resulted List: {}", result);
    Truth.assertThat(result.getNext()).isNull();
  }

  /**
   * Input: lists = [[]] Output: []
   */
  @Test
  public void example3Test() {

  }
}
