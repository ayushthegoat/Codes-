class Solution {
public:
    string makeGood(string s) {
        stack<char> stk;
        for (char ch : s) {
            if (!stk.empty() && abs(stk.top() - ch) == 32) {
                stk.pop(); // Remove the previous character
            } else {
                stk.push(ch); // Add the current character
            }
        }
        string st = "";
        while (!stk.empty()) {
            st += stk.top();
            stk.pop();
        }
        reverse(st.begin(), st.end());
        return st;
    }
};