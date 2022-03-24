package git.Algorithm.programmers.lv1;

public class DivisorSum {
    public int solution(int n) {
        int answer = n;
        for(int i = 1; i<n; i++){
            if(n%i == 0)
                answer += i;
        }
        return answer;
    }
}
