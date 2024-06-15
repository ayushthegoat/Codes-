//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    void solve(vector<vector<int>>&res,  vector<int>&temp,  vector<int>& a, int index) {
        if(index > a.size()-1) {
            res.push_back(temp);
            return;
        }
        
        temp.push_back(a[index]);
        solve(res, temp, a, index+1);
        temp.pop_back();
        solve(res, temp, a, index+1);
    }
    vector<vector<int>> subsets(vector<int>& a) {
        // code here
        vector<vector<int>>res;
        vector<int>temp;
        
        solve(res, temp, a, 0);
        sort(res.begin(), res.end());
        return res;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;

    while (t--) {
        int n, x;
        cin >> n;

        vector<int> array;
        for (int i = 0; i < n; i++) {
            cin >> x;
            array.push_back(x);
        }

        Solution ob;
        vector<vector<int> > res = ob.subsets(array);

        // Print result
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res[i].size(); j++)
                cout << res[i][j] << " ";
            cout << endl;
        }
    }

    return 0;
}
// } Driver Code Ends