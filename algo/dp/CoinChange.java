import java.util.*;

public class CoinChange {

    public static int solve(int N, int S[]) {
        int dp[] = new int[N + 1];
        Arrays.fill(dp, N + 1);
        dp[0] = 0;
        for(int i = 1;i <= N;i++) {
            for(int j = 0;j < S.length;j++) {
                if(S[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - S[j]] + 1);
                }
            }
        }
        return dp[N] > N?-1:dp[N];
    }

    public static void main(String[]args) throws Exception {
        int N = 10;
        int S[] = {2, 3, 5, 6};
        System.out.println(solve(N, S));
    }
}