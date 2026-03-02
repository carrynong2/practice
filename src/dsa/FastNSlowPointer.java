package dsa;

public class FastNSlowPointer {
    static void main() {
        ListNode head1 = new ListNode(1);
        ListNode curr = head1;
        for (int i = 2; i <= 7; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        // Create loop
        curr.next = head1.next.next;
        System.out.println("Is loop exists: " + new FastNSlowPointer().isLoopExists(head1));
        // Middle of the list
        ListNode head2 = new ListNode(1);
        ListNode curr2 = head2;
        for (int i = 2; i <= 5; i++) {
            curr2.next = new ListNode(i);
            curr2 = curr2.next;
        }
        System.out.println("Middle of the list: " + new FastNSlowPointer().middleOfList(head2));
        // Add 1 more node
        curr2.next = new ListNode(6);
        System.out.println("Middle of the list: " + new FastNSlowPointer().middleOfList(head2));
        curr2.next.next = new ListNode(7);
        System.out.println("Middle of the list: " + new FastNSlowPointer().middleOfList(head2));
    }
    private boolean isLoopExists(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
    private ListNode middleOfList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "[" + val + "]";
        }
    }
}


