package git.Algorithm.programmers.lv2;

public class JadenCase {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] str = s.toLowerCase().split("");
        // true 다음 대문자, false 다음 소문자
        boolean check = true;
        for(String tmp : str){
            if(tmp.equals(" ")){
                check = true;
                sb.append(tmp);
                continue;
            }
            if(check){
                tmp = tmp.toUpperCase();
                check = false;
            }
            sb.append(tmp);
        }
        answer = sb.toString().trim();
        return answer;
    }
    public String solution1(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }

        return answer;
    }
}
