package git.Algorithm.programmers.lv3;

public class ThreeMulNTiling {
    public int solution(int n) {
        long answer = 11;
        long a = 3;
        long b = 11;
        if(n%2 ==1){
            return 0;
        }
        if(n == 2){
            return 3;
        }
        n = n/2;
        for(int i = 2; i < n; i++){
            answer = (4*b% 1000000007 - (a% 1000000007) +1000000007)% 1000000007;
            a = b;
            b = answer;
        }
        return (int)answer;
    }
}
