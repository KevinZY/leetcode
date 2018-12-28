package com.zhangyang.leetcode.linkedlist;

import com.zhangyang.leetcode.linkedlist.po.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhangyang on 2018/12/16.
 */
public class AddTwoNumbersTest {
    @Test
    public void addTwoNumbers() throws Exception {
        //(2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode node1 = ListNode.builder().add(9).build();
        ListNode node2 = ListNode.builder().add(1).add(9).add(9).add(9).build();
        ListNode node = new AddTwoNumbers().addTwoNumbers(node2, node1);
    }

}