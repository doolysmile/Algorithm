package git.Algorithm.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B17135 {
    static Node[] archers;
    static int N;
    static int M;
    static int D;
    static int ans;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        int[][] input = new int[N + 1][M];
        map = new int[N + 1][M];
        archers = new Node[3];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = Integer.MIN_VALUE;
        makeArcher(input);
        System.out.println(ans);
    }

    private static void makeArcher(int[][] input) {
        // 조합 생성
        for(int i = 0; i < M - 2; i++){
            for(int j = i + 1; j < M - 1; j++){
                for(int k = j + 1; k < M; k++){
                    for(int x = 0; x < N + 1; x++){
                        for(int y = 0; y < M; y++){
                            map[x][y] = input[x][y];
                        }
                    }
                    archers[0] = new Node(N, i);
                    archers[1] = new Node(N, j);
                    archers[2] = new Node(N, k);
                    play();
                }
            }
        }
    }


    private static void play() {
        // 움직이는 방향
        int[] dx = {-1, 0, 0};
        int[] dy = {0, 1, -1};
        int temp = 0;
        int x = N + 1;
        while(x > 0){
            x--;
            ArrayList<Node> enemy = new ArrayList<>();
            // 궁수
            for(int i = 0; i < 3; i++){
                ArrayList<Node> enemyTmp = new ArrayList<>();
                Queue<Node> q = new LinkedList<>();
                q.add(new Node(x, archers[i].y));
                int[][] isVisited = new int[N + 1][M];
                int checkDistance = Integer.MAX_VALUE;
                boolean first = true;
                while(!q.isEmpty()){
                    Node curNode = q.poll();
                    // 최단 거리가 정해지면 더 이상 탐색 할 필요 없음
                    if(isVisited[curNode.x][curNode.y] >= checkDistance){
                        continue;
                    }
                    // 첫 방향은 무조껀 위로
                    if(first){
                        int c = curNode.x - 1;
                        int r = curNode.y;
                        // 방문 할 수 있는 가 조건
                        if(0 <= c && c <= N && 0 <= r && r < M && isVisited[c][r] == 0){
                            isVisited[c][r] = isVisited[curNode.x][curNode.y] + 1;
                            // 적군이 있을때
                            if(isVisited[c][r] <= D && map[c][r] == 1){
                                checkDistance = isVisited[c][r];
                                enemyTmp.add(new Node(c, r));
                            }
                            // 적군이 없지만 방문 가능할때
                            else if(isVisited[c][r] < D && isVisited[c][r] < checkDistance){
                                q.add(new Node(c, r));
                            }
                        }
                        first = false;
                        continue;
                    }
                    // 방향
                    for(int j = 0; j < 3; j++){
                        int c = curNode.x + dx[j];
                        int r = curNode.y + dy[j];
                        if(0 <= c && c <= N && 0 <= r && r < M && isVisited[c][r] == 0){
                            isVisited[c][r] = isVisited[curNode.x][curNode.y] + 1;
                            // 적군이 있을때
                            if(isVisited[c][r] <= D && map[c][r] == 1){
                                checkDistance = isVisited[c][r];
                                enemyTmp.add(new Node(c, r));
                            }
                            // 적군이 없지만 방문 가능할때
                            else if(isVisited[c][r] < D && isVisited[c][r] < checkDistance){
                                q.add(new Node(c, r));
                            }
                        }
                    }
                }
                // 제일 왼쪽거 찾기 위한 정렬
                enemyTmp.sort(new Comparator<Node>() {
                    @Override
                    public int compare(Node o1, Node o2) {
                        return o1.y - o2.y;
                    }
                });

                if(!enemyTmp.isEmpty()){
                    enemy.add(enemyTmp.get(0));
                }
            }

            for(Node en : enemy){
                // 중복 되는 걸 한번에 쏘기 때문에 만든 조건
                if(map[en.x][en.y] == 1){
                    temp++;
                    map[en.x][en.y] = 0;
                }
            }

        }

        if(temp > ans){
            ans = temp;
        }
    }
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
/*
1 0 0 1 0 1 0 1 1 0
0 0 0 1 0 0 0 1 0 0
0 1 0 0 1 0 0 1 1 1
0 0 1 1 0 1 0 1 1 0
0 1 1 0 0 0 0 1 0 1
0 0 1 1 0 9 0 1 0 0
0 0 0 0 0 0 0 5 0 0

0 x 0 0 0 0 x 0 0 x
 */