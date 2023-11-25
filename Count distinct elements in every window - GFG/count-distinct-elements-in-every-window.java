//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int arr[], int n, int k)
    {
       ArrayList<Integer>list=new ArrayList<>();
       Map<Integer,Integer>map=new HashMap<>();
          int i=0;
          int j=0;
          while(i<n){
              map.put(arr[i],map.getOrDefault(arr[i],0)+1);
              if(i-j+1==k){
                  list.add(map.size());
                  if(map.get(arr[j])==1){
                      map.remove(arr[j]);
                  }else{
                      map.put(arr[j],map.getOrDefault(arr[j],0)-1);
                  }
                  j++;
              }
              i++;
          }
          return list;
    }
}

