//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
        // Your Code Here
        int[] aux=new int[a.length+b.length];
        int i=0;
        int j=0;
        int index=0;
        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                aux[index++]=a[i];
                i++;
            }else{ 
                aux[index++]=b[j];
                j++;
            }
        }
        while(i<a.length){
            aux[index++]=a[i];
            i++;
        }
        while(j<b.length){
            aux[index++]=b[j];
            j++;
        }
    
        
        if(aux.length%2==0){
            int middle1 = aux[aux.length / 2 - 1];
            int middle2 = aux[aux.length / 2];
            return (double) (middle1 + middle2) / 2.0;
        }
        return aux[(aux.length/2)];
        
        
    }
}