//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution
{
    public:
         void fillLPS(string &pat, vector<int> &LPS, int length) {
        int len = 0; // length of previous longest prefix and suffix
        LPS[0] = 0;  // LPS[0] is always 0
        int i = 1;

        while (i < length) {
            if (pat[i] == pat[len]) {
                len++;
                LPS[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = LPS[len - 1];
                } else {
                    LPS[i] = 0;
                    i++;
                }
            }
        }
    }

    vector<int> search(string pat, string txt) {
        int N = txt.length();
        int M = pat.length();
        int i = 0;
        int j = 0;
        vector<int> LPS(M, 0);
        vector<int> result;

        fillLPS(pat, LPS, M);

        while (i < N) {
            if (txt[i] == pat[j]) {
                i++;
                j++;
            }
            if (j == M) {
                result.push_back(i - M + 1);
                j = LPS[j - 1];
            } else if (i < N && txt[i] != pat[j]) {
                if (j != 0) {
                    j = LPS[j - 1];
                } else {
                    i++;
                }
            }
        }
        return result;
    }
     
};

//{ Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        string S, pat;
        cin >> S >> pat;
        Solution ob;
        vector <int> res = ob.search(pat, S);
        if (res.size()==0)
            cout<<-1<<endl;
        else {
            for (int i : res) cout << i << " ";
            cout << endl;
        }
    }
    return 0;
}

// Contributed By: Pranay Bansal

// } Driver Code Ends