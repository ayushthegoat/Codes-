//{ Driver Code Starts
// Initial template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for c++
class Solution {
  public:
    int findMaxLen(string s) {
        // code here
        int n = s.size();
        int left = 0;
        int right = 0;
        int ans = 0;
        
        for(int i=0;i<n;i++) {
            char ch = s[i];
            
            if(ch == '(') {
                left++;
            } else {
                right++;
            }
            if(left == right) {
                ans = max(ans, 2 * right);
            } else if(right > left) {
                left = 0;
                right = 0;
            }
        }
        
        left = 0;
        right = 0;
        for(int i=n-1; i>=0; i--) {
            char ch = s[i];
            
            if(ch == '(') {
                left++;
            } else {
                right++;
            }
            if(left == right) {
                ans = max(ans, 2 * left);
            } else if(left > right) {
                left = 0;
                right = 0;
            }
        }
        
        return ans;
        
        
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string S;
        cin >> S; 
        Solution ob;
        cout << ob.findMaxLen(S) << endl;
    }
    return 0;
}

// } Driver Code Ends