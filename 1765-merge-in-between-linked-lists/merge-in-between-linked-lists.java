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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(0);
        dummy.next = list1;
        ListNode runner1 = dummy;
        ListNode runner2 = dummy;

        for(int i=0; i<a; i++){
             runner1 = runner1.next;
        }
        runner2 = runner1;
        for(int i=a; i<=b; i++){
             runner2 = runner2.next;
        }
        ListNode temp = list2;
        while(temp.next!=null){
            temp=temp.next;
        }
        runner1.next = list2;
        temp.next = runner2.next;
        return dummy.next;
    }
}