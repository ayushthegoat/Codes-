class Solution {
public:
    vector<vector<int>> constructProductMatrix(vector<vector<int>>& grid) {
        int row = grid.size();
        int col = grid[0].size();
        int mod = 12345;

        long long product = 1;
     
         vector<vector<int>> hash1(row, vector<int>(col));
        vector<vector<int>> hash2(row, vector<int>(col));

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                hash1[i][j] = product;
                product = product * grid[i][j];
                product = product % mod;
            }
        }
        product = 1;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                hash2[i][j] = product;
                product = product * grid[i][j];
                product = product % mod;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                long long mul = (hash1[i][j] * hash2[i][j]);
                grid[i][j] = mul%mod;
            }
        }
        return grid;
    }
};