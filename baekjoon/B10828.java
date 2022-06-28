package git.Algorithm.baekjoon;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class B10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        MyStack myStack = new MyStack(n);
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push":
                    myStack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(myStack.pop() + "\n");
                    break;
                case "size":
                    sb.append(myStack.size() + "\n");
                    break;
                case "empty":
                    sb.append(myStack.empty() + "\n");
                    break;
                case "top":
                    sb.append(myStack.top() + "\n");
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static class MyStack{
        private int peek;
        private int stackArr[];
        public MyStack(int size){
            this.peek = -1;
            this.stackArr = new int[size];
        }
        public void push(int x){
            this.stackArr[++peek] = x;
        }

        public int pop(){
            if(peek == -1){
                return -1;
            }
            return this.stackArr[peek--];
        }
        public int size(){
            return peek + 1;
        }
        public int empty(){
            if(peek == -1){
                return 1;
            }
            return 0;
        }
        public int top(){
            if(peek == -1){
                return -1;
            }
            return this.stackArr[peek];
        }

    }
    /*
    기존 스택을 이용해서 푼 부분 직접 만들어서 푼게 2배 이상 빨라졌음
     */
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int line = Integer.parseInt(sc.nextLine());
//        Stack<String> stack = new Stack<>();
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < line; i++){
//            String[] command = sc.nextLine().split(" ");
//            if(command[0].equals("push")){
//                stack.push(command[1]);
//            }
//            else if(command[0].equals("pop")) {
//                if(stack.isEmpty()){
//                    sb.append("-1\n");
//                }
//                else{
//                    sb.append(stack.pop()+"\n");
//                }
//            }
//            else if(command[0].equals("size")){
//                sb.append(stack.size() + "\n");
//            }
//            else if(command[0].equals("empty")){
//                if(stack.empty()){
//                    sb.append("1\n");
//                }
//                else {
//                    sb.append("0\n");
//                }
//            }
//            else if(command[0].equals("top")){
//                if(stack.isEmpty()){
//                    sb.append("-1\n");
//                }
//                else{
//                    sb.append(stack.peek() + "\n");
//                }
//            }
//        }
//        System.out.println(sb);
//    }

}
