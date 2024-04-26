class Solution {
public:
    string makeGood(string s) {
        stack<char> stk;
        for (int i=0;i<s.size();i++) {
           if(stk.empty()){
            stk.push(s[i]);
           }else if(!stk.empty() && abs(stk.top()-s[i])==32){
            stk.pop();
           }else{
           stk.push(s[i]);
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