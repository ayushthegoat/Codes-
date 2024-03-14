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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode node=new ListNode(0);
        Map<Integer,ListNode>map=new HashMap<>();
        node.next=head;
        int sum=0;
        for(ListNode temp=node;temp!=null;temp=temp.next){
            sum=sum+temp.val;
            map.put(sum,temp);
        }
        sum=0;
        for(ListNode temp=node;temp!=null;temp=temp.next){
            sum=sum+temp.val;
            temp.next=map.get(sum).next;
        }
        return node.next;

    }
}