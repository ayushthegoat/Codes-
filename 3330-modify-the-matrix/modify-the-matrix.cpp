class Solution {
public:
    vector<vector<int>> modifiedMatrix(vector<vector<int>>& matrix) {
        int row = matrix.size();
        int col = matrix[0].size();
        vector<int>store(col,INT_MIN);
        vector<vector<int>>answer(row,vector<int>(col));
        
        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
            store[i] = max(store[i],matrix[j][i]);
            }
        }
        for(auto it:store)cout<<it;

        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
                if(matrix[j][i]==-1){
                    answer[j][i] = store[i];
                }else{
                    answer[j][i] = matrix[j][i];
                }
            }
        }
        return answer;
    }
};