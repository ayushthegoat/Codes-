class Solution {
    public void setZeroes(int[][] matrix) {
          
           boolean[] zeroRow = new boolean[matrix.length];
           boolean[] zeroCol = new boolean[matrix[0].length];

           for(int i = 0;i<matrix.length ; i++){
            for(int j=0;j<matrix[0].length ; j++){
                if(matrix[i][j] == 0){
                    zeroRow[i] = true;
                    zeroCol[j] = true; 
                }
             }
           }
           for(int i = 0;i<matrix.length ; i++){
             if(zeroRow[i]){
                for(int j=0;j<matrix[0].length ;j++){
                    matrix[i][j] = 0;
                }
             }
           }
           for(int i = 0;i<matrix[0].length ;i++){
            if(zeroCol[i]){
               for(int j=0;j<matrix.length ;j++){
                    matrix[j][i] = 0;
                }
            }
           }
    }
}