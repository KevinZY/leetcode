package com.zhangyang.leetcode.linkedlist;

import com.zhangyang.leetcode.linkedlist.po.ListNode;

/**
 * Created by zhangyang on 2018/10/18.
 */
public class MiddleOfTheList {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode middle1 = middleNode(head1);
        assert middle1.val == 3;
        assert middle1.next.val == 4;
        assert middle1.next.next.val == 5;
        assert middle1.next.next.next == null;

        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode middle2 = middleNode(head2);
        assert middle2.val == 4;
        assert middle2.next.val == 5;
        assert middle2.next.next.val == 6;
        assert middle2.next.next.next == null;
    }
}
