class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        int n = tickets.size();
        int time = 0;

        while(true){
            for(int i=0;i<n;i++){
                if(tickets[i]>0){
                    time++;
                    tickets[i]--;
                }
                if(tickets[k]==0)return time;
            }
           
        }
    }
};