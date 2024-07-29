public class Solution {
    public int NumTeams(int[] rating) {
        int n = rating.Length;
        int count = 0;

        // Loop through each possible triplet in the array
        for (int i = 0; i < n; i++) {
            int leftLarger = 0, rightLarger = 0;
            int leftSmaller = 0, rightSmaller = 0;

           
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) leftLarger++;
                if (rating[j] > rating[i]) leftSmaller++;
            }

          
            for (int k = i + 1; k < n; k++) {
                if (rating[k] > rating[i]) rightLarger++;
                if (rating[k] < rating[i]) rightSmaller++;
            }

           
            count += leftLarger * rightLarger;
            count += leftSmaller * rightSmaller;
        }

        return count;
    }
}
