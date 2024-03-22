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
   public boolean isPalindrome(ListNode head) {
       if(head==null || head.next==null)return true;

       ListNode slow=head;
       ListNode fast=head;
       while(fast!=null && fast.next!=null){
         fast=fast.next.next;
         slow=slow.next;
       }
       ListNode rev=reverseList(slow);
           while(head!=null && rev!=null){
                if(head.val!=rev.val){
                    return false;

                }
                head=head.next;rev=rev.next;
           }
        return true;
   }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}