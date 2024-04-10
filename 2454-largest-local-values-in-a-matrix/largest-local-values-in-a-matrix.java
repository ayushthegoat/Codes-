class Solution {
    public int[][] largestLocal(int[][] grid) {
         int n = grid.length;
         int[][] max = new int[n-2][n-2];

         for(int i=0; i<n-2 ;i++){
            for(int j=0; j<n-2; j++){
                max[i][j] = max(grid , i+1, j+1);
            }
         }
         return max;
    }
    public int max(int[][] maxer ,int row ,int col){
        int max = Integer.MIN_VALUE;

        for(int i=row-1; i<=row+1; i++){
            for(int j=col-1; j<=col+1; j++){
                max = Math.max(max ,maxer[i][j]);
            }
        }
        return max;
    }
}