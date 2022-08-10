package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B21279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] mineral = new int[N][3];

        PriorityQueue<Integer> highY = new PriorityQueue<>(Collections.reverseOrder()); // 카운트를 한 광물들 중 최대의 Y값을 위해 존재

        int ans = 0;
        for(int i = 0; i < N ; i++){
            mineral[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        // 이까지 입력

        Arrays.sort(mineral, new Comparator<int[]>() {  // X를 오름차순 정렬, 값이 같을 떄, y오름차순 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

//        for(int i = 0; i < N ; i++){
//            for(int j = 0; j < 2 ; j++){
//                System.out.print(mineral[i][j] + " ");
//            }
//            System.out.println();
//        }

        /*
            시간 초과
             y를 해결 해야함,
             어레이리스트 value가 필요가 없음
         */

        int start = 0;
        int x = 0;
        int y = 100000;
        int tmp_ans = 0;
        int cnt = 0;

        while(true){
            if(start < N){          // x값 넣는 부분
                x = mineral[start][0];
                highY.add(mineral[start][1]);
                cnt++;
                tmp_ans += mineral[start][2];
            }
            start++;
            if(start >= N){
                break;
            }
            while(start< N){    // x값이 같을 때 들어가는 부분
                if(mineral[start][0] == x && mineral[start][1] <= y){
                    highY.add(mineral[start][1]);
                    tmp_ans += mineral[start][2];
                    cnt++;
                }
                else{                   // 이 부분 떄문에 y내림차순 정렬
                    break;
                }
                start++;
            }
            if(start >= N){
                break;
            }
            if(cnt <= C){
                if(tmp_ans > ans){
                    ans = tmp_ans;
                }
            }

            while(cnt> C){
                y = highY.peek();               // y를 값을 정해주는 부분
                for(int i = 0; i < start ; i++){
                    if(mineral[i][1] >= y){     // y보다 크거나 같은 값 제거 하는 부분
                        highY.poll();
                        cnt--;
                        tmp_ans -= mineral[start][2];
                    }
                }
            }
            if(cnt <= C){
                if(tmp_ans > ans){
                    ans = tmp_ans;
                }
            }

        }
        System.out.println(ans);

    }
}
