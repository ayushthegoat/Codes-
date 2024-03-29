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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       
        if(head == null || head.next == null) {
        return null;
    }

    if(head.next == null && n == 1) {
        return null;
    }
        ListNode temp=head;
        int len=0;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        ListNode follower=null;
        temp=head;
        int pointCut = len-n;
        
    if (pointCut == 0) {
        return head.next;
    }
        while(pointCut-->0){
            follower=temp;
            temp=temp.next;
        }
       
        follower.next = temp.next;
        
        return head;
  
     }

   

    // ListNode temp = head;
    // int len = 0;
    // while(temp != null) {
    //     len++;
    //     temp = temp.next;
    // }

    // int pointCut = len - n;
    // if (pointCut == 0) {
    //     return head.next;
    // }

    // ListNode follower = null;
    // temp = head;
    // while(pointCut-- > 0) {
    //     follower = temp;
    //     temp = temp.next;
    // }

    // follower.next = temp.next;

    // return head;
    
    
}