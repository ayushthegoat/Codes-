public class Solution {
    public int MaxCount(int[] banned, int n, int maxSum) {
        HashSet<int> set = new HashSet<int>();
        foreach(var num in banned) {
            set.Add(num);
        }
        int counter = 0;
        int sum = 0;

        for(int i = 1; i <= n; i++) {
            if(!set.Contains(i) && sum + i <=maxSum) {
                sum += i;
                counter++;
            }
        }

        return counter;
    }
}
//1 6 5
