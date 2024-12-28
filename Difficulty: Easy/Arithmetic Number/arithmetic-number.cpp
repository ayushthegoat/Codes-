//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int inSequence(int a, int b, int c) {
        // code here
        if(b < a) return 0;
        int currEle = a;
        
        while(currEle != b) {
            currEle += c;
            if(currEle > b) return 0;
        }
        
        return 1;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int A, B, C;
        cin >> A >> B >> C;

        Solution ob;
        int ans = ob.inSequence(A, B, C);
        if (ans)
            cout << "true" << endl;
        else
            cout << "false" << endl;
    }
    return 0;
}
// } Driver Code Ends