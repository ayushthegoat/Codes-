//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class duplicates
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
      void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	/* Drier program to test above functions */
	public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
         {
			int N = sc.nextInt();
			duplicates llist = new duplicates(); 
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < N; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		head = ob.removeAllDuplicates(llist.head);
		llist.printList(head);
		
        t--;		
        }
    }
    
}
// } Driver Code Ends


//User function Template for Java

/* Linked List Node class

class Node
{
    int data;
    Node next;
}
    
*/

class Solution
{
    public static Node removeAllDuplicates(Node head)
    {
        //code here
        Map<Integer,Integer>map=new LinkedHashMap<>();
        Node temp=head;
        while(temp!=null ){
          map.put(temp.data,map.getOrDefault(temp.data,0)+1);
            
             temp=temp.next;
        }
       List<Integer> keysToRemove = new ArrayList<>();

for (Integer i : map.keySet()) {
    if (map.get(i) > 1) {
        keysToRemove.add(i);
    }
}

for (Integer key : keysToRemove) {
    map.remove(key);
}
        Node starter=null;
        Node runner=null;
        for(Integer i:map.keySet()){
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