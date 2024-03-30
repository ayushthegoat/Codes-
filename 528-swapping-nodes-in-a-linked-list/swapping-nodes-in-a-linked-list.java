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
    public ListNode swapNodes(ListNode head, int k) {
        if(head ==null )return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode starter = dummy;
    
        for(int i=0;i<k;i++){
            starter = starter.next;
        }

        ListNode ender = (reverseList(head));
        ListNode ans = ender;

        for(int i=0;i<k-1;i++){
            ender = ender.next;
        }

        int temp = starter.val;
        starter.val = ender.val;
        ender.val = temp;

        reverseList(ans);

        return dummy.next;
    }
    public ListNode reverseList(ListNode head){
        if(head==null)return head;
        ListNode curr = head;
        ListNode prev = null;

        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}