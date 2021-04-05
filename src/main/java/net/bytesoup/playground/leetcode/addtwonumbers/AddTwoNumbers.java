package net.bytesoup.playground.leetcode.addtwonumbers;

import static net.bytesoup.playground.leetcode.common.ListNodes.getVal;

import lombok.extern.slf4j.Slf4j;
import net.bytesoup.playground.leetcode.common.ListNode;

@Slf4j
public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    log.debug("Input is {}, {}", l1, l2);

    int carry = 0;
    ListNode current1 = l1;
    ListNode current2 = l2;
    ListNode rootNode = new ListNode();
    ListNode currentResultNode = rootNode;
    do {
      int resultVal = getVal(current1) + getVal(current2) + carry;
      carry = resultVal / 10;

      current1 = current1 == null ? null : current1.getNext();
      current2 = current2 == null ? null : current2.getNext();
      log.debug("Calc is {} + {} = {} ({}). Next: {}, {}", getVal(current1), getVal(current2),
          resultVal, carry, current1, current2);
      currentResultNode.setNext(new ListNode(resultVal % 10, null));
      currentResultNode = currentResultNode.getNext();
    } while (!(current1 == null && current2 == null));

    if (carry != 0) {
      currentResultNode.setNext(new ListNode(carry, null));
    }
    return rootNode.getNext();
  }
}
