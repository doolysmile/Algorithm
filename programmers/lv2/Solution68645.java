package git.Algorithm.programmers.lv2;

public class Solution68645 {
    public int[] solution(int n) {
        int len = (n + 1)*n/2;
        int[] answer = new int[len];
        int index = 0;
        int cnt = 0;
        int target = n;
        int mode = 0; // 0 왼쪽 내려가기 1 쭉 가기 2 위로 올라가기
        int y = 0;
        for(int i = 1; i <= len; i++){
            switch (mode){
                case 0:
                    index = index + y;
                    y++;
                    break;
                case 1:
                    index++;
                    break;
                case 2:
                    index = index - y;
                    y--;
                    break;
            }
            answer[index] = i;
            cnt++;
            if(cnt == target){
                target--;
                cnt = 0;
                mode++;
                if(mode == 3){
                    mode = 0;
                }
            }
        }
        return answer;
    }
    // 6 5 4 3 2 1
    // 0 1 3 6 10 15

    public static void main(String[] args) {
        Solution68645 s = new Solution68645();
        s.solution(4);
    }
}
