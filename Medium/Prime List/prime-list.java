//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}

class Main
{
    public static void main(String args[])throws Exception
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t;
        t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n;
            n=Integer.parseInt(in.readLine());
            Node head,tail;
            String s[]=in.readLine().trim().split(" ");
            int num=Integer.parseInt(s[0]);
            head=new Node(num);
            tail=head;
            for(int i=1;i<n;i++){
                num=Integer.parseInt(s[i]);
                tail.next=new Node(num);
                tail=tail.next;
            }
            Solution ob=new Solution();
            Node temp=ob.primeList(head);
            while(temp!=null){
                out.print(temp.val+" ");
                temp=temp.next;
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution
{
    Node primeList(Node head){
        //code here
        Node temp = head;
        while(temp!=null){
            temp.val = findNearestPrime(temp.val);
            temp = temp.next;
        }
        return head;
        
    }
    private int findNearestPrime(int k){
        if(isPrime(k))return k;
        if(k==1)return 2;
         if(k==2 || k==3 )return k;
        int small = k-1;
        int big = k+1;
        
        while(true){
            boolean S = isPrime(small);
            if(S)return small;
            boolean B = isPrime(big);
            if(B)return big;
            small--;
            big++;
        }
    }
    private boolean isPrime(int k){
        if(k<=1)return false;
       
        if(k%2==0)return false;
        for(int i=3;i*i<=k;i+=2){
            if(k%i==0)return false;
        }
        return true;
    }
}