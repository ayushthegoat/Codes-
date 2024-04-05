class Solution {
    public boolean isHappy(int n) {
        int num = n;

        while(num!=1 && num!=4){
             num = solve(num);


        }
        return num==1;   

    }
    public int solve(int n){
        int number = n;
        int result = 0;
        while(number>0){
            result += Math.pow(number%10,2);
            number /= 10;
        }
        return result;
    }
}