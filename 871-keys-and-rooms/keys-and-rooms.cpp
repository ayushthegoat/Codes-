class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        queue<int>q;
        vector<bool>vis (rooms.size(), 0);
        vis[0] = 1;
        q.push(0);

        while(!q.empty()){
            int node = q.front();
            q.pop();

            for(const auto &adjacent : rooms[node]){
                if(!vis[adjacent]){
                    vis[adjacent] = true;
                    q.push(adjacent);
                }
            }
        }

        for(const auto &iterator : vis){
            if(iterator == false){
                return false;
            }
        }

        return true;
        
    }
};