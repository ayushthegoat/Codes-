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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp=head;
        int k=right-left+1;
        int ctr=0;
        ListNode dummy=new ListNode(0);
        ListNode runner=dummy;
        while(temp!=null && ctr<left-1){
                
                runner.next=temp;
                runner=runner.next;
                temp=temp.next;
                ctr++;
        }
        ListNode prev=null;
        ListNode curr=temp;
        ListNode next=null;
        while(curr!=null && k-->0){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        runner.next=prev;
        while(prev!=null){
            runner.next=prev;
            runner=runner.next;
            prev=prev.next;
        }
        runner.next=next;


        return dummy.next;
    }
   

}