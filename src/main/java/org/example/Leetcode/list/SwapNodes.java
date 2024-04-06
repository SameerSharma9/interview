package org.example.Leetcode.list;

// https://leetcode.com/problems/swap-nodes-in-pairs/

public class SwapNodes {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode p1 = head;
        ListNode p2 = p1.next;
        p1.next = swapPairs(p2.next);
        p2.next = p1;
        return p2;
    }
}

