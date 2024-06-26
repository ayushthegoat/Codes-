//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
    public static void rearrange(Node head)
    {
        if (head == null || head.next == null) {
        return;
    }
        // add your code here
        Node temp = head;
        Node rev = head.next;
        Node starter = head;
        Node revStarter = rev;
        
        while(rev!=null && rev.next!=null){
            temp.next = rev.next;
            temp = temp.next;
            rev.next = temp.next;
            rev = rev.next;
        }
        temp.next = null;
        Node attacher = reverseList(revStarter);
       
    //      temp = head;
    // while (temp.next != null) {
    //     temp = temp.next;
    // }
    temp.next = attacher;
    
        
        
    }
   private static Node reverseList(Node head){
        if(head==null || head.next == null)return head;
        
        Node prev = null;
        Node curr = head;
        while(curr!=null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
