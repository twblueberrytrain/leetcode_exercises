class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int [][] sum = new int[m][n];
        int i = 0;
        int j = 0;

        if (m == 1 && n == 1) {
            return grid[0][0];
        } else if (m == 1) {
            int all = 0;
            for (i = 0; i < n; i++) {
                all += grid[0][i];
            }
            return all;
        } else if (n == 1) {
            int all = 0;
            for (i = 0; i < m; i++) {
                all += grid[i][0];
            }
            return all;
        }

        sum[0][0] = grid[0][0];

        for (i = 1; i < n; i++) {
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }

        for (i = 1; i < m; i++) {
            sum[i][0] = grid[i][0] + sum[i - 1][0];
            for (j = 1;j < n;j++) {
                if (sum[i][j - 1] > sum[i - 1][j]) {
                    sum[i][j] = sum[i - 1][j] + grid[i][j];
                } else {
                    sum[i][j] = sum[i][j - 1] + grid[i][j];
                }
            }
        }

        return sum[i - 1][j - 1];
    }
}