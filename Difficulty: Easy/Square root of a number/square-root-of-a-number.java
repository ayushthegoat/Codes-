//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    long floorSqrt(long num) {
        // Your code here
        
        if (num == 0) {
            return 0;
        }

        int bit = 1 << ((Integer.SIZE - 1) / 2);
        int result = 0;

        while (bit > 0) {
            result |= bit;

            if (result * result > num) {
                result ^= bit;
            }

            bit >>= 1;
        }

        return result;
    }
}
