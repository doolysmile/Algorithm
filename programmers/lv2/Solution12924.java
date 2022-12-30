package git.Algorithm.programmers.lv2;

public class Solution12924 {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++){
            int sum = 0;
            for(int j = i; j <= n; j++){
                sum += j;
                if(sum == n){
                    answer++;
                }
                else if(sum > n){
                    break;
                }
            }
        }
        return answer;
    }
}
