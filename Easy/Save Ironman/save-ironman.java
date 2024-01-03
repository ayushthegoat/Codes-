//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    Complete obj = new Complete();
		    boolean ans = obj.saveIronman(line);
        	if(ans == true)
        	    System.out.println("YES");
		    else
		        System.out.println("NO");
		    
		}
	}
}








// } Driver Code Ends


//User function Template for Java

class Complete{
    
   
    // Function for finding maximum and value pair
    public static boolean saveIronman (String s) {
        //Complete the function
        s=s.toLowerCase();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
           if(Character.isLetter(c))sb.append(c);
           if(Character.isDigit(c))sb.append(c);
        }
    return checkForPalli(sb);
    }
    static boolean checkForPalli(StringBuilder str){
        int i=0;
        int j=str.length()-1;
        while(i<j){
      if(str.charAt(i)!=str.charAt(j)){
          return false;
      }
      i++;
      j--;
        }
        return true;
    }
    
}
