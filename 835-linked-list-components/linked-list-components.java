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
    public int numComponents(ListNode head, int[] nums) {
        if (head == null || nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int components=0;
        ListNode temp=head;
        while(temp!=null){
            if(set.contains(temp.val) && (temp.next==null || !set.contains(temp.next.val))){
                components++;
            }
            temp=temp.next;
        }
        
        return components;
    }
}