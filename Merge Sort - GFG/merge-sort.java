//{ Driver Code Starts
import java.util.*;

class Merge_Sort
{
    //method to print the elements of the array
	static void printArray(int arr[])
    {
        StringBuffer sb=new StringBuffer("");
        int n = arr.length;
        for (int i=0; i<n; ++i)
            sb.append(arr[i]+" ");
        System.out.println(sb.toString());
    }

    

	public static void main(String args[])
	{
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking testcases
		int T = sc.nextInt();
		while(T>0)
		{
		    //taking elements count
			int n = sc.nextInt();
			
			//creating an object of class Merge_Sort
			Merge_Sort ms = new Merge_Sort();
			
			//creating an array of size n
			int arr[] = new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

            
			Solution g = new Solution();
			
			//calling the method mergeSort
			g.mergeSort(arr,0,arr.length-1);

            //calling the method printArray
			ms.printArray(arr);
		T--;
		}
	}
}



// } Driver Code Ends


class Solution
{
    void merge(int arr[], int l, int m, int r)
    {
  ArrayList<Integer> list = new ArrayList<>();

        int left = l;
        int mid = m + 1;
        int high = r;

        while (left <= m && mid <= high) {
            if (arr[left] < arr[mid]) {
                list.add(arr[left]);
                left++;
            } else {
                list.add(arr[mid]);
                mid++;
            }
        }

        while (left <= m) {
            list.add(arr[left]);
            left++;
        }

        while (mid <= high) {
            list.add(arr[mid]);
            mid++;
        }

        int idx = 0;
        for (int i = l; i <= r; i++) {
            arr[i] = list.get(idx);
            idx++;
        }
        
    }
    void mergeSort(int arr[], int low, int high){
      if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
}
}