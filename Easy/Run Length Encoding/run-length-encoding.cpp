//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    string encode(string s) {
        // code here
        
      if (s.empty()) return ""; // Handle empty input string

    string res = "";
    int i = 0;

    while (i < s.size()) {
        char curr_char = s[i];
        int ctr = 0;
        
        while(i<s.size() && s[i]==curr_char){
            ctr++;
            i++;
        }
        res+=curr_char + to_string(ctr);
        
    }
    return res;
    }
};


//{ Driver Code Starts.

int main(){
    int t;
    scanf("%d ",&t);
    while(t--){
        
        string s;
        getline(cin,s);
        
        Solution obj;
        string res = obj.encode(s);
        
        cout<<res<<"\n";
        
    }
}

// } Driver Code Ends