//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node num1 = new Node(val);
            Node tail = num1;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node num2 = new Node(val);
            tail = num2;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node num1, Node num2){
        // code here
        // return head of sum list
        Node rev1=reverseList(num1);
        Node rev2=reverseList(num2);
        Node temp1=rev1;
        Node temp2=rev2;
        Node dummy=new Node(0);
        Node runner=dummy;
        int carry=0;
        while(temp1!=null || temp2!=null || carry!=0){
            int sum=carry;
            
            if(temp1!=null){
                sum=sum+temp1.data;
                temp1=temp1.next;
            }
            
            if(temp2!=null){
                sum=sum+temp2.data;
                temp2=temp2.next;
            }
            
            Node newnode=new Node(sum%10);
            carry=sum/10;
            runner.next=newnode;
            runner=runner.next;
            
        }
         Node res= reverseList(dummy.next);
         while(res!=null){
             if(res.data==0){
                 res=res.next;
             }else{
                 break;
             }
             
         }
         
         if(res==null || res.next==null)return new Node(0);
         return res;
        
    }
    static Node reverseList(Node head){
        Node curr=head;
        Node prev=null;
        
        
        while(curr!=null){
            Node node=curr.next;
            curr.next=prev;
            prev=curr;
            curr=node;
        }
        return prev;
    }
}