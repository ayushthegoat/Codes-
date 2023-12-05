//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here 
        Stack<String>stk=new Stack<>();
        
        int i=0;
        int j=0;
        S+=".";
        while(i<S.length()){
            if(S.charAt(i)=='.'){
                stk.push(S.substring(j,i));
                j=i+1;
                
            }
            i++;
          
            }
              String res="";
            while(stk.isEmpty()==false){
            res=res+stk.pop();
            res=res+".";
           
        }
         res=res.substring(0,res.length()-1);
         
        return res;
        
    }
}