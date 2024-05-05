//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    char val;
    Node left, right;
    Node(char c)
    {
        val = c;
        left = right = null;
    }
}

class Construct
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String str = "";
            str = sc.next();
            char postfix[] = str.toCharArray();
            GfG gfg = new GfG();
            Node et = gfg.constructTree(postfix);
            inorder(et);
            System.out.println();
        }
    }
    
    public static void inorder(Node et)
    {
        if(et != null)
        {
            inorder(et.left);
            System.out.print(et.val + " ");
            inorder(et.right);
        }
    }
    
    public static boolean isOperator(char c)
    {
        if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
          return true;
          
        return false;
    }
}


// } Driver Code Ends


class GfG
{
    
    public static Node constructTree(char postfix[])
    {
        Stack<Node>stk = new Stack();
        
       for(int i=0;i<postfix.length;i++){
            
            if(Character.isAlphabetic(postfix[i])){
                Node newnode = new Node(postfix[i]);
                stk.push(newnode);
            }else{
                Node t1 = stk.pop();
                Node t2 = stk.pop();
                Node newnode = new Node(postfix[i]);
                newnode.left = t2;
                newnode.right = t1;
                stk.push(newnode);
            }
       }
       Node temp = stk.pop();
       return temp;
    }
    
}