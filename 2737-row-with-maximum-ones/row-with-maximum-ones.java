class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int ctr = 0;
        int index = 0;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<mat.length;i++){
            ctr = 0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1)ctr++;
            }
            if(ctr>max){
                max = ctr;
                index = i;
            }
 
       }
       return new int[]{index , max};
    }
}