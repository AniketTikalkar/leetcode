/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getCount(ListNode head){
        int c=0;
        while(head != null){
            c++;
            head = head.next;
        }
        return c;
    }

    public ListNode rotateRight(ListNode head, int k) {
        int count = getCount(head);
        if(count ==0){
            return head;
        }
        k = k%count;
        //think in terms of left shifts
        k = count - k;
        
        if(k==0 || k == count){
            return head;
        }
        ListNode p1 = head;
        int c=0;
        while(c != k-1){
            c++;
            p1 = p1.next;
        }
        ListNode newHead = p1.next;
        p1.next = null;
        ListNode p2 = newHead;
        while(p2.next != null){
            p2 = p2.next;
        }
        p2.next = head;
        return newHead;
    }
}
// @lc code=end

