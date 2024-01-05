//{ Driver Code Starts
import java.util.Scanner;
import java.lang.Math;

class Convert_To_Five {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            System.out.println(new GfG().convertfive(N));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG {
    int convertfive(int num) {
        // Your code here
        int x=num;
        int nu=0;
        while(x>0){
            int dig=x%10;
            if(dig==0)dig=5;
            nu=(nu*10)+dig;
            x=x/10;
        }
        
        x=nu;
        nu=0;
        while(x>0){
            int dig=x%10;
            nu=(nu*10)+dig;
            x=x/10;
        }
        return nu;
    }
}