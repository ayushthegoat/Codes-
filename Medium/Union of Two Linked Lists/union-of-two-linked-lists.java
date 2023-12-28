//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

class GfG
{
    static Scanner sc = new Scanner(System.in);
    
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
    {
        int t = sc.nextInt();
        while(t-->0)
        {
            int n , m;
            
            n = sc.nextInt();
            Node head1 = inputList(n);
            
            m = sc.nextInt();
            Node head2 = inputList(m);
            
            Sol obj = new Sol();
            
            printList(obj.findUnion(head1, head2));
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Sol
{
	public static Node findUnion(Node head1,Node head2)
	{
	    //Add your code here.
	    Set<Integer>set=new TreeSet<>();
	    Node temp1=head1;
	    Node temp2=head2;
	    while(temp1!=null){
	        set.add(temp1.data);
	        temp1=temp1.next;
	    }
	    while(temp2!=null){
	        set.add(temp2.data);
	        temp2=temp2.next;
	    }
	    ArrayList<Integer>list=new ArrayList<>(set);
	    Node starter=null;
	    Node runner=null;
	    for(int i:list){
	        Node newnode=new Node(i);
	          if(starter==null){
	              starter=newnode;
	              runner=newnode;
	              
	          }else{
	              runner.next=newnode;
	              runner=newnode;
	          }
	          
	    }
	    return starter;
	}
}