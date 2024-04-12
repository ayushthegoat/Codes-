class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int[] hash = new int[grid.length * grid.length + 1] ;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                hash[grid[i][j]]++;
            }
        }
        
        return solve(hash);

    }

    public int[] solve(int[] arr) {
        int miss = 0;
        int repeat = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>1 && i!=0){
                repeat = i;

            }
            if(arr[i]==0 && i!=0){
                miss = i;
            }
        }
        return new int[]{repeat , miss};        
    }
}