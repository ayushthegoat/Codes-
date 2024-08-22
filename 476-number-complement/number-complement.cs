public class Solution {
    public int FindComplement(int num) {
      
        int setBits = (int)Math.Log(num, 2) + 1;

        for(int i = 0; i < setBits; i++) {
            num = num ^ (1 << i);
        }

        return num;
    }
}