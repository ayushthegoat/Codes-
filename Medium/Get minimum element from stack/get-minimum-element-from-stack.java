//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG
{
    int minEle;
    Stack<Integer> s;
    Stack<Integer>min;
    // Constructor    
    GfG()
	{
	 minEle=Integer.MAX_VALUE;
     s=new Stack<>();
     min=new Stack<>();
	}
	
    /*returns min element from stack*/
    int getMin()
    {
  if(min.isEmpty()){
      return -1;
  }else{
      return min.peek();
  }
	// Your code here
	
    }
    
    /*returns poped element from stack*/
    int pop()
    {
     if (s.isEmpty()) {
        return -1;
    } else {
        int out = s.pop();
        if (!min.isEmpty() && out == min.peek()) {
            min.pop();
        }
        return out;
        }
     }
        
	
     
    

    /*push element x into the stack*/
    void push(int x)
    {
         s.push(x);
    if(min.isEmpty() || x <= min.peek()) {
        min.push(x);
    }
    
    }
     
	// Your code here
          
    }
    


