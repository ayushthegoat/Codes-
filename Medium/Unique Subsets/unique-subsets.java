//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    Arrays.sort(arr);
		    ArrayList <ArrayList<Integer>> res = new solve().AllSubsets(arr,n);
		    for (int i = 0; i < res.size (); i++)
		    {
		        System.out.print ("(");
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		            if (j != res.get(i).size()-1)
		                System.out.print ((res.get(i)).get(j) + " ");
		            else
		                System.out.print ((res.get(i)).get(j));
		        }
		        System.out.print (")");
		      
		    }
		    System.out.println();
		}
	}
}
// } Driver Code Ends


class solve
{
    //Function to find all possible unique subsets.
    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n)
    {
        // your code here
 ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        ArrayList<Integer> temp = new ArrayList<>();
        
        solve(res, set, temp, arr, 0);
        
        Collections.sort(res, (a, b) -> {
            int minSize = Math.min(a.size(), b.size());
            for (int i = 0; i < minSize; i++) {
                int comp = Integer.compare(a.get(i), b.get(i));
                if (comp != 0) return comp;
            }
            return Integer.compare(a.size(), b.size());
        });
        
        return res;
    }
    public static void solve(ArrayList<ArrayList<Integer>> res, HashSet<ArrayList<Integer>> set,
                             ArrayList<Integer> temp, int[] arr, int index) {
        if (index > arr.length - 1) {
            if (!set.contains(temp)) {
                res.add(new ArrayList<>(temp));
                set.add(new ArrayList<>(temp));
            }
            return;
        }
        
      
        temp.add(arr[index]);
        solve(res, set, temp, arr, index + 1);
        temp.remove(temp.size() - 1);
         solve(res, set, temp, arr, index + 1);
    }
}
