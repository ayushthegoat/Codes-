class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];

     
        int num = 1;

        int left = 0;
        int right = arr.length - 1;
        int up = 0;
        int down = arr[0].length - 1;
        

        while (left <= right && up <= down) {
            for (int i = up; i <= down; i++) {
                arr[left][i] = num++;
            }
            left++;

            for (int i = left; i <= right; i++) {
                arr[i][down] = num++;
            }
            down--;

            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    arr[right][i] = num++;
                }
                right--;
            }

            if (up <= down) {
                for (int i = right; i >= left; i--) {
                    arr[i][up] = num++;
                }
                up++;
            }
        }
        return arr;
    }
}