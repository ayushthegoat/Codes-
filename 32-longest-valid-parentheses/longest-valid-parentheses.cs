public class Solution {
    public int LongestValidParentheses(string s) {
        Stack<int> stk = new();
        stk.Push(-1);
        int max = 0;

        for(int i = 0; i < s.Length; i++) {
            if(s[i]== '(') {
                stk.Push(i);
            } else {
                stk.Pop();
                if(stk.Count == 0) {
                    stk.Push(i);
                } else {
                    max = Math.Max(max, i - stk.Peek());
                }
            }
        }

        return max;
    }
}