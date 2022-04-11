package git.Algorithm.programmers.lv1;

public class KeyPad {

    public String solution(int[] numbers, String hand) {
        String answer = "";
        int r = 43;
        int l = 41;
        int rightDistance = 0;
        int leftDistance = 0;
        int[] location = {42, 11, 12, 13, 21, 22, 23, 31, 32, 33};
        for (int i : numbers) {
            int tmp = location[i];
            rightDistance = distance(tmp, r);
            leftDistance = distance(tmp, l);
            if(i == 1 || i == 4 || i == 7){
                l = tmp;
                answer = answer + "L";
            } else if(i == 3 || i == 6 || i == 9){
                r = tmp;
                answer = answer + "R";
            } else if (rightDistance == leftDistance) {
                if (hand.equals("right")) {
                    r = tmp;
                    answer = answer + "R";
                } else {
                    l = tmp;
                    answer = answer + "L";
                }
            } else if (rightDistance < leftDistance) {
                r = tmp;
                answer = answer + "R";
            } else if (leftDistance < rightDistance) {
                l = tmp;
                answer = answer + "L";
            }
        }
        return answer;
    }

    public static int distance(int a, int b){
        int dis = 0;
        dis = Math.abs((a%10) - (b%10)) + Math.abs((a/10) - (b/10));
        return dis;
    }

}
