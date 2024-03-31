/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = findLength(headA);
        int len2 = findLength(headB);
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        if(len1>len2){
            int k=len1 - len2;
            while(k-->0){
                temp1=temp1.next;
            }

        }else{
            int k=len2 - len1;
            while(k-->0){
                temp2=temp2.next;
            }
        }
        while(temp1!=null && temp2!=null){
            if(temp1==temp2)return temp1;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return null;
    }
    
    public int findLength(ListNode head){
        if(head == null)return 0;

        ListNode temp = head;
        int ctr=0;
        while(temp!=null){
            ctr++;
            temp = temp.next;
        }
        return ctr;
    }
}