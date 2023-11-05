//{ Driver Code Starts
import java.util.*;

class Count
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int m = sc.nextInt();
            int n = sc.nextInt();
            
            int arr1[] = new int[m];
            int arr2[] = new int[n];
            
            for(int i = 0; i < m; i++)
              arr1[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              arr2[i] = sc.nextInt();
              
            Solution gfg = new Solution();
            ArrayList<Integer> res = gfg.countEleLessThanOrEqual(arr1, arr2, m, n);
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
        
    }
}
// } Driver Code Ends


// Complete the function given below
class Solution
{
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    { Arrays.sort(arr2);
       // add your code here
        ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < arr1.length; i++) {
        int counter = countandreturn(arr1[i], arr2);
        list.add(counter);
    }
    return list;
}

public static int countandreturn(int a, int[] arr2) {
    int count = binarySearch(arr2, a);
    return count;
}

public static int binarySearch(int arr[], int key) {
    int start = 0;
    int end = arr.length - 1;
    int result = -1;

    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (arr[mid] <= key) {
            result = mid;
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }

    return result + 1;
}
}