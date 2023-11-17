//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
        boolean neg=false;
        boolean alphaPresent=false;
        if(str==null || str.length()==0){return 0;}
        
        str=str.trim();
        if(str.charAt(0)=='-'){
            neg=true;
             str=str.substring(1,str.length());
        }
       
        int result=0;
        int beg=0;
        while(beg<str.length()){
         char c=str.charAt(beg);
            if(c>='0' && c<='9'){
            result=result*10+(c-'0');
            }else if(str.charAt(beg)!='0' ||str.charAt(beg)!='1'||str.charAt(beg)!='2'
            ||str.charAt(beg)!='3'||str.charAt(beg)!='4'||str.charAt(beg)!='5'||str.charAt(beg)!='6'
            ||str.charAt(beg)!='7'||str.charAt(beg)!='8'||str.charAt(beg)!='9'){
            alphaPresent=true;
            
           
           
        }
        beg++;
        }
        if(alphaPresent==true){
            return -1;
        }
           if(neg==true){result=result*(-1);return result;}
     
        
    
    return result;
    }
}
    

