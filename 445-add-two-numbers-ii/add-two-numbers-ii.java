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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = reverseNode(l1);
        ListNode temp2 = reverseNode(l2);

        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;

        int carry = 0;
        
        while(temp1!=null || temp2!=null){
            int sum = carry;
            if(temp1!=null){
                sum+= temp1.val;
                temp1 = temp1.next;
            }

            if(temp2!=null){
                sum+=temp2.val;
                temp2=temp2.next;
            }

            runner.next = new ListNode(sum%10);
            carry = sum/10;
            runner = runner.next;
        }
        if(carry>0){
            runner.next = new ListNode(carry);
            runner = runner.next;
        }

        runner.next = null;
        ListNode result = reverseNode(dummy.next);
        return result;

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
}