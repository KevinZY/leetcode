package com.zhangyang.leetcode.linkedlist;

/**
 * Created by yzhang on 2018/10/16.
 */
public class ListCircle {

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
//        ListNode listNode6 = new ListNode(6);
//        ListNode listNode7 = new ListNode(7);
//        ListNode listNode8 = new ListNode(8);
//        ListNode listNode9 = new ListNode(9);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode3;

        boolean hasCycle = ListCircle.hasCycle(listNode1);
        assert hasCycle;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
