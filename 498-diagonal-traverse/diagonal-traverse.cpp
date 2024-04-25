class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& mat) {
        int row = mat.size();
        int col = mat[0].size();

        map<int, vector<int>> map;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i + j].push_back(mat[i][j]);
            }
        }

        vector<int> res;

        bool flipper = true;
        for (auto& it : map) {
            if (flipper) {
                reverse(it.second.begin(), it.second.end());
            }
            for (int num : it.second) {
                res.push_back(num);
            }
            flipper = !flipper;
        }

        return res;
    }
};