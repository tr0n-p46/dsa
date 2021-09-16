public class LIS {

    public static int solve(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];
        for(int i = 0;i < n;i++)
            dp[i] = 1;
        for(int i = 1;i < n;i++) {
            for(int j = 0;j < i;j++)
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;

        }
        int res = 0;
        for(int i = 0;i < n;i++)
            if(res < dp[i])
                res = dp[i];
        return res;
    }

    public static void main(String[]args) {
        int arr[] = {10, 12, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(solve(arr));
    }
}