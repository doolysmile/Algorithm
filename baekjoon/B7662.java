package git.Algorithm.baekjoon;

import java.io.*;
import java.util.*;

public class B7662 {
    public static void main(String[] args) {
        TreeMap<Integer,Integer>
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
