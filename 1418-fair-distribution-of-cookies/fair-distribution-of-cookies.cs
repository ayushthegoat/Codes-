public class Solution {
   private int result = int.MaxValue;
    private int n;

    private void Solve(int idx, int[] cookies, int[] children, int k) {
        if (idx == cookies.Length) {
            int ans = children.Max();
            result = Math.Min(result, ans);
            return;
        }

        int candy = cookies[idx];
        for (int i = 0; i < k; i++) {
            children[i] += candy;

            Solve(idx + 1, cookies, children, k);

            children[i] -= candy;
        }
    }

    public int DistributeCookies(int[] cookies, int k) {
        n = cookies.Length;
        int[] children = new int[k];
        Solve(0, cookies, children, k);

        return result;
    }
}