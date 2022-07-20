package git.Algorithm.programmers.lv3;

public class ThreeMulNTiling {
    public int solution(int n) {
        long answer = 11;
        long a = 3;
        long b = 11;
        n = n/2;
        for(int i = 2; i < n; i++){
            answer = 4*b - a;
            a = b;
            b = answer;

        }
        return (int)(answer%1000000007);
    }

    public static int solution(int n) {
        int answer = 0;
        int mod = 1000000007;
        long[] dp = new long[5001];

        dp[0] = 1;
        dp[2] = 3;
        for(int i=4; i<=n; i+=2){
            dp[i] = dp[i-2] * 3;
            for(int j=i-4; j>=0; j-=2){
                dp[i] += dp[j] * 2;
            }
            dp[i] = dp[i] % mod;
        }

        answer = (int) dp[n];
        return answer;
    }
    public static void main(String[] args) {
        ThreeMulNTiling s = new ThreeMulNTiling();
        System.out.println(s.solution(5000));
    }
}
