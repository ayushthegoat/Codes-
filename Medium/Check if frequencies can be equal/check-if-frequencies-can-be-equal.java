//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            
            Solution ob = new Solution();
            if(ob.sameFreq(a)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    boolean sameFreq(String s) {
        // code here
        int freq[]=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        int maxi=-1;
        int mini=-1;
        int max=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                if(freq[i]>max){
                    max=freq[i];
                    maxi=i;
                }
                if(freq[i]<min){
                    min=freq[i];
                    mini=i;
                }
            }
        }
         if(check(freq))return true;
         freq[maxi]--;
         if(check(freq))return true;
         freq[maxi]++;
         freq[mini]--;
         if(check(freq))return true;
         return false;
    }
    boolean check(int[] arr){
        int val=0;
        for(int i=0;i<arr.length;i++){
             if(arr[i]>0){
                 val=arr[i];
                 break;
             }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0 && arr[i]!=val){
                return false;
            }
        }
        return true;
    }
}