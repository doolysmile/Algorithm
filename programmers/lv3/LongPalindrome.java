package git.Algorithm.programmers.lv3;

public class LongPalindrome {

    public int solution(String s)
    {
        int answer = 0;
        char[] p = s.toCharArray();
        boolean check = true;
        boolean check1 = false;
        for(int R = s.length(); R > 0; R--){

            for(int L = 0 ; L + R <= s.length() ; L++){

                check = true;

                for(int i = 0; i < R/2; i++){
                    if(p[L + i] != p[L + R - 1 - i]){
                        check = false;
                        break;
                    }
                }


                if(check){
                    answer = R;
                    check1 = true;
                    break;
                }

            }
            if(check1){
                break;
            }
        }

        return answer;
    }
}
