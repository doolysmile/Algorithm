package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
    풀고 맞았으나, 다시 조건을 보니 틀린 것 같은 문제
    now 
    연합 한개를 만들고 인구를 바로 이동 시킴
    refact
    연합을 다 묶고 인구를 함께 이동시킴
    
    ==> visited로 독립성을 부여했음
    
    for 문을 통해 연합을 맺는 메서드를 호출함으로 탐색 방향을 2방향으로 해도 된다고 생각함
    but 안됨 4방향 다 탐색 해야함
    
    ==> 각 숫자 끼리 연합임
    1 1 1 1
    1 1 1 0
    0 0 0 0     이면 map[1][3]은 아래 방향 후 왼쪽 방향으로 가야함으로 4방향을 다 추가 해야함
 */
public class B16234 {
    static int N;
    static List<Node> union;
    static int L;
    static int R;
    static int[][] map;
    static boolean[][] visited;
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        Queue<Node> q = new LinkedList<>();
        int ans = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // ====위에 까지 입력====
        while(true){

            visited = new boolean[N][N];
            boolean stop = false;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(visited[i][j] == false){
                        makeUnion(i,j);
                        if(union.size() > 1){
                            stop = true;
                            movePerson();
                        }
                    }
                }
            }
            if(stop){
                ans++;
            }
            else{
                break;
            }
        }
        System.out.println(ans);

    }

    private static void movePerson() {
        int div = sum / union.size();
        for(Node node : union){
            map[node.x][node.y] = div;
        }
    }

    static void makeUnion(int x, int y){

        union = new ArrayList<>();

        int[] moveX = {1, 0, -1, 0};
        int[] moveY = {0, 1, 0, -1};
        Queue<Node> q = new LinkedList<>();
        union.add(new Node(x,y));
        q.add(new Node(x,y));
        visited[x][y] = true;
        sum = map[x][y];
        while(!q.isEmpty()){
            Node node = q.poll();
            // 수정 생각
            for(int i = 0; i < 4; i++){ // 4방향 탐색
                int nextX = node.x + moveX[i];
                int nextY = node.y + moveY[i];
                if(0 <= nextX && nextX < N && 0 <= nextY && nextY < N){
                    if(visited[nextX][nextY] == true){
                        continue;
                    }
                    int diff = Math.abs(map[nextX][nextY] - map[node.x][node.y]);
                    if(L <= diff && diff <= R){     // 연합을 만드는 조건
                        q.add(new Node(nextX, nextY));  // 연합이면 추가
                        union.add(new Node(nextX, nextY));
                        visited[nextX][nextY] = true;
                        sum += map[nextX][nextY];
                    }
                }
            }
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
