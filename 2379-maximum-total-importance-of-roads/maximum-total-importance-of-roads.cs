public class Solution {
    public long MaximumImportance(int n, int[][] roads) {
        var degree = new List<int>(new int[n]);

        foreach(var item in roads) {
            int u = item[0];
            int v = item[1];

            degree[u]++;
            degree[v]++;
        }

        var res = degree.OrderBy(x => x).ToList();

        long value = 1;
        long sum = 0;

        for(int i = 0; i < n; i++) {
            sum += (res[i] * value);
            value++;
        }

        return sum;
    }
}