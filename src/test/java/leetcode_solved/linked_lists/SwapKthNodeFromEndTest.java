package leetcode_solved.linked_lists;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwapKthNodeFromEndTest {

    SwapKthNodeFromEnd code = new SwapKthNodeFromEnd();

    @Test
    public void test() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        one.next = two; two.next = three; three.next = four; four.next = five; five.next = six;
        code.printList(one);
        System.out.println();
        one = code.newHeadAfterSwapKthNodeFromEndWithHead(one, 3);
        code.printList(one);
    }

}