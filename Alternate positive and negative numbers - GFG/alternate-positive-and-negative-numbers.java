//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
      
       ArrayList<Integer>listPos=new ArrayList<>();
        ArrayList<Integer>listNeg=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            if(arr[i]>=0){
                listPos.add(arr[i]);
            }
            if(arr[i]<0){
                listNeg.add(arr[i]);
            }
        }
        int posInd=0;
        int negInd=0;
        int commonInd=0;
        while(posInd<listPos.size() && negInd<listNeg.size()){
            arr[commonInd++]=listPos.get(posInd++);
            arr[commonInd++]=listNeg.get(negInd++);
        }
        while(posInd<listPos.size()){
            arr[commonInd++]=listPos.get(posInd++);
            
        }
         while(negInd<listNeg.size()){
            arr[commonInd++]=listNeg.get(negInd++);
         }
    }
}