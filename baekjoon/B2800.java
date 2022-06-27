package git.Algorithm.baekjoon;

import java.util.*;

public class B2800 {
    static boolean[] check;
    static Set<String> result;
    static HashMap<Integer, Integer> bracket;
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("");
        int len = input.length;

        bracket = new HashMap<>();
        result = new TreeSet<>();

        for(int i = 0; i < len; i++){
            if(input[i].equals("(") ){
                stack.push(i);
            }
            else if(input[i].equals(")")){
                bracket.put(stack.pop(), i);
            }
        }
        check = new boolean[len];
        dfs(input, 0, len, "");

        for(String tmp : result){
            System.out.println(tmp);
        }

    }
    public static void dfs(String[] input, int current, int len, String ans){
        StringBuilder sb = new StringBuilder(ans);
        int i;
        for(i =current; i < len; i++){
            if(input[i].equals("(") ){
                if(check[i] == false){
                    check[i] = true;
                    check[bracket.get(i)] = true;
                    sb.append(input[i]);
                    dfs(input, i+1, len, sb.toString());
                    sb.deleteCharAt(sb.length()-1);
                    check[i] = false;
                    check[bracket.get(i)] = false;
                }
            }
            else if(input[i].equals(")")){
                if(check[i] == true){
                    sb.append(input[i]);
                }
            }
            else{
                sb.append(input[i]);
            }
        }
        if(i == len && sb.length() != len){
            result.add(sb.toString());
        }
    }
}
