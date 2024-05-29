class Solution {
public:

    vector<int> parent;
    vector<int> rank;

    int find(int x){
      if(x == parent[x]){
        return x;
      }

      return parent[x] = find(parent[x]);
    }

    void Union(int x, int y){

        int x_p = find(x);
        int y_p = find(y);

        if(x_p == y_p){
            return;
        }    
        if(x_p < y_p){
            parent[x_p] = y_p;
        } else if (x_p > y_p){
            parent[y_p] = x_p;
        } else {
            parent[x_p] = y_p;
            rank[y_p]++;
        }

        }
    
    bool equationsPossible(vector<string>& equations) {
        parent.resize(26);
        rank.resize(26,0);

        for(int i=0; i<26; i++){
            parent[i] = i;
        }

        //union 
        for(auto it : equations){
            if(it[1] == '='){
                Union(it[0] - 'a',it[3] - 'a');
            }

        }

        for(auto &it : equations){

            if(it[1] == '!'){

                char first = it[0];
                char second = it[3];

                int parentF = find(first-'a');
                int parentS = find(second-'a');

                if(parentF == parentS){
                    return false;
                }
            }
        }
        return true;

    }
};