package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// 0 - 1 배낭 문제
public class B1106 {
    static int answer;
    static int[][] priceAndPerson;
    static int[] goal;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        goal = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        priceAndPerson = new int[goal[1]][2];
        answer = 100 * 1000;
        for(int i = 0; i < goal[1]; i++){
            priceAndPerson[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Arrays.sort(priceAndPerson, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double tmp = (double)o1[1]/o1[0] - (double) o2[1]/o2[0];
                if(tmp < 0){
                    return 1;
                }
                return -1;
            }
        }
        );

        dfs(0, 0, 0);
        System.out.println(answer);
    }
    static void dfs(int priceSum, int personSum, int current){
        if(personSum >= goal[0]){
            if(priceSum < answer){
                answer = priceSum;
            }
            return;
        }
        while(personSum + priceAndPerson[current][1] < goal[0]) {
            priceSum += priceAndPerson[current][0];
            personSum += priceAndPerson[current][1];
        }
        dfs(priceSum + priceAndPerson[current][0], personSum + priceAndPerson[current][1], current);
        if(current < goal[1] - 1){
            dfs(priceSum, personSum, current + 1);
        }
    }
}
