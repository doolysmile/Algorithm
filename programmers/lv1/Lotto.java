package git.Algorithm.programmers.lv1;

public class Lotto {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt = 0;
        int qu = 0;
        for(int i = 0; i < 6; i++){
            if(lottos[i] == 0){
                qu++;
                continue;
            }
            for(int j = 0; j < 6; j++){
                if(lottos[i] == win_nums[j]){
                    cnt++;
                }
            }
        }
        answer[0] = 7 - cnt - qu < 7 ? 7 - cnt - qu : 6;
        answer[1] = 7 - cnt < 7 ? 7 - cnt : 6;
        return answer;
    }
}
