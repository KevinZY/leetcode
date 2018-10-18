package com.zhangyang.leetcode.linkedlist;

import com.zhangyang.leetcode.linkedlist.po.ListNode;

/**
 * Created by zhangyang on 2018/10/18.
 */
public class RemoveEndFromList {

    /**
     * Time O(n)
     * Space O(1)
     *
     * @param head
     * @param n
     * @return
     */
public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode watchdog = new ListNode(-1);
    watchdog.next = head;
    ListNode first = head;
    ListNode second = watchdog;
    while (first != null) {
        first = first.next;
        if ((--n) < 0) second = second.next;
    }
    second.next = second.next.next;
    return watchdog.next;
}

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode newHead = removeNthFromEnd(head, 2);

        ListNode node = new ListNode(1, new ListNode(2));
        ListNode node1 = removeNthFromEnd(node, 2);

        ListNode node2 = removeNthFromEnd(new ListNode(1), 1);
        return;
    }
}
