class Solution {
private:
    bool solve(vector<vector<char>>& board,int i,int j,int idx,string& word,int row,int col){
        if(idx==word.length())return true;
        if(i<0 || i>=row || j<0 || j>=col || board[i][j] == '$' )return false;

        if(board[i][j]!=word[idx])return false;

        static const vector<pair<int, int>> directions = {
                    {-1,0},
             {0,-1},       {0,+1},
                    {+1,0}       
        };
        char temp = board[i][j];
        board[i][j] = '$';

        for(const auto& dir : directions){
            int nrow = i + dir.first;
            int ncol = j + dir.second;
            if(solve(board, nrow, ncol, idx+1,word, row, col)){
                return true;
            }
        }
        board[i][j] = temp;
        return false;
    }
public:

    bool exist(vector<vector<char>>& board, string word) {
        int row = board.size();
        int col = board[0].size();

        for(int i=0;i<row;i++){
           for(int j=0;j<col;j++){
            if(board[i][j]==word[0] && solve(board, i, j, 0,word, row, col))
            return true;
           }
        }
        return false;
    }
};