package org.example.Leetcode.list;

// https://leetcode.com/problems/add-two-numbers/


public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tmp = head;
        boolean carry = false;
        while(l1 != null || l2 != null) {
            int d = 0;
            if(l1 != null && l2 != null) {
                d = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if(l1 != null) {
                d = l1.val;
                l1 = l1.next;
            } else {
                d = l2.val;
                l2 = l2.next;
            }
            if(carry) {
                d++;
                carry = false;
            }
            if(d > 9) {
                tmp.val = d%10;
                carry = true;
            } else {
                tmp.val = d;
            }
            tmp.next = new ListNode();
        }
        if(carry) {
            tmp.val = 1;
        } else {
            tmp.next = null;
        }
        return head;
    }

}

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}