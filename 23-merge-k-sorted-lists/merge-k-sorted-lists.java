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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==1)return lists[0];
        if(lists.length==0)return null;

        ListNode res = lists[0];
          for(int i=1; i<lists.length; i++){
               ListNode newList = mergeTwoLists(res ,lists[i]);
               res = newList;
          }
          return res;

    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
         ListNode temp1 = list1;
         ListNode temp2 = list2;

        if(temp1 == null && temp2!=null)return temp2;
        if(temp2 == null && temp1!=null)return temp1;
         
         ListNode starter = new ListNode(0);
         ListNode runner = starter;
         while(temp1!=null && temp2!=null){
             if(temp1.val < temp2.val){
                runner.next = temp1;
                temp1 = temp1.next;
             }else{
                runner.next = temp2;
                temp2 = temp2.next;
             }
                runner=runner.next;
         }
         if(temp1!=null)runner.next = temp1;
         if(temp2!=null)runner.next = temp2;

         return starter.next;
    }
}