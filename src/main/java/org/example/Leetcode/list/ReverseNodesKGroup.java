package org.example.Leetcode.list;

// https://leetcode.com/problems/reverse-nodes-in-k-group/description/

public class ReverseNodesKGroup {

    // in constant space complexity
    public ListNode reverseKGroup2(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode tmp = head;
        ListNode revPointer1 = head.next.next;
        ListNode revPointer2 = head.next;
        ListNode revPointer3 = head;
        for(int i = 0; i < k; i++) {
            if(tmp == null) return head;
            tmp = tmp.next;
        }
        head.next = reverseKGroup(tmp, k);
        for(int i = 0; i < k-1 ; i++) {
            revPointer2.next = revPointer3;
            revPointer3 = revPointer2;
            revPointer2 = revPointer1;
            if(revPointer1 != null)
                revPointer1 = revPointer1.next;
        }
        return revPointer3;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        ListNode[] arr = new ListNode[k];
        ListNode tmp = head;
        for(int i = 0; i < k; i++) {
            if(tmp == null) {
                return arr[0];
            }
            arr[i] = tmp;
            tmp = tmp.next;

        }
        head.next = reverseKGroup(arr[k-1].next, k);
        for(int i = k-1; i > 0 ; i--) {
            arr[i].next = arr[i-1];
        }
        return arr[k-1];
    }
}
