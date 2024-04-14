class Solution {
public:
    vector<vector<int>> transpose(vector<vector<int>>& matrix) {
      
        int row = matrix.size();
        int col = matrix[0].size();
        vector<vector<int>> res (col , vector<int>(row));

        for (int i=0;i<matrix.size();i++) {
            for (int j=0;j<matrix[0].size();j++) {
                res[j][i]=matrix[i][j];
            }
        }

        return res;
    }
};