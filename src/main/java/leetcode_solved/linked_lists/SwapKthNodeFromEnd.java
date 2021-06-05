package leetcode_solved.linked_lists;

public class SwapKthNodeFromEnd {

    public ListNode newHeadAfterSwapKthNodeFromEndWithHead(ListNode head, int k) {
        ListNode prev = new ListNode(0, head);
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next; count ++;
        }
        while (curr != null) {
            curr = curr.next;
            prev = prev.next;
        }

        // head, k-1th, kth, k+1th
        ListNode kth = prev.next;
        ListNode kPlusOne = kth.next;

        kth.next = head.next;
        head.next = kPlusOne;
        prev.next = head;
        head = kth;

        return head;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

}
