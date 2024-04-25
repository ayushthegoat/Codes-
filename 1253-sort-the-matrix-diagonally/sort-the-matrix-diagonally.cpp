class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        int row = mat.size();
        int col = mat[0].size();

        unordered_map<int,vector<int>> map;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                map[i-j].push_back(mat[i][j]);
            }
        }
        for(auto &it:map){
            sort(it.second.begin() ,it.second.end());
        }
        
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                mat[i][j] = map[i-j].back();
                map[i-j].pop_back();
            }
        }
        return mat;
    }
};