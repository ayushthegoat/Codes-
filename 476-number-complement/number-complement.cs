public class Solution {
    public int FindComplement(int num) {
      
        int setBits = (int)Math.Log(num, 2) + 1;

        int mask = (1 << setBits) - 1;

        return num ^ mask;
    }
}