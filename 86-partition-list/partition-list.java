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
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode moreHead = new ListNode(0);
        ListNode less = lessHead;
        ListNode more = moreHead;

        ListNode temp = head;
        while(temp!=null){
            if(temp.val<x){
                less.next = temp;
                less = less.next;
                
            }else {
                more.next = temp;
                more = more.next;
            }
            temp = temp.next;
        }
        less.next = moreHead.next;
        more.next = null;
        return lessHead.next;
    }
}