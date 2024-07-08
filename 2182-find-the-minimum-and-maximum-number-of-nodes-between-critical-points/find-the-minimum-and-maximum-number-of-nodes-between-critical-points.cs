/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public int[] NodesBetweenCriticalPoints(ListNode head) {
         int[] result = new int[2] { -1, -1 };
    if (head == null || head.next == null || head.next.next == null) {
        return result;
    }

    int minDistance = int.MaxValue;
    int firstCritical = -1;
    int lastCritical = -1;
    int index = 1;
    ListNode prev = head;
    ListNode curr = head.next;
    ListNode next = head.next.next;

    while (next != null) {
        if ((curr.val > prev.val && curr.val > next.val) || (curr.val < prev.val && curr.val < next.val)) {
            if (firstCritical == -1) {
                firstCritical = index;
            } else {
                minDistance = Math.Min(minDistance, index - lastCritical);
            }
            lastCritical = index;
        }
        prev = curr;
        curr = next;
        next = next.next;
        index++;
    }

    if (firstCritical != -1 && firstCritical != lastCritical) {
        result[0] = minDistance;
        result[1] = lastCritical - firstCritical;
    }

    return result;
    }
}