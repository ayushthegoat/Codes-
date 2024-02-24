//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function template for C++

class Solution{
public:
    string rremove(string s){
       while (true) {
        int i = 0;
        int n = s.size(); 
        string temp = "";
        while (i < n) {
            int j = i + 1;
            while (j < n && s[i] == s[j]) {
                j++;
            }
            if (j == i + 1) {
                temp += s[i];
            }
            i = j;
        }
        if (s.size() == temp.size()) break;
        s = temp;
    }
    return s;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    string tc;
    getline(cin, tc);
    t = stoi(tc);
    while (t--) {
        string s;
        getline(cin, s);
        Solution ob;
        cout << ob.rremove(s) << "\n";
    }
    return 0;
}
// } Driver Code Ends