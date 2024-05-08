class Solution {
    public String[] findRelativeRanks(int[] arr){
 int n = arr.length;
        
        TreeMap<Integer, Integer> scoreMap = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            scoreMap.put(arr[i], i);
        }
        
        String[] result = new String[n];
        int rank = 1;
        
        for (Map.Entry<Integer, Integer> entry : scoreMap.entrySet()) {
            int index = entry.getValue();
            if (rank == 1) {
                result[index] = "Gold Medal";
            } else if (rank == 2) {
                result[index] = "Silver Medal";
            } else if (rank == 3) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(rank);
            }
            rank++;
        }
        
        return result;
    }
}