class Solution {
    int ctr = 0;

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] hash = new int[mat.length];
        int idx = 0;

        for (int[] arr : mat) {
            hash[idx++] = countOne(arr);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]); 
            } else {
                return Integer.compare(a[0], b[0]); 
            }
        });
        for (int i = 0; i < mat.length; i++) {
            q.offer(new int[] { i, hash[i] });
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = q.poll()[0];
        }

        return result;

    }

    public int countOne(int[] arr) {
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                c++;
            }
        }
        return c;
    }
}