public class Solution {
    public string[] SortPeople(string[] names, int[] heights) {

        PriorityQueue<string, int> q = new PriorityQueue<string, int>();

        for(int i=0; i<names.Length; i++) {
            q.Enqueue(names[i], heights[i]);
        }
        string[] ans = new string[names.Length];
        int ctr = 0;
        while(q.Count > 0) {
            string name = q.Dequeue();
            ans[ctr] = name;
            ctr++;
        }
        Array.Reverse(ans);
        return ans;
    }
}