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
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            int k = Integer.parseInt(input[2]);
            Solution ob = new Solution();
            System.out.println(ob.kthCharacter(m,n,k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    char kthCharacter(int m, int n, int k) {
        // code here
        
       String binaryString = Integer.toBinaryString(m);
StringBuilder snt = new StringBuilder(binaryString);
while (n-- > 0) {
    StringBuilder curr = new StringBuilder(snt);
    StringBuilder s = new StringBuilder(); 
    for (int i = 0; i < curr.length(); i++) {
        char ch = curr.charAt(i);
        s.append(stringmaker(ch));
    }
    snt = new StringBuilder(s.toString()); 
    
}
//System.out.println(snt);
char res=' ';
for(int i=0;i<k;i++){
    res=snt.charAt(i);
}
return res;
        
    }
    public StringBuilder stringmaker(char c){
        StringBuilder ss=new StringBuilder();
        if(c=='0'){
            ss.append("01");
        }else{
            ss.append("10");
        }
        return ss;
        
    }
}