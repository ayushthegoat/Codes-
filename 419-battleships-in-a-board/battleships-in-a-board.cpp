class Solution {
public:
    vector<pair<int, int>> directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    void dfs(vector<vector<char>>& mat, int i, int j, int row, int col) {
        mat[i][j] = '.';

        for (const auto& dir : directions) {
            int nrow = i + dir.first;
            int ncol = j + dir.second;

            if (nrow >= 0 && nrow < row && ncol >= 0 && ncol < col &&
                mat[nrow][ncol] == 'X') {
                dfs(mat, nrow, ncol, row, col);
            }
        }
    }
    int countBattleships(vector<vector<char>>& board) {

        int n = board.size();
        int m = board[0].size();

        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X') {
                    counter++;
                    dfs(board, i, j, n, m);
                }
            }
        }
        return counter;
    }
};