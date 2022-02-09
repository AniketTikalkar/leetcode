import java.util.Scanner;

public class Implementation {
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of linklist: ");
        int n = sc.nextInt();
        Node prevNode = null;
        Node head = null;
        while (n > 0) {
            System.out.println("Enter data for node:");
            int val = sc.nextInt();
            Node node = new Node(val, null);
            if (prevNode != null) {
                prevNode.next = node;
            } else {
                head = node;
            }
            prevNode = node;
            n--;
        }
        sc.close();
        printList(head);

    }
}
