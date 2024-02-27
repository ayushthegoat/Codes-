//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}
// } Driver Code Ends



class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        
        int aux[]=new int[n];
        Stack<Integer>stk=new Stack<>();
        aux[0]=1;
        stk.push(0);
        
        for(int i=1; i<price.length; i++){
            while(!stk.isEmpty() && price[stk.peek()] <=price[i]){
                stk.pop();
            }
            
            if(stk.isEmpty()){
                aux[i]=i+1;
            }else{
                aux[i]=i-stk.peek();
            }
            stk.push(i);
        }
        return aux;
    }
    
}