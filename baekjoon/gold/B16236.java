package git.Algorithm.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B16236 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        // 움직일 방향
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Node cur = null;
        // 초기 상어 사이즈
        int size = 2;
        int ans = 0;
        // 먹은 먹이 수 사이즈 별로 초기화
        int food = 0;
        // 입력
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                // 이동시 조건 확인을 위해 상어 자리만 표시 후 0으로 바꿈
                if(map[i][j] == 9){
                    cur = new Node(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }
        while(true){
            // 방문 했는가 확인
            int[][] isVisited = new int[N][N];
            Queue<Node> q = new LinkedList<>();
            LinkedList<Node> canEat = new LinkedList<>();
            int checkTime = Integer.MAX_VALUE;
            // 상어의 위치
            q.add(cur);
            cur.time = 0;
            isVisited[cur.x][cur.y] = Integer.MAX_VALUE;
            while(!q.isEmpty()){
                Node temp = q.poll();
                int time = temp.time + 1;
                // 먹이를 찾았으면 그 먹이보다 오래 걸리는 곳은 탐색 안하기 위해
                if(time > checkTime){
                    break;
                }
                // 상하좌우 탐색
                for(int i = 0; i < 4; i++){
                    int x = temp.x + dx[i];
                    int y = temp.y + dy[i];
                    if(0 <= x && x < N && 0 <= y && y < N && isVisited[x][y] == 0){
                        // 먹을 수 있는 먹이
                        if(map[x][y] < size && map[x][y] != 0){
                            // 먹을 수 있는 배열에 추가
                            checkTime = time;
                            canEat.add(new Node(x, y, time));
                        }
                        // 지나갈 수 있는 곳 q에 넣어줌
                        else if(map[x][y] <= size){

                            q.add(new Node(x, y, time));
                        }
                        // 방문한 곳에 시간 기록
                        isVisited[x][y] = time;
                    }
                }
            }
            // 먹을 수 있는 먹이가 없을때 종료
            if(canEat.isEmpty()){
                break;
            }
            // 정렬 : 위쪽, 그 다음 왼쪽이 우선 순위
            Collections.sort(canEat, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if(o1.x == o2.x){
                        return o1.y - o2.y;
                    }
                    return o1.x - o2.x;
                }
            });
            // 먹었으면 food를 증가 시키고 값에 따라 상어 몸집도 증가 시킴
            cur = canEat.get(0);
            ans += isVisited[cur.x][cur.y];
            food++;
            map[cur.x][cur.y] = 0;
            if(food == size){
                food = 0;
                size++;
            }
        }
        System.out.print(ans);
    }
    static class Node{
        int x;
        int y;
        int time;
        Node(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
//    static class Shark{
//        int size;
//        int x;
//        int y;
//        int food;
//        int time;
//        Shark(int x, int y){
//            this.size = 2;
//            this.x = x;
//            this.y = y;
//            this.food = 0;
//            this.time = 0;
//        }
//        void eat(){
//            food++;
//            if(size == food){
//                size++;
//                food = 0;
//            }
//        }
//    }
}