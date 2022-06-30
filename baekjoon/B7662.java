package git.Algorithm.baekjoon;

import java.io.*;
import java.util.*;

public class B7662 {
    public static void main(String[] args) throws IOException {
        TreeMap<Integer,Integer> Q;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int k = Integer.parseInt(br.readLine());
            Q = new TreeMap<>();
            for(int j = 0; j < k; j++){
                String[] op = br.readLine().split(" ");
                int num = Integer.parseInt(op[1]);
                if(op[0].equals("I")){
                    Q.put(num, Q.getOrDefault(num, 0) + 1);
                }
                else if(op[0].equals("D") &&  Q.size() != 0){
                    if(num == 1){
                        int tmp = Q.lastKey();
                        if(Q.get(tmp) > 1){
                            Q.put(tmp, Q.getOrDefault(tmp, 0) - 1);
                        }
                        else{
                            Q.pollLastEntry();
                        }
                    }
                    else if(num == -1){
                        int tmp = Q.firstKey();
                        if(Q.get(tmp) > 1){
                            Q.put(tmp, Q.getOrDefault(tmp, 0) - 1);
                        }
                        else{
                            Q.pollFirstEntry();
                        }
                    }
                }
            }
            if(Q.size() != 0){
                sb.append(Q.lastKey() +" " +  Q.firstKey() + "\n");
            }
            else {
                sb.append("EMPTY\n");
            }
        }
        System.out.println(sb.toString());
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PriorityQueue<Integer> minQueue;
//        PriorityQueue<Integer> maxQueue;
//        HashMap<Integer,Integer> map;
//        int T = Integer.parseInt(br.readLine());
//        for(int i = 0; i < T; i++){
//            int Q = Integer.parseInt(br.readLine());
//            minQueue = new PriorityQueue<>();
//            maxQueue = new PriorityQueue<>((a,b)-> b-a);
//            map = new HashMap<>();
//            for(int j = 0; j < Q; j++){
//                String[] line = br.readLine().split(" ");
//                if(line[0].equals("I")){
//                    int tmp = Integer.parseInt(line[1]);
//                    minQueue.offer(tmp);
//                    maxQueue.offer(tmp);
//                    map.put(tmp, map.getOrDefault(tmp, 0) + 1);
//                }
//                else if(line[0].equals("D")){
//                    if(line[1].equals("1")){
//                        if (maxQueue.size() > 0) {
//                            if(map.get(maxQueue.peek())> 0){
//                                int temp = maxQueue.poll();
//                                map.put(temp, map.get(temp) -1);
//                                if(maxQueue.size() > 0 && map.get(maxQueue.peek()) == 0){
//                                    maxQueue.clear();
//                                    minQueue.clear();
//                                }
//                            }
//                            else {
//                                maxQueue.clear();
//                                minQueue.clear();
//                                }
//                            }
//                        }
//                    else if(line[1].equals("-1")){
//                        if (minQueue.size() > 0) {
//                            if(map.get(minQueue.peek())> 0){
//                                int temp = minQueue.poll();
//                                map.put(temp, map.get(temp) -1);
//                                if(minQueue.size() > 0 && map.get(minQueue.peek()) == 0){
//                                    maxQueue.clear();
//                                    minQueue.clear();
//                                }
//                            }
//                            else {
//                                maxQueue.clear();
//                                minQueue.clear();
//                            }
//                        }
//
//
//                    }
//                }
//            }
//            if(map.get(maxQueue.peek()) == 0){
//                System.out.println("EMPTY");
//            }
//            else{
//                System.out.println(maxQueue.poll() + " " + minQueue.poll());
//            }
//        }
//
//
//    }
}
