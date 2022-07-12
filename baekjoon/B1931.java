package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class B1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> meeting = new ArrayList<>();
        int answer = 0;
        int lastTime = 0;
        for(int i = 0; i < N ; i++){
            meeting.add(Arrays.stream(br.readLine().split(" "))
                    .mapToInt(a -> Integer.parseInt(a))
                    .toArray());
        }
        Collections.sort(meeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }
        });
        for(int[] tmp : meeting){
            if(tmp[0] >= lastTime){
                lastTime = tmp[1];
                answer++;
            }
        }
        System.out.println(answer);
    }
}
