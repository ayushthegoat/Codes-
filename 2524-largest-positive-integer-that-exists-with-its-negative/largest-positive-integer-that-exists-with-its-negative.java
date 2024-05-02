class Solution {
    public int findMaxK(int[] nums) {
         Map<Integer, Integer> map = new HashMap<>();
        int mx = 0;

        for (int num : nums) {
            if (num > 0 && map.containsKey(num * -1)) {
                map.put(num*-1,num);
                mx = Math.max(mx, num);
            } else if (num < 0 && map.containsKey(Math.abs(num))) {
                map.put(num,num*-1);
                mx = Math.max(mx, Math.abs(num));
            }
            map.put(num, 0);
        }

        return mx == 0 ? -1 : mx;
    }
}