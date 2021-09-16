public class LCS {

    public static int solve(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int dp[][] = new int[m + 1][n + 1];
        for(int i = 0;i <= m;i++) {
            for(int j = 0;j <= n;j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    public static int max(int a, int b) {
        return (a > b)?a:b;
    }

    public static void main(String[]args) throws Exception {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println(solve(X, Y));
    }
}