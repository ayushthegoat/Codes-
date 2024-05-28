class Solution {
public:
    int nearestExit(vector<vector<char>>& maze, vector<int>& entrance) {
        int r = maze.size();
        int c = maze[0].size();
        queue<pair<int,pair<int,int>>>q;  //{steps, {row , col}}
        q.push({0,{entrance[0],entrance[1]}});

        maze[entrance[0]][entrance[1]] = '+';

        static const vector<pair<int,int>> directions  = {
            {1,0},{0,1},{-1,0},{0,-1}
        };

        int steps = 0;
        while(!q.empty()){
            auto it = q.front();
            q.pop();
            int steps = it.first;
            int row = it.second.first;
            int col = it.second.second;
            
            
            for(const auto &dir : directions){
                int nrow = row + dir.first;
                int ncol = col + dir.second;

                if(nrow>=0 && nrow<r && ncol>=0 && ncol<c && maze[nrow][ncol]=='.'){
                    if(nrow==0 || nrow == r-1 || ncol == 0 || ncol == c-1){
                        return steps+1;
                    }else{
                        maze[nrow][ncol] = '+';
                        q.push({steps+1,{nrow,ncol}});
                    }

                }
            }

        }
        
         return -1;
    }
};