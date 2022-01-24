
public class MiddleOfLinkList {
    public int getLen(ListNode head){
        int n =0;
        while(head != null){
            head = head.next;
            n++;
        }
        return n;
    }
    public ListNode middleNode(ListNode head) {
        int n = getLen(head);
        int m = n/2;
        while(m !=0){
            head = head.next;
            m--;
        }
        return head;
    }
    public static void main(String[] args) {
        /**
         * Given the head of a singly linked list, return the middle node of the linked list.
         */
    }
}
class ListNode {
    int val;
   ListNode next;
   ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
