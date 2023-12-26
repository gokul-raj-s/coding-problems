public class RemoveNthNodeFromListEnd {

    /**
     * Given the head of a linked list, remove the nth node from the end of the list and return its head.
     * <p>
     * Example 1:
     * Input: head = [1,2,3,4,5], n = 2
     * Output: [1,2,3,5]
     * <p>
     * Example 2:
     * Input: head = [1], n = 1
     * Output: []
     * <p>
     * Example 3:
     * Input: head = [1,2], n = 1
     * Output: [1]
     */
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            head = head.next;
            return head;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    private static ListNode push(ListNode head, int data) {
        ListNode newNode = new ListNode(data);

        newNode.next = head;

        head = newNode;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(7);

        head = push(head, 6);
        head = push(head, 5);
        head = push(head, 4);
        head = push(head, 3);
        head = push(head, 2);
        head = push(head, 1);

        removeNthFromEnd(head, 4);

        System.out.println("Output");
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class ListNode {
    int val;
    com.coding.problems.medium.ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, com.coding.problems.medium.ListNode next) {
        this.val = val;
        this.next = next;
    }
}

