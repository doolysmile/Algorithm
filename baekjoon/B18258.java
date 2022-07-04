package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        MyQueue myQueue = new MyQueue(N);
        for(int i = 0; i< N; i++){
            String[] command = br.readLine().split(" ");
            switch (command[0]){
                case "push":
                    myQueue.push(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    sb.append(myQueue.pop() + "\n");
                    break;
                case "size":
                    sb.append(myQueue.size() + "\n");
                    break;
                case "empty":
                    sb.append(myQueue.empty() + "\n");
                    break;
                case "front":
                    sb.append(myQueue.front() + "\n");
                    break;
                case "back":
                    sb.append(myQueue.back() + "\n");
                    break;
            }
        }
        System.out.println(sb.toString());

    }

    static class MyQueue{
        private int front;
        private int back;
        private  int queueArr[];

        public MyQueue(int size){
            this.front = 0;
            this.back = -1;
            this.queueArr = new int[size];
        }
        public void push(int x){
            this.queueArr[++this.back] = x;
        }
        public int pop(){
            if(this.front > this.back){
                return -1;
            }
            return this.queueArr[this.front++];
        }
        public int size(){
            return this.back >= this.front ? this.back - this.front + 1 : 0;
        }
        public int empty(){
            if(this.front > this.back){
                return 1;
            }
            return 0;
        }
        public int front(){
            if(this.front > this.back){
                return -1;
            }
            return this.queueArr[this.front];
        }
        public int back(){
            if(this.front > this.back){
                return -1;
            }
            return this.queueArr[this.back];
        }
    }
}
