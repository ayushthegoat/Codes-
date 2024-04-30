//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution
{
    public:
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    int maxMeetings(int start[], int end[], int n)
    {
        // Your code here
    //     vector<pair<int,int>>vec;
    //     for(int i=0;i<n;i++){
    //         vec.push_back({end[i],start[i]});
    //     }
    //     sort(vec.begin(),vec.end());
    //     int ans = vec[0].first;
    //   //  cout<<ans<<endl;
    //     int count = 1;
    //     for(int i=1;i<n;i++){
    //         if(vec[i].second>ans){
    //             count+=1;
    //         }
    //     }
    //     return count;
      vector<pair<int,int>>temp;
        for(int i=0;i<n;i++)    temp.push_back({end[i],start[i]});
        sort(temp.begin(),temp.end());
        int aend=temp[0].first;
        int ans=1;
        for(int i=1;i<n;i++){
            if(temp[i].second>aend){
                aend=temp[i].first;
                ans+=1;
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
        int n;
        cin >> n;
        int start[n], end[n];
        for (int i = 0; i < n; i++) cin >> start[i];

        for (int i = 0; i < n; i++) cin >> end[i];

        Solution ob;
        int ans = ob.maxMeetings(start, end, n);
        cout << ans << endl;
    }
    return 0;
}
// } Driver Code Ends