package org.example.Leetcode.list;

public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        int pos = 1;
        ListNode cur = head;
        ListNode pr = null;
        while(cur != null && pos < left) {
            pr = cur;
            cur = cur.next;
            pos++;
        }
        if(cur == null || cur.next == null ) return head;
        ListNode p = null;
        ListNode c = cur;
        ListNode fw = c.next;

        while(fw != null && pos < right) {
            c.next = p;
            p = c;
            c = fw;
            fw = fw.next;
            pos++;
        }

        c.next = p;

        cur.next = fw;
        if(left > 1)
            pr.next = c;
        if(null == pr) {
            return c;
        } else {
            return head;
        }
    }
}
