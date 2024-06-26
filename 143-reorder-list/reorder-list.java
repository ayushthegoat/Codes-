/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode runner = dummy;
        ListNode temp = head;
        ListNode mid = findMid(head);
        ListNode rev = reverseNode(mid.next);
        mid.next = null;

        // while (head != null && rev != null) {
        // ListNode temp = head.next;
        // ListNode revNext = rev.next;
        // head.next = rev;
        // rev.next = temp;
        // head = temp;
        // rev = revNext;
        // }
        while (temp != null || rev != null) {
            if (temp != null) {
                runner.next = temp;
                runner = runner.next;
                temp = temp.next;
            }
            if (rev != null) {
                runner.next = rev;
                runner = runner.next;
                rev = rev.next;
            }
        }

    }

    public ListNode reverseNode(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}