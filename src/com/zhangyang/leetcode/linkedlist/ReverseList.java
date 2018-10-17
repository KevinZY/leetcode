package com.zhangyang.leetcode.linkedlist;

/**
 * Created by yzhang on 2018/10/16.
 */
public class ReverseList {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode a = head.next;
        ListNode b;
        head.next = null;
        while (a != null) {
            b = a.next;
            a.next = head;
            head = a;
            a = b;
        }

        return head;
    }

    /**
     * Time: O(n)
     * Space: O(1)
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * Time: O(n)
     * Space: O(n) stack space due to recursion
     * @param head
     * @return
     */
    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reverseList = ReverseList.reverseList3(head);
        int val = 5;
        ListNode node = reverseList;
        while (node != null || val > 0) {
            assert node.val == val;
            val--;
            node = node.next;
        }
    }

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
