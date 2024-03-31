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
    public int[] nextLargerNodes(ListNode head) {
         ListNode starter = reverseList(head);
        Stack<ListNode> stk = new Stack();
        ArrayList<Integer> list = new ArrayList();
    
        ListNode temp = starter;
    
        while(temp!=null){
           
            while(!stk.isEmpty() && temp.val>=stk.peek().val){
                 stk.pop();
            }
            if(!stk.isEmpty()){
                list.add(stk.peek().val);
            }else {
                list.add(0);
            }
            stk.push(temp);
            temp = temp.next;
        }
        Collections.reverse(list);
        Integer[] arr = list.toArray(new Integer[0]);
        int[] result = new int[arr.length];
        for(int i=0;i<list.size();i++){
            result[i]=arr[i];
        }
       return result;
    } 

    public ListNode reverseList(ListNode head){
        if(head==null)return head;

        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    
    }
}