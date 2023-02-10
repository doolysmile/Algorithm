import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2961 {
    static int ans;
    static int N;
    static boolean[] visited;
    static int[][] taste;
    public static void main(String[] args) throws IOException {
        // 입력을 받는 부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        taste = new int[N][2];
        ans = Integer.MAX_VALUE;
        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            taste[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        dfs(0 , 0, 1, 0);
        System.out.println(ans);
    }
    static void dfs(int depth, int current, int sour, int bitter){
        // 성능을 위한 부분으로 만들었으나, 없는게 더 좋을 거 같음
        if(sour - bitter == 0){
            ans = 0;
            return;
        }
        // depth가 끝에 왔을때
        if(depth == N){
            // 모든 재료를 안 쓰는 경우를 제외하기 위해서
            if(sour != 1 && bitter != 0){
                // 최솟값 계산
                ans = Math.min(ans, Math.abs(sour - bitter));
            }
            return;
        }
        // 해당 재료를 쓰는 경우
        dfs(depth + 1,current + 1, sour * taste[current][0], bitter + taste[current][1]);
        // 해당 재료를 안 쓰는 경우
        dfs(depth + 1, current+ 1, sour, bitter);
    }
}
