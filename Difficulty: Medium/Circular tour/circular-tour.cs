//{ Driver Code Starts
//Initial Template for C#


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DriverCode;

namespace DriverCode
{

    class GFG
    {
        static void Main(string[] args)
        {
            int testcases;// Taking testcase as input
            testcases = Convert.ToInt32(Console.ReadLine());
            while (testcases-- > 0)// Looping through all testcases
            {

                int N = Convert.ToInt32(Console.ReadLine());
                var ip = Console.ReadLine().Trim().Split(' ');
                Solution.petrolPump[] arr = new Solution.petrolPump[N];

                int k = 0;
                for (int i = 0; i < 2 * N; i += 2)
                {
                    int a = int.Parse(ip[i]);
                    int b = int.Parse(ip[i + 1]);
                    arr[k] = new Solution.petrolPump(a, b);
                    k++;
                }

                Solution obj = new Solution();
                var res = obj.tour(arr, N);
                Console.WriteLine(res);
            }

        }
    }
}
// } Driver Code Ends


//User function Template for C#

class Solution{
    //Structure of petrolPump
    public class petrolPump{
        public int petrol;
        public int distance;

        public petrolPump(int p, int d){
            this.petrol = p;
            this.distance = d;
        }

    }
  
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    public int tour(petrolPump[] p, int n)
    {
       //Your code here
       int start = 0;
       int surplus = 0;
       int deficit = 0;
       
       for(int i=0; i<n; i++) {
           surplus += p[i].petrol - p[i].distance;
           
           if(surplus < 0) {
               start = i + 1;
               deficit += surplus;
               surplus = 0;
               
           }
       }
       
       if(surplus + deficit >= 0) {
           return start;
       } 
       return -1;
    }
}