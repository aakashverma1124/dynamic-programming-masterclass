import java.util.*;

class Solution {

    public int solve(int row, int col, List<List<Integer>> triangle, List<int[]> dp) {
        if(col > triangle.get(row).size()) return Integer.MAX_VALUE;
        
        if(row == triangle.size() - 1) return triangle.get(row).get(col);

        if(dp.get(row)[col] != -1) return dp.get(row)[col];

        int left = triangle.get(row).get(col) + solve(row + 1, col, triangle, dp);
        int right = triangle.get(row).get(col) + solve(row + 1, col + 1, triangle, dp);

        dp.get(row)[col] = Math.min(left, right);
        return dp.get(row)[col];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        List<int[]> dp = new ArrayList<>();
        for(int i = 0; i < triangle.size(); i++) {
            dp.add(new int[triangle.get(i).size()]);
            Arrays.fill(dp.get(i), -1);
        }
        return solve(0, 0, triangle, dp);
    }
}
