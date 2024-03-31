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
    public ListNode rotateRight(ListNode head, int k) {
        
        int len = countLength(head);
        if(len == 0 || k%len ==0){
            return head;
        }
        k%=len;

        ListNode temp = head;
        ListNode breakingPoint = head;

        for(int i=0;i<k;i++){
            temp = temp.next;
        }
        while(temp.next!=null){
            temp = temp.next;
            breakingPoint = breakingPoint.next;
        }
        ListNode starter = breakingPoint.next;
        breakingPoint.next = null;
        temp.next = head;

        return starter;
    }

    public int countLength(ListNode head) {
        if (head == null)
            return 0;
        int ctr = 0;
        ListNode temp = head;
        while (temp != null) {
            ctr++;
            temp = temp.next;
        }
        return ctr;
    }
}