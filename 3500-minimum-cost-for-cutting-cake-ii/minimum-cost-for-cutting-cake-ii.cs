public class Solution {
    public long MinimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        long H = 1;
        long V = 1;
        int i = 0;
        int j = 0;
    
        long ans = 0;
        Array.Sort(horizontalCut, (a, b)=> b.CompareTo(a));
        Array.Sort(verticalCut, (a, b)=> b.CompareTo(a));

        while (i < horizontalCut.Length && j < verticalCut.Length) {
        if (horizontalCut[i] >= verticalCut[j]) {
            ans += horizontalCut[i] * V;
            H++;
            i++;
        } else {
            ans += verticalCut[j] * H;
            V++;
            j++;
        }
    }
    while (i < horizontalCut.Length) {
        ans += horizontalCut[i] * V;
        H++;
        i++;
    }
    while (j < verticalCut.Length) {
        ans += verticalCut[j] * H;
        V++;
        j++;
    }
        return ans;
    }
}