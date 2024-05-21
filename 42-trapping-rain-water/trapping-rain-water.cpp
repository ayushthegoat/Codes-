class Solution {
public:
    int trap(vector<int>& arr) {
        int n = arr.size();
        vector<int> left(n, 0);
        vector<int> right(n, 0);

        int lmx = 0;
        int rmx = 0;
        for (int i = 0; i < n; i++) {
            lmx = max(lmx, arr[i]);
            left[i] = lmx;

            rmx = max(rmx, arr[n - i - 1]);
            right[n - i - 1] = rmx;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += min(left[i], right[i]) - arr[i];
        }
        return res;
    }
};