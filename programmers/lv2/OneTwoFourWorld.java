package git.Algorithm.programmers.lv2;

public class OneTwoFourWorld {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int quotient = 0;
        int remainder = 0;
        while(n > 0){
            quotient = n % 3;
            remainder = n / 3;
            if(quotient == 0){
                quotient = 3;
                remainder--;
            }
            n = remainder;
            sb.append(quotient);
        }
        sb.reverse();
        answer = sb.toString();
        answer = answer.replaceAll("3", "4");
        return answer;
    }

    /**
     * 다른 사람의 풀이
     * 비슷하게 푼거 같지만, n-1 부분 나중에 다시 봐야될듯
     *
     */
//    public String solution(int n) {
//        String[] num = {"4","1","2"};
//        String answer = "";
//
//        while(n > 0){
//            answer = num[n % 3] + answer;
//            n = (n - 1) / 3;
//        }
//        return answer;
//    }
}
