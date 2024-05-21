//{ Driver Code Starts
#include<bits/stdc++.h>

using namespace std;


// } Driver Code Ends
class Solution{

    // Function to find the trapped water between the blocks.
    public:
    long long trappingWater(int arr[], int n){
        // code here
        
        vector<int>left(n,0);
        vector<int>right(n,0);
        
        int lmx = 0;
        int rmx = 0;
        for(int i=0;i<n;i++){
            lmx = max(lmx, arr[i]);
            left[i] = lmx;
            
            rmx = max(rmx, arr[n-i-1]);
            right[n-i-1] = rmx;
        }
        long long res = 0;
        for(int i=0;i<n;i++){
            res+= min(left[i] , right[i]) - arr[i];
        }
        return res;
    }
};

//{ Driver Code Starts.

int main(){
    
    int t;
    //testcases
    cin >> t;
    
    while(t--){
        int n;
        
        //size of array
        cin >> n;
        
        int a[n];
        
        //adding elements to the array
        for(int i =0;i<n;i++){
            cin >> a[i];            
        }
        Solution obj;
        //calling trappingWater() function
        cout << obj.trappingWater(a, n) << endl;
        
    }
    
    return 0;
}
// } Driver Code Ends