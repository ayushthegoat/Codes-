class Solution {
public:
    vector<int> luckyNumbers (vector<vector<int>>& matrix) {
        
        int row = matrix.size();
        int col = matrix[0].size();
        vector<int> res ;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                int elem = matrix[i][j];

                int mn = *min_element(matrix[i].begin() , matrix[i].end());

                int mx = matrix[0][j];
                for(int k=1; k<row; k++){
                    mx = max(mx,matrix[k][j]);
                }

                if(elem == mn && elem==mx)res.push_back(elem);
            }
        }
        return res;
    }
};