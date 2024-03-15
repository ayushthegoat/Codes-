//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

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

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        if(head==null || head.next==null){
            return head;
        }
        Node middle=findMid(head);
        Node nextToMiddle=middle.next;
        
        middle.next=null;
        
        Node left=mergeSort(head);
        Node right=mergeSort(nextToMiddle);
        
        return merge(left,right);
        
    }
    static Node findMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    static Node merge(Node left,Node right){
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
        if(left!=null){
            runner.next=left;
        }
        if(right!=null){
            runner.next=right;
        }
        while(runner.next!=null){
            runner=runner.next;
        }
        return starter.next;
    }
}


