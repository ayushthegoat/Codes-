public class Solution {
    public double AverageWaitingTime(int[][] customers) {
        double ans = 0;
        int chef = 0;

        for(int i=0; i<customers.Length; i++) {
            int come = customers[i][0];
            int end = customers[i][1];

            if(come > chef) {
                chef = come + end;
                ans += chef - come;
            } else {
                chef = chef + end;
                ans += chef - come;
            }
        }
        return ans/customers.Length;
    }
}