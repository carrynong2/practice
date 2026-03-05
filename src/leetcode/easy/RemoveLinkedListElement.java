package leetcode.easy;

public class RemoveLinkedListElement {
    static void main() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        int val = 6;
        ListNode res = removeElements(head, val);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head.next != null) {
            if (head.val == val) {
                dummy.next = head.next;
            } else {
                dummy = dummy.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
