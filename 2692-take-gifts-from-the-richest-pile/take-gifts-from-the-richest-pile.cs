public class Solution {
    public long PickGifts(int[] gifts, int k) {
        
        PriorityQueue<int, int> q = new PriorityQueue<int, int>(Comparer<int>.Create((a, b) => b - a));
        foreach(int i in gifts) q.Enqueue(i, i);

       while (k > 0) {
            int curr = q.Dequeue();
            int newValue = (int)Math.Floor(Math.Sqrt(curr));
            q.Enqueue(newValue, newValue);
            k--;
        }

        long sum = 0;
        while (q.Count > 0) {
            sum += q.Dequeue();
        }

        return sum;
    }
}