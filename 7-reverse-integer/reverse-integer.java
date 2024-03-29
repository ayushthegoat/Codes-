class Solution {
    public int reverse(int x) {
       int ini=x;
       int rev=0;
       x=Math.abs(x);
       while(x>0){
         int rem=x%10;
         
         if(rev > Integer.MAX_VALUE/10 || (rev==Integer.MAX_VALUE/10 && rem>7)){
            return 0;
         }
         if(rev < Integer.MIN_VALUE/10 || (rev==Integer.MIN_VALUE/10 && rem<-8)){
            return 0;
         }
         rev=(rev*10+rem);
         x/=10;
       }
        if(ini<0)return (-1)*(rev);
        return rev;
    }
}