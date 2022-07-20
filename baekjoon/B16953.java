package git.Algorithm.baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] input = Arrays.stream(br.readLine().split(" " ))
                .mapToLong(Long::parseLong).toArray();
        Queue<Long> q = new LinkedList<>();
        int answer = -1;
        // 연산수를 체크 하기 위한 변수
        int tmpAnswer = 1;
        q.add(input[0]);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++){
                Long tmp = q.poll();
                // 완료 조건
                if(tmp == input[1]){
                    answer = tmpAnswer;
                    q.clear();
                    break;
                }
                // 조건 1
                if(tmp*2 <= input[1]){
                    q.add(tmp*2);
                }
                // 조건 2
                if(tmp*10+1 <=input[1]){
                    q.add(tmp*10+1);
                }
            }

            tmpAnswer++;
        }
        System.out.println(answer);
    }
}
