public class Solution {
    public string ReverseParentheses(string s) {
        Stack<int> stk = new Stack<int>();
        int n = s.Length;
        char[] arr = s.ToCharArray();
        for(int i=0; i<n; i++) {
            if(arr[i] == '(') {
                stk.Push(i);
            } else if(arr[i] == ')') {
                int start = stk.Peek() + 1;
                int end = i;
                Array.Reverse(arr, stk.Peek(), end - start+1);
                stk.Pop();
            }
        }
        string ans = "";
        for(int i=0; i<n; i++) {
            if(arr[i]!='(' && arr[i]!=')') {
                ans += arr[i];
            }
        }

        return ans;

    }
}