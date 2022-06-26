package git.Algorithm.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class B10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = Integer.parseInt(sc.nextLine());
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < line; i++){
            String[] command = sc.nextLine().split(" ");
            if(command[0].equals("push")){
                stack.push(command[1]);
            }
            else if(command[0].equals("pop")) {
                if(stack.isEmpty()){
                    sb.append("-1\n");
                }
                else{
                    sb.append(stack.pop()+"\n");
                }
            }
            else if(command[0].equals("size")){
                sb.append(stack.size() + "\n");
            }
            else if(command[0].equals("empty")){
                if(stack.empty()){
                    sb.append("1\n");
                }
                else {
                    sb.append("0\n");
                }
            }
            else if(command[0].equals("top")){
                if(stack.isEmpty()){
                    sb.append("-1\n");
                }
                else{
                    sb.append(stack.peek() + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}
