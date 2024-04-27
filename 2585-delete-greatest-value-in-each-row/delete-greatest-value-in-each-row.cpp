class Solution {
public:
    int deleteGreatestValue(vector<vector<int>>& grid) {
        int row = grid.size();
        int col = grid[0].size();

    
        for(int i=0;i<grid.size();i++){
            sort(grid[i].begin() , grid[i].end());
        }

        int sum = 0;
        for(int i=0;i<col;i++){
            int mx = 0;
            for(int j=0;j<row;j++){
                mx = max(mx,grid[j][i]);
            }
            sum+=mx;
        }
        return sum;
    }
};