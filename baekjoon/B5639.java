package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B5639 {

    static class Node {
        int num;
        Node left, right;

        Node(int num) {
            this.num = num;
        }

        Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        void insert(int n) {
            if (n < this.num) {
                if (this.left == null)
                    this.left = new Node(n);
                else this.left.insert(n);
            } else {
                if (this.right == null)
                    this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals(""))
                break;
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
    }

    static void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }

// 밑에가 내가 푼 코드 시간 초과 뜸
    
//    static Map<Integer, Node> tree;
//    static StringBuilder sb;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        Scanner sc = new Scanner(System.in);
//        tree = new HashMap<>();
//        sb = new StringBuilder();
//        int root = Integer.parseInt(br.readLine());
//        tree.put(root, new Node());
//        while(true){
//            String input = br.readLine();
//            if(input == null || input.equals("")){
//                break;
//            }
//            int newNode = Integer.parseInt(input);
//            addNode(root, newNode);
//        }
//        print(root);
//        System.out.println(sb.toString());
//    }
//    static void print(int current){
//        Node tmp = tree.get(current);
//        if(current == 0){
//            return;
//        }
//        if(tree.get(current).left != 0){
//            print(tree.get(current).left);
//        }
//        // 이상함 0일때 if문 통과?
//        if(tree.get(current).right != 0);{
//            print(tree.get(current).right);
//        }
//        sb.append(current + "\n");
//
//    }
//    static void addNode(int currentValue, int newNode){
//        Node currentNode = tree.get(currentValue);
//        if(newNode < currentValue){
//            if(currentNode.left == 0){
//                currentNode.left = newNode;
//                tree.put(newNode, new Node());
//            }
//            else{
//                addNode(currentNode.left, newNode);
//            }
//        }
//        else{
//            if(currentNode.right == 0){
//                currentNode.right = newNode;
//                tree.put(newNode, new Node());
//            }
//            else{
//                addNode(currentNode.right, newNode);
//            }
//        }
//    }
//    static class Node{
//        int left;
//        int right;
//    }
}
