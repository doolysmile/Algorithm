package git.Algorithm.programmers.lv1;

public class PrimeNumber {
    public int solution(int[] nums) {
        int answer = 0;
        int tmp = 0;

        for (int i = 0; i < nums.length - 2 ; i++){
            for (int j = i+1; j < nums.length - 1 ; j++){
                for(int k = j + 1 ; k < nums.length ; k++){
                    tmp = nums[i] + nums[j] + nums[k];
                    boolean cnt = true;
                    for (int l = 2; l <= (int)Math.sqrt(tmp); l++){
                        if (tmp % l == 0) {
                            cnt = false;
                            break;
                        }
                    }
                    if(cnt == true){
                        answer++;
                    }
                }
            }
        }


        return answer;
    }
}
