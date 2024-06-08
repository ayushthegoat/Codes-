class Solution {
public:
    vector<int> previous_smaller(vector<int>& heights){
        int n = heights.size();
        vector<int>res;
        stack<int>stk;

        for(int i=0;i<n;i++){

            while(!stk.empty() && heights[stk.top()] >= heights[i]){
                stk.pop();
            }
            int ele = stk.empty()?-1:stk.top();
            res.push_back(ele);
            stk.push(i);

        }
        return res;
    }
    vector<int> next_smaller(vector<int>& heights) {
        int n = heights.size();
        vector<int>res;
        stack<int>stk;

        for(int i=n-1; i>=0; i--) {
            while(!stk.empty() && heights[stk.top()] >= heights[i]) {
                stk.pop();
            }
            int ele = stk.empty()?n:stk.top();
            res.push_back(ele);
            stk.push(i);
        }
        reverse(res.begin(), res.end());
        return res;
     }

    // vector<int> previous_smaller(vector<int>& heights) {
    //     int n = heights.size();
    //     vector<int> res;
    //     stack<int> stk;

    //     for (int i = 0; i < n; i++) {
    //         while (!stk.empty() && heights[stk.top()] >= heights[i]) {
    //             stk.pop();
    //         }
    //         int ele = stk.empty() ? -1 : stk.top();
    //         res.push_back(ele);
    //         stk.push(i);
    //     }
    //     return res;
    // }

    // vector<int> next_smaller(vector<int>& heights) {
    //     int n = heights.size();
    //     vector<int> res(n); // Initialize with the size of heights
    //     stack<int> stk;

    //     for (int i = n - 1; i >= 0; i--) {
    //         while (!stk.empty() && heights[stk.top()] >= heights[i]) {
    //             stk.pop();
    //         }
    //         res[i] = stk.empty() ? n : stk.top();
    //         stk.push(i);
    //     }
    //     return res;
    // }
    int largestRectangleArea(vector<int>& heights) {
        int n = heights.size();
        vector<int> prev = previous_smaller(heights);
        vector<int> next = next_smaller(heights);

        int mx = 0;
        for (int i = 0; i < n; i++) {
            int calc = (next[i] - prev[i] - 1) * heights[i];
            mx = max(mx, calc);
        }
        return mx;
    }
};