package git.Algorithm.baekjoon;

import java.io.*;
import java.util.*;

public class B1260 {

    static int[][] link;    //간선의 연결상태
    static boolean[] check; //방문 여부
    static int dot;         //정점의 수
    static int line;        //간선의 수
    static int start;       //시작 정점
    public static void main(String[] args) throws IOException {

        // (정점의수) (간선의수) (시작정점)
        Scanner sc = new Scanner(System.in);
        dot = sc.nextInt();
        line = sc.nextInt();
        start = sc.nextInt();

        link = new int[1001][1001]; //좌표를 그대로 쓰기 위해 + 1
        check = new boolean[1001];

        // 간선의 연결상태를 저장
        for(int i = 0; i < line; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            link[x][y] = link[y][x] = 1;
        }

        dfs(start);

        check = new boolean[1001];
        System.out.println();

        bfs();
    }

    // 깊이 우선탐색(DFS)
    public static void dfs(int currentDot) {
        check[currentDot] = true;
        System.out.print(currentDot + " ");

        for(int i = 1; i <= dot; i++){
            if(link[currentDot][i] == 1 && check[i] == false) {
                dfs(i);
            }
        }
    }

    // 넓이 우선탐색(BFS)
    public static void bfs() {
        // 시작점 q에 넣기
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        check[start] = true;

        // queue가 빌때까지 탐색
        while(!queue.isEmpty()){

            int tmp = queue.poll();
            System.out.print(tmp + " ");

            for(int i = 1; i <= dot; i++){
                if(link[tmp][i] == 1 && check[i] == false) {
                    queue.offer(i);
                    check[i] = true;
                }

            }
        }
    }
}


