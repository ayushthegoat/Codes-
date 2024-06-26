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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode res = dummy;
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null){
            if(slow.val!=fast.val){
                slow.next = fast;
                slow = fast;
            }
            fast = fast.next;
        }
         slow.next = null;
         return res.next;
     }
}