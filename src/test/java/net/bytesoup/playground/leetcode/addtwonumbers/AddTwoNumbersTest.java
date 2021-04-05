package net.bytesoup.playground.leetcode.addtwonumbers;

import com.google.common.truth.Truth;
import lombok.extern.slf4j.Slf4j;
import net.bytesoup.playground.leetcode.common.ListNode;
import org.junit.Test;

@Slf4j
public class AddTwoNumbersTest {

  AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

  @Test
  public void onePlusOne_returnsTwo() {
    var result = addTwoNumbers
        .addTwoNumbers(getNodesFor("1"), getNodesFor("1"));
    Truth.assertThat(result.getVal()).isEqualTo(2);
  }

  @Test
  public void tenPlusTen_returnsTwenty() {
    var node10 = getNodesFor("10");
    log.debug("Node10 = {}", node10);

    var result = addTwoNumbers
        .addTwoNumbers(node10, node10);
    Truth.assertThat(result.getVal()).isEqualTo(0);
    Truth.assertThat(result.getNext().getVal()).isEqualTo(2);
  }

  @Test
  public void ninePlusNine_correctCarry_returnsEighteen() {
    var result = addTwoNumbers
        .addTwoNumbers(getNodesFor("9"), getNodesFor("9"));
    Truth.assertThat(result.getVal()).isEqualTo(8);
    Truth.assertThat(result.getNext().getVal()).isEqualTo(1);
  }

  @Test
  public void largeNumbersTest_correctCarry_returnsCorrect() {
    var result = addTwoNumbers
        .addTwoNumbers(getNodesFor("999"), getNodesFor("999"));
    Truth.assertThat(result.getVal()).isEqualTo(8);
    Truth.assertThat(result.getNext().getVal()).isEqualTo(9);
    Truth.assertThat(result.getNext().getNext().getVal()).isEqualTo(9);
    Truth.assertThat(result.getNext().getNext().getNext().getVal()).isEqualTo(1);
  }

  @Test
  public void numbersWithNotEqualDigits_correctCarry_returnsCorrect() {
    var result = addTwoNumbers
        .addTwoNumbers(getNodesFor("9999999"), getNodesFor("9999"));
    Truth.assertThat(result.getVal()).isEqualTo(8);
    Truth.assertThat(result.getNext().getVal()).isEqualTo(9);
    Truth.assertThat(result.getNext().getNext().getVal()).isEqualTo(9);
    Truth.assertThat(result.getNext().getNext().getNext().getVal()).isEqualTo(9);
    Truth.assertThat(result.getNext().getNext().getNext().getNext().getVal()).isEqualTo(0);
    Truth.assertThat(result.getNext().getNext().getNext().getNext().getNext().getVal())
        .isEqualTo(0);
    Truth.assertThat(result.getNext().getNext().getNext().getNext().getNext().getNext().getVal())
        .isEqualTo(0);
    Truth.assertThat(
        result.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getVal())
        .isEqualTo(1);
  }

  private ListNode getNodesFor(String number) {
    ListNode rootNode = new ListNode();
    ListNode node = rootNode;
    for (char c : new StringBuilder(number).reverse().toString().toCharArray()) {
      node.setNext(new ListNode(Integer.parseInt(String.valueOf(c)), null));
      node = node.getNext();
    }
    return rootNode.getNext();
  }
}
