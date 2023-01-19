package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B16496 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        String[] input = new String[N];
        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();
        Number[] numbers = new Number[N];
        for(int i = 0; i < N; i++){
            input[i] = st.nextToken();
            if(input[i].length() > max){
                max = input[i].length();
            }
        }
        for(int i = 0; i < N; i++){
            sb = new StringBuilder();
            int mul = max/input[i].length() + 1;
            for(int j = 0; j < mul; j++){
                sb.append(input[i]);
            }
            String temp = sb.substring(0, max);
            numbers[i] =  new Number(input[i], temp, input[i].length());
        }
        sb = new StringBuilder();
        Arrays.sort(numbers, new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                if(o2.make.compareTo(o1.make) != 0){
                    return o2.make.compareTo(o1.make);
                }
                else{
                    return (o2.raw + o1.raw).compareTo(o1.raw + o2.raw);
                }
            }
        });
        for(int i = 0; i < N; i++){
            sb.append(numbers[i].raw);
        }
        if(sb.toString().charAt(0) == '0'){
            sb = new StringBuilder();
            sb.append(0);
        }
        System.out.println(sb);
    }
}
class Number {
    String raw;
    String make;
    int len;

    Number(String raw, String make, int len){
        this.raw = raw;
        this.make = make;
        this.len = len;
    }
}