package git.Algorithm.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B6987 {
    // 대결을 닮을 곳
    static Match[] matches;
    static int[][] res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        matches = new Match[15];
        makeMatch();
        for(int t = 0; t < 4; t++){
            res = new int[6][3];
            st = new StringTokenizer(br.readLine());
            boolean isPossible = true;
            int win = 0;
            int lose = 0;

            for(int i = 0; i < 6; i++){
                int sum = 0;
                for(int j = 0; j < 3; j++){
                    res[i][j] = Integer.parseInt(st.nextToken());
                    sum += res[i][j];
                }
                // 각 5경기를 했는가?
                if(sum != 5){
                    isPossible =false;
                    break;
                }
                win += res[i][0];
                lose += res[i][2];
            }
            // 이긴수 진 수 같은가
            if(win != lose){
                sb.append(0 + " ");
                continue;
            }
            if (!isPossible){
                sb.append(0 + " ");
                continue;
            }
            if(dfs(0, 0)){
                sb.append(1 + " ");
                continue;
            }
            sb.append(0 + " ");
        }
        System.out.println(sb);
    }

    private static boolean dfs(int depth, int cur) {
        if(depth == 15){
            return true;
        }
        int home = matches[cur].home;
        int away = matches[cur].away;
        // 홈팀이 이긴경우
        if(res[home][0] > 0 && res[away][2] > 0){
            res[home][0]--;
            res[away][2]--;
            if(dfs(depth + 1, cur + 1)){
                return true;
            }
            res[home][0]++;
            res[away][2]++;
        }
        // 무승부
        if(res[home][1] > 0 && res[away][1] > 0){
            res[home][1]--;
            res[away][1]--;
            dfs(depth + 1, cur);
            if(dfs(depth + 1, cur + 1)){
                return true;
            }
            res[home][1]++;
            res[away][1]++;
        }
        // 홈팀이 진 경우
        if(res[home][2] > 0 && res[away][0] > 0){
            res[home][2]--;
            res[away][0]--;
            dfs(depth + 1, cur);
            if(dfs(depth + 1, cur + 1)){
                return true;
            }
            res[home][2]++;
            res[away][0]++;
        }
        return false;
    }
    // 매칭 생성
    private static void makeMatch() {
        int index = 0;
        for(int i = 0; i < 5; i++){
            for(int j = i + 1; j < 6; j++){
                matches[index++] = new Match(i, j);
            }
        }
    }
    // 어디팀이랑 어느 팀이랑 붙을지
    static class Match{
        int home;
        int away;
        Match(int home, int away){
            this.home = home;
            this.away = away;
        }
    }
}

