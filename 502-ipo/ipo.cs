public class Solution {
    public int FindMaximizedCapital(int k, int w, int[] profits, int[] capital) {
           var projects = new List<(int capital, int profits)>();

           for(int i=0;i<profits.Length;i++){
            projects.Add((capital[i], profits[i]));
           }
           
           projects = projects.OrderBy(x=> x.capital).ToList();

           var queue = new PriorityQueue<int, int>();
           var completedProjects = 0;

           while(k-- >0) {
            
             while(completedProjects < projects.Count && projects[completedProjects].capital <= w) {
                //queue.Enqueue(projects[completedProjects].profit, int.MaxValue - projects[completedProjects].profit);
                queue.Enqueue(projects[completedProjects].profits, int.MaxValue - projects[completedProjects].profits);
                completedProjects++;
             }
             if(queue.Count == 0) break;

             w+= queue.Dequeue();
           }

           return w;
    
    }
}