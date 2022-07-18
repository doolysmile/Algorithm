package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

public class B21314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        StringBuilder ansMax = new StringBuilder();
        StringBuilder ansMin = new StringBuilder();
        int cntMax = 0;
        int cntMin = 0;
        for(int i = 0; i < input.length; i++){
            if(input[i].equals("M")){
                cntMax++;
                cntMin++;
                if(i == input.length - 1){
                    ansMax.append(1);
                    ansMin.append(1);
                    for(int j = 1; j < cntMax; j++){
                        ansMax.append(1);
                        ansMin.append(0);
                    }
                }
            }
            else if(input[i].equals("K")){
                ansMax.append(5);
                for(int j = 0; j < cntMax; j++){
                    ansMax.append(0);
                    if(j == 0){
                        ansMin.append(1);
                    }
                    else{
                        ansMin.append(0);
                    }
                }
                ansMin.append(5);
                cntMax = 0;
                cntMin = 0;
            }

        }
        System.out.println(ansMax.toString());
        System.out.println(ansMin.toString());
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = br.readLine().split("");
//        StringBuilder m = new StringBuilder();
//        StringBuilder n = new StringBuilder();
//        long max = 1;
//        long min = 1;
//        int cntM = 0;
//        for(int i = 0; i < input.length; i++){
//            if(input[i].equals("M")){
//                cntM++;
//                max *= 10;
//                min *= 10;
//                if(i == input.length - 1){
//                    for(int j = 0; j< cntM; j++){
//                        m.append("1");
//                    }
//                    min /= 10;
//                    n.append(min);
//                }
//            }
//            else{
//                max *= 5;
//                m.append(max);
//                cntM = 0;
//                max = 1;
//                if(min >= 10){
//                    min /= 10;
//                    n.append(min);
//                    n.append(5);
//
//                }
//                else{
//                    n.append(5);
//                }
//                min = 1;
//            }
//
//        }
//        System.out.println(m.toString());
//        System.out.println(n.toString());
//    }
}
