//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{   void swap(int[] arr,int index,int swapindex){
    int temp=arr[index];
    arr[index]=arr[swapindex];
    arr[swapindex]=temp;
    
    }
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        int[] aux=nums.clone();
        Map<Integer,Integer>map=new HashMap<>();
        Arrays.sort(aux);
        for(int i=0;i<nums.length;i++){
            map.put(aux[i],i);
        }
        int i=0;
        int swaps=0;
        while(i<nums.length){
            if(map.get(nums[i])==i){
                i++;
            }else{
                swap(nums,i,map.get(nums[i]));
                swaps++;
            }
            
        }
        return swaps;
    }
}