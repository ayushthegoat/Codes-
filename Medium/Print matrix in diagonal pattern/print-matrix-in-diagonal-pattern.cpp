//{ Driver Code Starts

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
/*You are required to complete this method */

class Solution{
  public:
    vector<int> matrixDiagonally(vector<vector<int>>&mat)
    {
         //Your code here
         int row = mat.size();
         int col = mat[0].size();
         
         map<int,vector<int>> map;
         
         for(int i=0;i<row;i++){
             for(int j=0;j<col;j++){
                 map[i+j].push_back(mat[i][j]);
             }
         }
         
         vector<int> res;
        
         bool flipper = true;
         for(auto& it : map){
             if(flipper){
                 reverse(it.second.begin(),it.second.end());
             }
             for(int num : it.second){
                 res.push_back(num);
             }
             flipper = !flipper;
         }
         
         
         return res;
    }
};


//{ Driver Code Starts.
int main()
{
    int T;
    cin>>T;
  
    while(T--)
    {
        int n;
        int k=0;
        //cin>>k;
        cin>>n;
        vector<vector<int>>mat(n, vector<int>(n));
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                cin >> mat[i][j];
            }
        }
        Solution obj;
        vector<int>ans = obj.matrixDiagonally(mat);
        for(auto i: ans)cout << i << " ";
        cout << "\n";
        
       
    }
}
// } Driver Code Ends