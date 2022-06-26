package git.Algorithm.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class B1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();
        int num = 1;
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[line];
        for(int i = 0 ; i < line; i++){
            arr[i] = sc.nextInt();
        }
        while(index < line){
            if(stack.isEmpty()){
                stack.push(num++);
                sb.append("+\n");
            }
            if(arr[index] == stack.peek()){
                stack.pop();
                sb.append("-\n");
                index++;
            }
            else if(arr[index] < stack.peek()){
                stack.pop();
                sb.append("-\n");
            }
            else if(arr[index] > stack.peek()){
                stack.push(num++);
                sb.append("+\n");
            }
            if(num > line + 1){
                break;
            }
        }
        if(num == line + 1){
            System.out.println(sb);
        }
        else{
            System.out.println("NO");
        }
    }
}
