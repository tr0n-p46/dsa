public class MinCostPath {

    public static int solve(int c[][], int x, int y) {
        int dp[][] = new int[x + 1][y + 1];
        for(int i = 1;i <= x;i++)
            dp[i][0] = dp[i - 1][0] + c[i][0];
        for(int i = 1;i <= y;i++)
            dp[0][i] = dp[0][i - 1] + c[0][i];
        for(int i = 1;i <= x;i++) {
            for(int j = 1;j <= y;j++) {
                dp[i][j] = c[i][j] + min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[x][y];
    }

    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[]args) {
        int c[][] = {{1, 2, 3},
                       {4, 8, 2},
                       {1, 5, 3}};
        System.out.println(solve(c, 2, 2));
    }
}