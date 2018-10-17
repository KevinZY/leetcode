package com.zhangyang.leetcode.linkedlist;

import com.zhangyang.leetcode.linkedlist.po.ListNode;

/**
 * Created by yzhang on 2018/10/17.
 */
public class MergeTwoSortedList {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode pointer = newHead;
        while (l1 != null || l2 != null) {
            ListNode weaver;
            if (l1 == null) {
                weaver = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                weaver = l1;
                l1 = l1.next;
            } else if (l1.val < l2.val) {
                weaver = l1;
                l1 = l1.next;
            } else {
                weaver = l2;
                l2 = l2.next;
            }

            pointer.next = weaver;
            pointer = weaver;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode head2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode newHead = mergeTwoLists(head1, head2);
        int[] expected = {1, 1, 2, 3, 4, 4};
        ListNode pointer = newHead;
        for (int anExpected : expected) {
            assert anExpected == pointer.val;
            pointer = pointer.next;
        }
    }
}
