class Solution {
    public int matrixSum(int[][] nums) {
        int row = nums.length;
        int col = nums[0].length;
        int total = 0;

        for (int[] arr : nums) {
            Arrays.sort(arr);
        }

        for (int i = 0; i < col; i++) {
            int mx = 0;
            for (int j = 0; j < row; j++) {
                mx = Math.max(mx, nums[j][i]);
            }
            // cout<<mx<<endl;
            total += mx;
        }
        return total;
    }
}