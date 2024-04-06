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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] arr = new int[m][n];
        ListNode temp = head;

        for (int[] a : arr) {
            Arrays.fill(a, -1);
        }
        int rowBeg = 0;
        int rowEnd = arr.length - 1;
        int colBeg = 0;
        int colEnd = arr[0].length - 1;

        while (rowBeg <= rowEnd && colBeg <= colEnd) {

            for (int i = colBeg; i <= colEnd; i++) {
                arr[rowBeg][i] = temp != null ? temp.val : -1;
                if (temp != null)
                    temp = temp.next;
            }
            rowBeg++;

            for (int i = rowBeg; i <= rowEnd; i++) {
                arr[i][colEnd] = temp != null ? temp.val : -1;
                if (temp != null)
                    temp = temp.next;
            }
            colEnd--;

            if (rowBeg <= rowEnd)
                for (int i = colEnd; i >= colBeg; i--) {
                    arr[rowEnd][i] = temp != null ? temp.val : -1;
                    if (temp != null)
                        temp = temp.next;
                }
            rowEnd--;

            if (colBeg <= colEnd) {
                for (int i = rowEnd; i >= rowBeg; i--) {
                    arr[i][colBeg] = temp != null ? temp.val : -1;
                    if (temp != null)
                        temp = temp.next;
                }
            }
            colBeg++;
        }
        return arr;

    }
}