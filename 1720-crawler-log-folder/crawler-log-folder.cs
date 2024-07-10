public class Solution {
    public int MinOperations(string[] logs) {
        int count = 0;
        int n = logs.Length;
        int i = 0;
        
        Stack<string> stk = new Stack<string>();
        while(i < n) {
          
            if(logs[i] == "../" && count > 0) {
                stk.Pop();
                count--;
            } else if (logs[i] != "./" && logs[i] != "../") {
                
                stk.Push(logs[i]);
                count++;
            }
            i++;
        }
    
        return count;
    }
}