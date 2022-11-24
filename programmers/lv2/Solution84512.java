package git.Algorithm.programmers.lv2;

public class Solution84512 {
    /*
    0, A, E, I, O, U
    5진법
    0 0 0 0 0 0
    A 0 0 0 0 1
    1 0 0 0 0 => 1
    A A 0 0 0 2
    1 1 0 0 0 => 2
    A A A 0 0 3
    A A A A 0 4
    -----------

    A A A A A 5
    0 0 0 0 0
    A A A A E 6
    1 1 1 1 2
    0 0 0 0 1
    A A A E 0 10
    0 0 0 1 0 => 6+4
    A A A E A 11
    0 0 0 1 0 => 6 + 5
    A A A E E 12
    0 0 0 1 1
    A A A E I 13
    0 0 0 1 2 => 6+2+5
    A A A I
    ---------
    1 625   781
    2 125   156
    3 25    31
    4 5     6
    5 1     1
 */
    public int solution(String word) {
        int answer = word.length();
        String str = "AEIOU";
        int[] mul = {781, 156, 31, 6, 1};
        for(int i = 0; i < word.length(); i++){
            answer = answer + mul[i] * str.indexOf(word.charAt(i));
        }
        return answer;
    }
}
