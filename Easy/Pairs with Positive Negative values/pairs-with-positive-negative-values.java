//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            List<Long> answer = obj.PosNegPair(a, n);
            int sz = answer.size();
            
            if(sz==0)
            System.out.println(0);
            
            else{
                StringBuilder output = new StringBuilder();
                for(long x : answer)
                output.append(x+" ");
                System.out.println(output);
            }
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public List<Long> PosNegPair(long a[], long n)
    {
        List<Long>list=new ArrayList<>();
     Map<Long,Integer>map=new HashMap<>();
     for(int i=0;i<n;i++){
         map.put(a[i],map.getOrDefault(a[i],0)+1);
         
         if(map.get(a[i])>0  &&  map.getOrDefault(-a[i],0)>0){
             if(a[i]>0){
                 a[i]=-a[i];
             }
             list.add(a[i]);
             list.add(-a[i]);
             map.put(a[i],map.get(a[i])-1);
             map.put(-a[i],map.get(-a[i])-1);
         }
     }
     list.sort((o1,o2)->Long.compare(Math.abs(o1),Math.abs(o2)));
     return list;
     
    }
}