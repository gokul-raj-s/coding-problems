public class RemoveMNodeFromNthNode {

    /**
     * Given the head of a linked list, remove m nodes from nth node and return its head.
     *
     * Example 1:
     * Input: head = [1,2,3,4,5], n = 2, m = 2
     * Output: [1,2,5]
     *
     * Example 2:
     * Input: head = [1,2], n = 1
     * Output: [1]
     */
    private static void removeMNodesFromNthNode(ListNode head, int m, int n) {

        ListNode curr = head;

        for (int i = 1; i < n; i++) {
            curr = curr.next;
        }

        for (int i = 0; i < m; i++) {
            curr.next = curr.next.next;
        }
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

        removeMNodesFromNthNode(head, 3, 2);

        while (head != null) {
            System.out.print(head.val + " ");
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
