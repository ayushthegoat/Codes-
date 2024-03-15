//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

class Partition {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.partition(head, k);
            printList(res);
            System.out.println();
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node partition(Node node, int x) {
        boolean found=false;
        // Your code here
       Node temp = node;
    Node starter1 = new Node(0);
    Node runner1 = starter1;
    Node starter2 = new Node(0);
    Node runner2 = starter2;
    Node starter3 = new Node(0);
    Node runner3 = starter3;
    while (temp != null) {
        if (temp.data < x) {
            runner1.next = temp;
            runner1 = temp;
        } else if(temp.data > x){
            runner2.next = temp;
            runner2 = temp;
        } else if(temp.data == x){
            found=true;
            runner3.next=temp;
            runner3=temp;
        }
        temp = temp.next;
    }

    if(found){
    runner1.next = starter3.next;
    runner3.next = starter2.next;
    runner2.next = null;
    }else{
        runner1.next=starter2.next;
        runner2.next=null;
    }
    return starter1.next;
}
}