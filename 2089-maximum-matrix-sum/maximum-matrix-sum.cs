public class Solution {
    public long MaxMatrixSum(int[][] matrix) {
    int countNeg = 0;
    int minAbs = int.MaxValue;
    long sumAbs = 0;

    for (int i = 0; i < matrix.Length; i++) {
        for (int j = 0; j < matrix[0].Length; j++) {
            sumAbs += Math.Abs(matrix[i][j]);
            if (matrix[i][j] < 0) countNeg++;
            minAbs = Math.Min(minAbs, Math.Abs(matrix[i][j])); 
        }
    }

    if ((countNeg & 1) != 0) 
        return sumAbs - (2 * minAbs);
    else 
        return sumAbs;
    }
}