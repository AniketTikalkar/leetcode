/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
    public  ListNode rev(ListNode head,int k){
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = head;
        int c=0;
        while(temp != null && c != k){
            c++;
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
        
    }
    public  ListNode incr(ListNode temp,int k){
        int c=0;
        while(temp != null && c != k){
            c++;
            temp = temp.next;
        }
        return temp;
    }
    public  boolean premature(ListNode temp,int k){
        int c=0;
        while(temp != null && c != k){
            c++;
            temp = temp.next;
        }
        return c<k;
    }
    public ListNode reverseKGroup(ListNode node, int k) {
        ListNode prev = node;
        ListNode newHead = null;
        ListNode curr = node;
        ListNode temp = node;
        ListNode root = null;
        if(k ==0 || node == null){
            return node;
        }
        while(temp != null){
            boolean isprem = premature(temp, k);
            temp = incr(temp,k);
            
            if(root == null){
                newHead = rev(curr,k);
                root = newHead;
                prev = curr;
                curr = temp;
            }
            else if(temp != null){
                prev.next = rev(curr,k);
                prev = curr;
                curr= temp;
            }
            else if(isprem && temp == null){
                prev.next = curr;
            }
            
            
        }
        return root;
    }
}
// @lc code=end

