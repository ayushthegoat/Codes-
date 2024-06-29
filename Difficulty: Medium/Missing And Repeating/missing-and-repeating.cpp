//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

// } Driver Code Ends
class Solution{
public:
    vector<int> findTwoElement(vector<int> arr, int n) {
        // code here
        int i = 0;
    while (i < n) {
        // Correct index for the current number
        int correctIndex = arr[i] - 1;
        // If the current number is not in its correct position, swap it
        if (arr[i] != arr[correctIndex]) {
            std::swap(arr[i], arr[correctIndex]);
        } else {
            // Move to the next element if it's already in the correct position
            i++;
        }
    }

    // After sorting, find the missing and repeating numbers
    int repeating = -1, missing = -1;
    for (i = 0; i < n; i++) {
        if (arr[i] != i + 1) {
            repeating = arr[i];
            missing = i + 1;
            break;
        }
    }

    return {repeating, missing};
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> a(n);
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }
        Solution ob;
        auto ans = ob.findTwoElement(a, n);
        cout << ans[0] << " " << ans[1] << "\n";
    }
    return 0;
}
// } Driver Code Ends