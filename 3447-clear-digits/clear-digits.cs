using System;
using System.Collections.Generic;
using System.Text;

public class Solution {
    public string ClearDigits(string s) {
        var stk = new Stack<char>();
        bool isTopNum = false;

        for (int i = s.Length - 1; i >= 0; i--) {
            char curr = s[i];

            if (stk.Count == 0) {
                stk.Push(curr);
            } else {
                char currTop = stk.Peek();
                isTopNum = char.IsDigit(currTop);
                if(!isTopNum && char.IsLetter(curr)) {
                    stk.Push(curr);
                }
                if (isTopNum && char.IsDigit(curr)) {
                    stk.Push(curr);
                } else if (isTopNum && !char.IsDigit(curr)) {
                    stk.Pop();
                    if (stk.Count > 0) {  
                        isTopNum = char.IsDigit(stk.Peek());
                    } else {
                        isTopNum = false;
                    }
                } else if (!isTopNum && char.IsDigit(curr)) {
                    stk.Push(curr);
                }
            }
        }

        var result = new StringBuilder();
        while (stk.Count > 0) {
            result.Append(stk.Pop());
        }
        return result.ToString();
    }
}
