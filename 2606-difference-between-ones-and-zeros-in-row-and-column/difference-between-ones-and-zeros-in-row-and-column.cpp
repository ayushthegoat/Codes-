class Solution {
public:
    vector<vector<int>> onesMinusZeros(vector<vector<int>>& grid) {
        int row = grid.size();
        int col = grid[0].size();

        vector<int> rowOne (row);
        vector<int> rowZero (row);
        vector<int> colOne (col);
        vector<int> colZero (col);

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 0){
                    rowOne[i]++;
                    colOne[j]++;
                }else{
                    colZero[j]++;
                    rowZero[i]++;
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                grid[i][j] = rowOne[i]  + colOne[j] - rowZero[i] - colZero[j];
                if(grid[i][j]!=0){
                    grid[i][j] = grid[i][j]*-1;
                }
            }
        }
        return grid;
    }
};