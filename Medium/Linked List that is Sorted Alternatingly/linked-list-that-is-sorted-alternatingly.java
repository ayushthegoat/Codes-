//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}

// } Driver Code Ends



/*
class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    
  public Node sort(Node head) {
  
    if (head == null || head.next == null)
        return head;

    Node middle = findMid(head);
    Node nextToMiddle = middle.next;
    middle.next = null;

    Node left = sort(head);
    Node right = sort(nextToMiddle);

    return merge(left, right);
}
   public Node merge(Node left,Node right){
      Node starter=new Node(0);
      Node runner=starter;
      while(left!=null && right!=null){
          if(left.data<right.data){
              runner.next=left;
              left=left.next;
          }else{
              runner.next=right;
              right=right.next;
          }
          runner=runner.next;
          
      }
         if (left != null) {
            runner.next = left;
        }
        if (right != null) {
            runner.next = right;
        }
         while (runner.next != null) {
        runner = runner.next;
    }

        return starter.next;
   }
   public Node findMid(Node head){
       Node fast=head.next;
       Node slow=head;
       
       while(fast!=null && fast.next!=null){
           fast=fast.next.next;
           slow=slow.next;
       }
       return slow;
       
   }


} 