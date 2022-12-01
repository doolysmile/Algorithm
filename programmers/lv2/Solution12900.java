package git.Algorithm.programmers.lv2;

public class Solution12900 {
    public int solution(int n) {
        int answer = 0;
        int pre = 1;
        int after = 2;
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        for(int i = 2 ; i < n; i++){
            int temp = after;
            after = (pre + after) % 1000000007;
            pre = temp;
        }
        answer = after % 1000000007;
        return answer;
    }

    public static void main(String[] args) {
        Solution12900 s = new Solution12900();
        System.out.println(s.solution(3));
    }
}
