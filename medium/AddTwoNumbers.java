import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {

    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order, and each of their nodes contains a single digit.
     * Add the two numbers and return the sum as a linked list.
     * <p>
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * <p>
     * Example 1:
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     * <p>
     * Example 2:
     * Input: l1 = [0], l2 = [0]
     * Output: [0]
     * <p>
     * Example 3:
     * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * Output: [8,9,9,9,0,0,0,1]
     */

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> nodeInput = new ArrayList<>();
        int a;
        int b;
        int sum;
        int rem = 0;

        while (l1 != null && l2 != null) {
            a = l1.val;
            b = l2.val;
            sum = a + b + rem;
            if (sum >= 10) {
                rem = 1;
                sum = sum - 10;
            } else {
                rem = 0;
            }

            nodeInput.add(sum);

            l1 = l1.next;
            l2 = l2.next;
        }


        rem = getRem(l1, nodeInput, rem);

        rem = getRem(l2, nodeInput, rem);

        if (rem > 0) {
            nodeInput.add(rem);
        }

        ListNode output = null;
        for (int i = nodeInput.size() - 1; i >= 0; i--) {
            output = insert(output, nodeInput.get(i));
        }

        return output;
    }

    private static ListNode insert(ListNode root, int item) {
        ListNode temp = new ListNode();
        temp.val = item;
        temp.next = root;
        root = temp;
        return root;
    }

    private static int getRem(ListNode l1, List<Integer> nodeInput, int rem) {
        int a;
        int sum;
        while (l1 != null) {
            a = l1.val;
            sum = a + rem;
            if (sum >= 10) {
                rem = 1;
                sum = sum - 10;
            } else {
                rem = 0;
            }
            nodeInput.add(sum);
            l1 = l1.next;
        }
        return rem;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode output = addTwoNumbers(l1, l2);

        while (output != null) {
            System.out.println(output.val);
            output = output.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
