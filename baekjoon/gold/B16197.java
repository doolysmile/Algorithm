package git.Algorithm.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16197 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        /*
        o => 1
        . => 0
        # => -1
         */
        int[][] map = new int[N][M];
        Queue<Coin> q = new LinkedList<>();
        Coin coins = new Coin();
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split("");
            for(int j = 0; j < M; j++){
                if(input[j].equals("#")){
                    map[i][j] = -1;
                }
                else if(input[j].equals(".")){
                    map[i][j] = 0;
                }
                else{
                    map[i][j] = 1;
                    coins.add(i, j);
                }
            }
        }
        q.add(coins);
        while (!q.isEmpty()){
            Coin tempCoin = q.poll();
            if(tempCoin.time >= 10){
                System.out.println(-1);
                return;
            }
            for(int i = 0; i < 4; i++){
                boolean isFalling1 = false;
                boolean isFalling2 = false;
                int x1 = tempCoin.x1 + dx[i];
                int y1 = tempCoin.y1 + dy[i];
                int x2 = tempCoin.x2 + dx[i];
                int y2 = tempCoin.y2 + dy[i];
                // 1번 동전 나갔나?
                if(x1 >= N || y1 >= M || x1 < 0 || y1 < 0){
                    isFalling1 = true;
                }
                // 2번 동전 나갔나?
                if(x2 >= N || y2 >= M || x2 < 0 || y2 < 0){
                    isFalling2 = true;
                }
                // 동전 2개 중 한개만 나감
                if(isFalling1 != isFalling2){
                    System.out.println(tempCoin.time + 1);
                    return;
                }
                // 둘다 떨어짐
                if(isFalling1){
                    continue;
                }
                // 둘다 안 떨어짐
                if(!isFalling1){
                    // 둘다 벽으로 감
                    if(map[x1][y1] == -1 && map[x2][y2] == -1){
                        continue;
                    }
                    // 한 개만 벽
                    if(map[x1][y1] == -1){
                        x1 = tempCoin.x1;
                        y1 = tempCoin.y1;
                    }
                    // 한 개만 벽
                    if(map[x2][y2] == -1){
                        x2 = tempCoin.x2;
                        y2 = tempCoin.y2;
                    }
                }
                q.add(new Coin(x1, y1, x2, y2, tempCoin.time + 1));
            }

        }
        System.out.println(-1);
    }
    static class Coin{
        int x1 = -1;
        int y1 = -1;
        int x2 = -1;
        int y2 = -1;
        int time = 0;
        Coin(){

        }
        Coin(int x1, int y1, int x2, int y2, int time){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.time = time;
        }
        void add(int x, int y){
            if(this.x1 == -1){
                this.x1 = x;
                this.y1 = y;
            }
            else{
                this.x2 = x;
                this.y2 = y;
            }
        }
    }
}