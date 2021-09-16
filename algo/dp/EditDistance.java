public class EditDistance {

    public static int solve(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int dp[][] = new int[m + 1][n + 1];
        for(int i = 0;i <= m;i++) {
            for(int j = 0;j <= n;j++) {
                if(i == 0)
                    dp[i][j] = j;
                else if(j == 0)
                    dp[i][j] = i;
                else if(X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }
        return dp[m][n];
    }

    public static int min(int a, int b, int c) {
        return (a < b)?((a < c)?a:c):((b < c)?b:c);
    }

    public static void main(String[]args) throws Exception {
        String X = "sunday";
        String Y = "saturday";
        System.out.println(solve(X, Y));
    }
}