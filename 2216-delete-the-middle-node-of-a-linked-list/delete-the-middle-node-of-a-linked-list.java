/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
      if(head==null)return null;
      if(head.next==null)return null;
       if (head.next.next == null) {
        
        head.next=null;
        return head;
    }
        ListNode fast=head;
        ListNode slow=head;
        ListNode slowFollower=null;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slowFollower=slow;
            slow=slow.next;
            
        }
        slowFollower.next=slow.next;
        return head;
        
    }
}