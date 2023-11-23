//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args)throws IOException
	{

// 		Scanner in = new Scanner(System.in);
        
// 		int t = in.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
         //testcases
        int t = Integer.parseInt(read.readLine());
		
		while(t-- >0)
		{
		    //size of array
		    int n = Integer.parseInt(read.readLine());
		    long[] arr= new long[n];
		    
		    String str[] = read.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0;i<n;i++)
		        arr[i] = Long.parseLong(str[i]);
		    
		    // StringBuffer sb = new StringBuffer();
		    
		    Solution ob = new Solution();
		    
		    //calling rearrange() function
		    ob.rearrange(arr, n);
		    StringBuffer sb = new StringBuffer();
		    
		    //appending and printing the elements
		    for(int i =0; i < n; i++)
		     sb.append(arr[i] + " ");
		    System.out.println(sb);
		}
	}
}




// } Driver Code Ends


class Solution{
    
    // temp: input array
    // n: size of array
    //Function to rearrange  the array elements alternately.
    public static void rearrange(long arr[], int n){
        // int low=0;
        // int high=n-1;
        long[] aux=new long[n];
       
        
     int normidx = 0;
   
    //  while (low < high && low < n) {  // Fixed the syntax error here
    //     aux[normidx++] = arr[high];
       
    //     aux[normidx++] = arr[low];
    //     low++;
    //      high--;
    // }
    
    
    
    int low=0;
    int high=n-1;
     ArrayList<Long> list=new ArrayList<Long>();
     while(low<high)
     {
         list.add(arr[high]);
         list.add(arr[low]);
         low++;
         high--;
         
     }
     if(low==high){
         list.add(arr[low]);
     }
     for(int i=0;i<n;i++){
         arr[i]=list.get(i);
     }
 
}
}


