//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{

	 const int MOD = 1e9 + 7;
    public:
    int counter(vector<int>& arr, int tar, int idx, vector<vector<int>>& dp) {
        if (tar == 0) {
            return 1; // Found a valid subset that sums up to tar
        }
        if (idx < 0) {
            return 0; // No more elements to consider
        }
        if (dp[idx][tar] != -1) {
            return dp[idx][tar]; // Return memoized result
        }
        
        int pick = 0;
        if (tar >= arr[idx]) {
            pick = counter(arr, tar - arr[idx], idx - 1, dp); // Include arr[idx]
        }
        int not_pick = counter(arr, tar, idx - 1, dp); // Exclude arr[idx]

        // Memoize the result
        return dp[idx][tar] = (pick + not_pick) % MOD;
    }

    int perfectSum(int arr[], int n, int tar) {
        vector<int> nums(arr, arr + n); // Convert array to vector
        
        // Sort nums (if needed)
        sort(nums.begin(), nums.end());

        // Initialize memoization table
        vector<vector<int>> dp(n, vector<int>(tar + 1, -1));
        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] != 0){
                break;
            }
            cnt++;
        }
        int mul = pow(2,cnt);
        return mul*counter(nums, tar, n - 1, dp);
    }
	  
};

//{ Driver Code Starts.
int main() 
{
   	
   
   	int t;
    cin >> t;
    while (t--)
    {
        int n, sum;

        cin >> n >> sum;

        int a[n];
        for(int i = 0; i < n; i++)
        	cin >> a[i];

       

	    Solution ob;
	    cout << ob.perfectSum(a, n, sum) << "\n";
	     
    }
    return 0;
}

// } Driver Code Ends