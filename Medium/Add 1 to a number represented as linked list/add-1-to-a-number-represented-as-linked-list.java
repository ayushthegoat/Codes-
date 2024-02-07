//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
        //code here.
        Node temp=head;
        ArrayList<Integer>list=new ArrayList<>();
        while(temp!=null){
            list.add(temp.data);
            temp=temp.next;
            
        } 
        int total =0;
        int carry=1;
        for(int i=list.size()-1;i>=0;i--){
            total=list.get(i)+carry;
            list.set(i,total%10);
            carry=total/10;
            
        }
        if(carry>0){
            list.add(0,carry);
        }
         Node starter=null;
         Node runner=null;
         for(int i=0;i<list.size();i++){
             if(starter==null){
                 starter=new Node(list.get(i));
                 runner=starter;
                 
             }else{
                 Node newnode=new Node(list.get(i));
                 runner.next=newnode;
                 runner=newnode;
             }
         }
        return starter;
    }
}
