//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {int sum=0;
    int maxsize=0;
    int startcounter=0;
        // Your cod
        Map<Integer,Integer>map=new LinkedHashMap<>();
        for(int i=0;i<n;i++){
            sum=sum+arr[i];
            
            
            if(sum==0){
                maxsize=Math.max(maxsize,i+1);
            }
            if(map.containsKey(sum)){
                maxsize=Math.max(maxsize,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        return maxsize;
        
    }
}