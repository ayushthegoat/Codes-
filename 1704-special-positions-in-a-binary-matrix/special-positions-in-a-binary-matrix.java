class Solution {
    public int numSpecial(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int res=0;

        boolean[] rowZero = new boolean[mat.length];
     //   Arrays.fill(rowZero,false);
        boolean[] colZero = new boolean [mat[0].length];
       // Arrays.fill(colZero,false);

        for(int i=0;i<row;i++){
            int count = 0;
            for(int j=0;j<col;j++){
                if(mat[i][j]==1){
                    count++;
                }
            }
            if(count==1){
            rowZero[i] = true;
            }
        }
        for(int i=0;i<col;i++){
            int count = 0;
            for(int j=0;j<row;j++){
                if(mat[j][i]==1){
                    count++;
                }
            }
            if(count==1){
                colZero[i] = true;
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==1 && rowZero[i]==true && colZero[j]==true){
                    res++;
                }
            }
        }    
        return res;
    }
    
}