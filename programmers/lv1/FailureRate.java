package git.Algorithm.programmers.lv1;

public class FailureRate {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N+1];
        double[] check = new double[N+1];
        Rate[] rates = new Rate[N+1];
        int tmp = 0;
        Rate tmpD = null;
        int total = stages.length;
        int[] ans = new int[N];

        for(int i : stages){
            if(i < N+1 )
                answer[i]++;
        }

        for (int i = 1; i <= N; i++){
            check[i] = (double) answer[i] / total;
            total -= answer[i];
        }
        for(int i = 1; i <= N; i++){
            rates[i] = new Rate();
        }

        for(int i = 1; i<= N; i++){
            rates[i].idx = i;
            rates[i].rate = check[i];
        }

        for (int i = 1; i <= N ; i++){
            for (int j = 2; j <= N +1-i; j++){
                if (rates[j -1].rate < rates[j].rate){
                    tmpD = rates[j];
                    rates[j] = rates[j-1];
                    rates[j-1] = tmpD;
                }
            }
        }


        for(int i = 1; i <= N; i++){
            ans[i-1] = rates[i].idx;
        }

        return ans;
    }
    static class Rate{
        int idx;
        double rate;

        public Rate(){}

        public Rate(int idx, double rate) {
            this.idx = idx;
            this.rate = rate;
        }
    }
}
