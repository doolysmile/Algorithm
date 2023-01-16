package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15352 {
    // 부모노드, 병합된 갯수
    static int[][] parent;
    static int[] A;
    public static void main(String[] args) throws IOException {
        int ans = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // K : 팬 클럽 수, N : 팬 수
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        // 팬의 팬 클럽
        A = new int[N + 1];
        parent = new int[N + 1][3];
        for(int i = 1; i <= N; i++){
            parent[i][0] = -1;
            parent[i][1] = i;
            parent[i][2] = i;
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            if(i > 1 && A[i - 1] == A[i]){
                union(i - 1, i);
            }
        }
        // 명령어 수
        int Q = Integer.parseInt(br.readLine());
        // 명령어
        int[][] command = new int[Q][2];
        for(int i = 0; i < Q; i++){
            command[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(command[i][0] == 2){
                ans = ans + parent[findParent(command[i][1])][0] * (-1);
            }
            else{
                remove(command[i][1], N);
            }
        }
        for(int i = 1; i <= N; i++){
            System.out.println("parent[i] = " + parent[i][0] + " " + parent[i][1] + " " + parent[i][2]);
        }
        System.out.print(ans);
    }
    static int findParent(int x){
        if(parent[x][0] < 0){
            return x;
        }
        else {
            return findParent(parent[x][0]);
        }
    }
    static void union(int ele1, int ele2){
        int ele1Parent = findParent(ele1);
        int ele2Parent = findParent(ele2);
        parent[ele1Parent][0] += parent[ele2Parent][0];
        parent[ele2][1] = ele1;
        parent[ele1][2] = ele2;
        parent[ele2Parent][0] = ele1Parent;
    }
    // 연속 되 있는 거 삭제 할 경우
    // 삭제 시 양옆 연결될 경우
    // 삭제 하는 게 부모일 경우 인덱스 보다 큰 거 작은 거 나눠서 계산
    // 한번에 계산 할수는 없나?
    // 121 2차원 배열 양옆을 알게 하고 지웠을 때 연결?
    // 갯수 파악은 어떻게 해야하나
    // 부모는 그대로 하고 오른쪽 값을 설정?
    /*

     */
    static void remove(int x, int N){
        int xParent = findParent(x);
        parent[xParent][0]++;

        parent[x][0] = 0;
        parent[x][1] = 0;
        parent[x][2] = 0;
    }
}
