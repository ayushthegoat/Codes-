//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SpeStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Stack<Integer> s=new Stack<>();
			GfG g=new GfG();
			while(!g.isEmpty(s)){
			    g.pop(s);
			}
			while(!g.isFull(s,n)){
				g.push(sc.nextInt(),s);
			}
		System.out.println(g.min(s));
		}
	}
}
// } Driver Code Ends


/*Complete the function(s) below*/
class GfG{
	public void push(int a,Stack<Integer> s)
	{
	    //add code here.
	    // if(s.isEmpty())return ;
	     s.push(a);
	}
	public int pop(Stack<Integer> s)
        {
            
            return s.pop();
            //add code here.
	}
	public int min(Stack<Integer> s)
        {
            int min=999999;
            while(!s.isEmpty()){
               if(s.peek()<min)min=s.pop();
               else s.pop();
            }
            return min;
            
           //add code here.
           
	}
	public boolean isFull(Stack<Integer>s, int n)
        {
            if(s.size()==n){return true;}
            return false;
            
           //add code here.
	}
	public boolean isEmpty(Stack<Integer>s)
        {
            if(s.isEmpty()){return true;}
           //add code here.
           return false;
	}
}