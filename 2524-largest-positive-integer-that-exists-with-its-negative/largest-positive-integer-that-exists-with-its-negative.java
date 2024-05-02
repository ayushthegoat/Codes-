class Solution {
    public int findMaxK(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int mx = Integer.MIN_VALUE;

        for (int num : nums) {
            if (map.containsKey(-num)) {
                mx = Math.max(mx, Math.abs(num));
            }
            map.put(num, 1);
        }

        return mx == Integer.MIN_VALUE ? -1 : mx;
    }
}