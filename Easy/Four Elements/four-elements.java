//{ Driver Code Starts
import java.util.Arrays;
import java.util.Scanner;
class FindFourElements
{
	
    public static void main(String[] args) 
    {
		Scanner sc=new Scanner (System.in);
		int t=sc.nextInt();
		while(t-->0){
			FindFourElements findfour = new FindFourElements();
			int n=sc.nextInt();
			int[] A=new int[n];
			for(int i=0;i<n;i++)
				A[i]=sc.nextInt();
			int X =sc.nextInt();
			
			Compute ob = new Compute();
		    System.out.println(ob.find4Numbers(A, n, X)?1:0);
		}
    }
}


// } Driver Code Ends


class Compute
{
    boolean find4Numbers(int arr[], int n, int k) 
    {
        
        Arrays.sort(arr);
                if(n<4) return false;
        int left=0;
        int right=0;
           
              for(int i=0;i<arr.length-3;i++){
                  for(int j=i+1;j<arr.length-2;j++){
                     left=j+1;
                     right=arr.length-1;
                     
                     
                     while(left<right){
                         int sum=arr[i]+arr[j]+arr[left]+arr[right];
                         
                         if(sum==k){
                    
                          return true;
                     }else if(sum>k){
                         right--;
                     }else {
                         left++;
                     }
                   
                  }
              }
             
              }        
            return false;
    
    }
}