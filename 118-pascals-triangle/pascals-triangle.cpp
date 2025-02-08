class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> ans; // To store Pascal's Triangle
        
        for (int i = 0; i < numRows; i++) {
            vector<int> v(i + 1, 1); // Create a row with all elements initialized to 1
            
            // Update inner elements (skip the first and last element)
            for (int j = 1; j < i; j++) {
                v[j] = ans[i - 1][j] + ans[i - 1][j - 1];
            }
            
            ans.push_back(v); // Add the current row to the result
        }
        
        return ans;
    }
};
