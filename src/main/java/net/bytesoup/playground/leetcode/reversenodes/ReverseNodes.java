package net.bytesoup.playground.leetcode.reversenodes;

import java.util.Stack;
import lombok.extern.slf4j.Slf4j;
import net.bytesoup.playground.leetcode.common.ListNode;

@Slf4j
public class ReverseNodes {

  public static ListNode reverseKGroup(ListNode head, int k) {
    log.debug("Reversing {} in steps of {}", head, k);
    ListNode returnNode = null;
    ListNode currentNode = head;
    ListNode endNode = head;

    try {
      ListNode lookAhead = head;
      while (true) {
        for (int i = 0; i < k; ++i) {
          lookAhead = lookAhead.getNext();
        }

        var reversedPart = reverseInPlace(currentNode, k);

        if (returnNode == null) {
          returnNode = reversedPart;
        } else {
          endNode.setNext(reversedPart);
        }

        endNode = currentNode;
        currentNode.setNext(lookAhead);
        currentNode = lookAhead;
      }
    } catch (IllegalArgumentException | NullPointerException ex) {
//
    }
    endNode.setNext(currentNode);

    return returnNode;
  }

  private static ListNode reverseInPlace(ListNode head, int k) {
    log.debug("Now reversing {} nodes of {}", k, head);
    var currentNode = head;
    Stack<ListNode> reverseStack = new Stack<>();
    reverseStack.push(currentNode);

    for (int i = 1; i < k; ++i) {
      currentNode = currentNode.getNext();
      if (currentNode == null) {
        throw new IllegalArgumentException();
      }
      reverseStack.push(currentNode);
    }
    head.setNext(null);
    currentNode = reverseStack.pop();
    var returnNode = currentNode;
    while (!reverseStack.empty()) {
      currentNode.setNext(reverseStack.pop());
      currentNode = currentNode.getNext();
    }
    return returnNode;
  }
}
