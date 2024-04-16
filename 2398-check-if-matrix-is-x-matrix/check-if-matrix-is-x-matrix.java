class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][i]==0 || grid[i][row-1-i]==0){
                       return false;
                }
                grid[i][i] = Integer.MIN_VALUE;
                grid[i][row-1-i] = Integer.MIN_VALUE;
                
            }

        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]!=Integer.MIN_VALUE && grid[i][j]!=0){
                    return false;

            }
        }
        }
        return true;
    }
}