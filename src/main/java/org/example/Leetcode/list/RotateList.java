package org.example.Leetcode.list;

// https://leetcode.com/problems/rotate-list/description/

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!= null) {
            len++;
            fast = fast.next;
        }
        fast = head;
        if(k > len) k = len%k;
        for(int i = 0; i < k; i++) {
            fast = fast.next;
        }
        System.out.println();
        while(fast.next!= null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}
