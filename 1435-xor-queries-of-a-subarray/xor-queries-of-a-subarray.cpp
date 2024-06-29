class Solution {
public:
    vector<int> xorQueries(vector<int>& arr, vector<vector<int>>& queries) {
        ios::sync_with_stdio(0);
        cin.tie(0);
        cout.tie(0);

        int n = arr.size();

        vector<int> xo(n);

        xo[0] = arr[0];
        for (int i = 1; i < arr.size(); i++) {
            xo[i] = arr[i] ^ xo[i - 1];
        }

        vector<int> res(queries.size());

        for (int i = 0; i < queries.size(); ++i) {
            int left = queries[i][0];
            int right = queries[i][1];

            if (left == 0) {
                res[i] = xo[right];
            } else {
                res[i] = xo[right] ^ xo[left - 1];
            }
        }

        return res;
    }
};