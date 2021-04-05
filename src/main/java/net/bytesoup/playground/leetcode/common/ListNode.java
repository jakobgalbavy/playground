package net.bytesoup.playground.leetcode.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListNode {

  private int val;
  private ListNode next = null;
}
