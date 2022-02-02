public class RemoveNthFromEnd {
    public int getLen(ListNode head) {
        int c = 0;
        while (head != null) {
            head = head.next;
            c++;
        }
        return c;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return head;
        }
        int l = getLen(head);
        ListNode p = head;
        l = l - n;
        if (l == 0) {
            return head.next;
        }
        while (l > 1) {
            p = p.next;
            l--;
        }
        if (p.next != null) {
            ListNode r = p.next;
            p.next = r.next;
            r.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        /**
         * Given the head of a linked list, remove the nth node from the end of the list
         * and return its head.
         */
    }
}
