package git.Algorithm.programmers.lv2;

public class Solution77885 {
    /*
    11 => 100
    1010 =>
    111
    011     3 => 101 5
    111     7
    1011    11
    1101
    01111   15
    10111
     */
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            answer[i] = cal(numbers[i]);
        }
        return answer;
    }
    public long cal(long num){
        long ans = 0;
        if(num % 4 == 3){
            long temp = num;
            int exponent = -1;
            while (temp % 2 != 0){
                exponent++;
                temp = temp>>1;
            }
            ans = num + (long)Math.pow(2, exponent);
        }
        else{
            ans = num + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution77885 s = new Solution77885();
        s.solution(new long[]{3});
        // 343 1015 779 891
    }

}
