package git.Algorithm.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class B2504 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("");
        int index = 0;
        int answer = 0;
        int mul = 1;
        while(true){
            String tmp = input[index];
            if(tmp.equals(")")){
                if(!stack.isEmpty()&& input[index-1].equals("(")){
                    stack.pop();
                    answer += mul;
                    mul /= 2;
                }
                else if(!stack.isEmpty()&& stack.peek().equals("(") ){
                    stack.pop();
                    mul /= 2;
                }
                else{
                    answer = 0;
                    break;
                }
            }
            else if(tmp.equals("]")){
                if(!stack.isEmpty()&& input[index-1].equals("[")){
                    stack.pop();
                    answer += mul;
                    mul /= 3;
                }
                else if(!stack.isEmpty()&& stack.peek().equals("[")){
                    stack.pop();
                    mul /=3;
                }
                else{
                    answer = 0;
                    break;
                }

            }
            else if(tmp.equals("(")){
                stack.push(tmp);
                mul *= 2;
            }
            else if(tmp.equals("[")){
                stack.push(tmp);
                mul *= 3;
            }
            index++;
            if(index == input.length){
                if(!stack.isEmpty()){
                    answer = 0;
                }
                break;
            }

        }
        System.out.println(answer);
    }
}
