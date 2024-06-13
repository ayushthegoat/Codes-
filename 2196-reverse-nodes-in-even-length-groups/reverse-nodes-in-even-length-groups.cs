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
    public ListNode ReverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode temp = dummy;

        for(int group = 1; temp.next!=null; group++){
            int groupSize;

            for(groupSize = 0;groupSize<group && temp.next!=null;groupSize++) {
                temp = temp.next;
            }

            if(groupSize%2 == 0) {
                ListNode next = dummy.next;
                dummy.next = ReversedList(next, temp.next, groupSize);
                dummy = temp = next;
            }else{
                dummy = temp;
            }
        }

        return head;


    }
      public ListNode ReversedList(ListNode head, ListNode prev, int count)
    {
        for (int i = 0; head != null && i < count; i++)
        {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}