//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
	ArrayList <Integer> boundary(Node root)
	{
	    if(root==null)return new ArrayList<Integer>();
	    ArrayList<Integer> list=new ArrayList<>();
	    if(isLeaf(root)){
	        list.add(root.data);
	        return list;
	    }
	    list.add(root.data);
	    addLeft(root,list);
	    addLeaves(root,list);
	    addRight(root,list);
	    
	    return list;
	    
	}
	void addLeaves(Node root , ArrayList<Integer>list){
	    if(root==null)return ;
	    if(isLeaf(root)){
	        list.add(root.data);
	        return ;
	    }
	    addLeaves(root.left,list);
	    addLeaves(root.right,list);
	}
	void addLeft(Node root, ArrayList<Integer> list){
	    if(root==null)return ;
	    Node temp=root.left;
	    while(temp!=null){
	        if(isLeaf(temp)==false){
	            list.add(temp.data);
	        }
	        if(temp.left!=null){
	            temp=temp.left;
	        }else{
	            temp=temp.right;
	        }
	    }
	    
	    
	}
	void addRight(Node root, ArrayList<Integer> list){
	    if(root==null)return ;
	    Stack<Integer>stk=new Stack<>();
	    Node temp=root.right;
	    while(temp!=null){
	        if(isLeaf(temp)==false){
	            stk.push(temp.data);
	        }
	        if(temp.right!=null){
	            temp=temp.right;
	        }else{
	            temp=temp.left;
	        }
	    }
	    while(!stk.isEmpty()){
	        list.add(stk.pop());
	    }
	}
	boolean isLeaf(Node root){
	    if(root.left==null && root.right==null)return true;
	    return false;
	}
}
