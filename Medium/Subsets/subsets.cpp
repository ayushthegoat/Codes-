//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution
{
    public:
    vector<vector<int> > subsets(vector<int>& A)
    {
        //code here
        vector<vector<int>>ans;
        vector<int>temp;
        
        solve(A,ans,temp,0);
        sort(ans.begin(),ans.end());
        return ans;
    }
    void solve(vector<int>&arr,vector<vector<int>>&ans,vector<int>&temp,int index){
        if(index>arr.size()-1){
            ans.push_back(temp);
            return;
        }
        temp.push_back(arr[index]);
        solve(arr,ans,temp,index+1);
        temp.pop_back();
        solve(arr,ans,temp,index+1);
        
    }
};

//{ Driver Code Starts.

int main()
{
	int t;
	cin >> t;

	while (t--)
	{
		int n, x;
		cin >> n;

		vector<int> array;
		for (int i = 0; i < n; i++)
		{
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