package git.Algorithm.programmers.lv3;

//효율성 테스트 때문에 고생함
public class GoingToSchool {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[m][n];
        map[0][0] = 1;

        for(int[] puddle : puddles){
            map[puddle[0] - 1][puddle[1] - 1] = -1;
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j< n; j++){
                if(map[i][j] != -1){
                    if(i-1 >= 0 && map[i-1][j] != -1){
                        map[i][j] += map[i-1][j];
                    }
                    if(j-1>=0 && map[i][j-1] != -1){
                        map[i][j] += map[i][j-1];
                    }
                    if(map[i][j] > 1000000007){
                        map[i][j] = map[i][j] % 1000000007;
                    }
                }

            }
        }
        answer = map[m-1][n-1];
        return answer;
    }
}
