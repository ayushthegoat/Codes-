//{ Driver Code Starts
import java.util.*;

class Node
{

    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class LinkedList
{
    
 

    /* Function to print linked list */
   public static void print(Node root)
    {
        Node temp = root;
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
    }


    /* Driver program to test above functions */
    public static void main(String args[])
    {

        /* Constructed Linked List is 1.2.3.4.5.6.
         7.8.8.9.null */
        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt() )
        {
            int n = sc.nextInt();
            
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;

            for (int i = 1; i < n && sc.hasNextInt() ; i++)
            {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }


            Node result = new Solution().compute(head);
            print(result);
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution
{
   
      Node compute(Node head) {
          Node prev=null;
          Node curr=head;
          while(curr!=null){
              Node node=curr.next;
              curr.next=prev;
              prev=curr;
              curr=node;
          }
          Node temp=prev;
        int maxSoFar = Integer.MIN_VALUE;
        
        Node starter = new Node(temp.data);
        Node runner = starter;
        
       
        while (temp != null) {
       
            if (temp.data >= maxSoFar) {
                Node newnode = new Node(temp.data);
                runner.next = newnode;
                runner = newnode;
            }
       
            maxSoFar = Math.max(maxSoFar, temp.data);
       
            temp = temp.next;
        }
          return reverseLinkedList(starter.next);
    }
    
   
    Node reverseLinkedList(Node head) {
        Node prev = null;
        Node curr = head;
        
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        
        return prev;
    }
}
  