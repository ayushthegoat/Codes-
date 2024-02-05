//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
 Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }          
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<Integer> factorial(int N){
        
    ArrayList<Integer>list=new ArrayList<>();
        list.add(1);
        for(int i=2;i<=N;i++){
            multiply(list,i);
        }
        Collections.reverse(list);
        return list;
    
        
    }
    static void multiply(ArrayList<Integer>a,int n){
        int carry=0;
        for(int i=0;i<a.size();i++){
            int product=a.get(i)*n+carry;
            a.set(i,product%10);
            carry=product/10;
        }
        while(carry!=0){
            a.add(carry%10);
            carry=carry/10;
        }
    }
}