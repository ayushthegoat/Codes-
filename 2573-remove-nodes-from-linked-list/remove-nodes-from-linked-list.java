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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stk = new Stack<>();

        ListNode temp = head;
        while(temp!=null){
          
             while(!stk.isEmpty() && temp.val > stk.peek().val){
                stk.pop();
             }
             stk.push(temp);
             temp=temp.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;
        while(!stk.isEmpty()){
            ListNode curr= stk.pop();
            runner.next = curr;
            runner = runner.next;
        }
        runner.next = null;
         
        return reverse(dummy.next);
    }
    public ListNode reverse(ListNode node){
        if(node==null)return node;

        ListNode curr=node;
        ListNode prev=null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}