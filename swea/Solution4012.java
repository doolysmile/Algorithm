package git.Algorithm.swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution4012 {
    // 재료 2개를 더한 연산을 담는 맵
    static Map<Integer, Integer> map;
    static int N;
    // 만들어진 재료
    static int[] ingredient;
    static int ans;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] input;
        for(int t = 1; t <= T; t++){
            // 입력을 받는 부분
            ans = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            input = new int[N][N];
            map = new HashMap<>();
            // 만들어진 재료를 넣는 배열
            ingredient = new int[N/2];
            isVisited = new boolean[N];
            for(int i = 0; i < N; i++){
                input[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            for(int i = 0; i < N - 1; i++){
                for(int j = i + 1; j < N; j++){
                    // 맵에 키값으로 i j 로 만들 수 있는 유일한 값을 만들기 위해 i * N + j 연산
                    map.put(i*N + j, input[i][j] + input[j][i]);
                }
            }
            // dfs 함수 호출
            dfs(-1, 0);
            sb.append("#" + t + " " + ans + "\n");
        }
        System.out.print(sb.toString());
    }
    // 재료 배열 생성
    private static void dfs(int cur, int depth) {
        // 종료 조건
        if(depth == N/2){
            int temp = Math.abs(makeDiff());
            if(temp < ans){
                ans = temp;
            }
            return;
        }
        // TODO : 최적화 필요하긴 함, set을 써 반대쪽에 안 만들어진 거 넣으면 연산 반으로 줆
        for(int i = cur + 1; i < N; i++){
            ingredient[depth] = i;
            // 반대 재료를 만들기 위한 방문 여부 체크
            isVisited[i] = true;
            dfs(i, depth + 1);
            isVisited[i] = false;
        }
    }
    // 재료로 만든 2 요리의 차이를 구하는 메서드
    private static int makeDiff() {
        int[] newIngredient = new int[N/2];
        int index = 0;
        // 방문 여부를 활용해 반대편 재료 생성, 여기서 set에 넣는 거 추가하면 좋을듯
        for(int i = 0; i < N; i++){
            if(!isVisited[i]){
                newIngredient[index++] = i;
            }
        }
        int now = 0;
        int opposite = 0;
        for(int i = 0; i < N/2 -1; i++){
            for(int j = i + 1; j < N/2; j++){
                // 재료 계산
                now += map.get(ingredient[i]*N + ingredient[j]);
                opposite += map.get(newIngredient[i]*N + newIngredient[j]);
            }
        }
        return now - opposite;
    }

}