
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
            parent[i][0] = -1;
            if(i != 1){
                parent[i][1] = i - 1;
            }
            else{
                parent[i][1] = 1;
            }
            if(i != N){
                parent[i][2] = i + 1;
            }
            else{
                parent[i][2] = N;
            }
=======
            parent[i] = -1;
>>>>>>> main
<<<<<<< HEAD
            command[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(command[i][0] == 2){
                ans = ans + parent[findParent(command[i][1])][0] * (-1);
//                System.out.println("ans = " + ans);
=======
            int a = nextInt();
            int b = nextInt();
            if(a == 2){
                ans -= parent[findParent(b)];
>>>>>>> main
<<<<<<< HEAD
//        for(int i = 1; i <= N; i++){
//            System.out.println("parent[i] = " + parent[i][0] + " " + parent[i][1] + " " + parent[i][2]);
//        }
=======

>>>>>>> main
<<<<<<< HEAD
        parent[ele1Parent][0] += parent[ele2Parent][0];

        parent[ele2Parent][0] = ele1Parent;
=======
        if(ele1Parent == ele2Parent){
            return;
        }
        parent[ele1Parent] += parent[ele2Parent];

        parent[ele2Parent] = ele1Parent;
>>>>>>> main
<<<<<<< HEAD
    static void remove(int x, int N){
        int left = parent[x][1];
        int right = parent[x][2];
        if(left != x){
            parent[left][2] = right;
        }
        if(right != x){
            parent[right][1] = left;
        }
        parent[x][1] = 0;
        parent[x][2] = 0;
        // 중간이 끊어질 경우
        if(parent[x][0] != -1){
            parent[findParent(left)][0]++;
        }
        else if(A[left] == A[right]){
            union(left, right);
        }
        parent[x][0] = 0;


import java.io.DataInputStream;
        import java.util.Arrays;

public class Main extends FastInput {
    private static final int OUT_BOUND = -1;
    private int[] parents, arr, left, right;

    private int find(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;

        int h = parents[a]<parents[b]?a:b;
        int l = parents[a]<parents[b]?b:a;
        parents[h] += parents[l];
        parents[l] = h;
    }

    private void init(int n) {
        parents = new int[n+1];
        Arrays.fill(parents, -1);

        arr = new int[n+1];
        left = new int[n+1];
        right = new int[n+1];
    }

    private void solution() throws Exception {
        nextInt();  //throw
        int n = nextInt();
        init(n);

        for (int i = 1; i <= n; i++) {
            arr[i] = nextInt();
            if (arr[i] == arr[i-1])
                union(i-1, i);

            left[i] = i-1;
            right[i] = i+1;
        }
        left[1] = right[n] = OUT_BOUND;

        long sum = 0;
        int q = nextInt();
        while (q-->0) {
            int a = nextInt();
            int b = nextInt();
            if (a == 2) {
                sum-=parents[find(b)];
            } else {
                parents[find(b)]++;
                int lower = left[b];
                int higher = right[b];
                if (lower != OUT_BOUND && higher != OUT_BOUND && arr[lower] == arr[higher])
                    union(lower, higher);

                if (lower != OUT_BOUND)
                    right[lower] = higher;
                if (higher != OUT_BOUND)
                    left[higher] = lower;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        new Main().solution();
    }
}

class FastInput {
=======
    void remove(int x, int N){
        int leftX = left[x];
        int rightX = right[x];
//        System.out.println("parent[findParent(x)][0] = " + parent[findParent(x)][0]);
        parent[findParent(x)]++;
        if(leftX != -1 && rightX != -1 && A[leftX] == A[rightX]){
            union(leftX, rightX);
        }
        if(leftX != -1){
            right[leftX] = rightX;
        }
        if(rightX != -1){
            left[rightX] = leftX;
        }
    }
}

class Reader
{
>>>>>>> main
    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    protected static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

<<<<<<< HEAD
    protected static int nextInt() throws Exception {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
=======


    public static int nextInt() throws Exception
    {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do
        {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');

        if (neg)
            return -ret;
>>>>>>> main
        return ret;
    }

    private static byte read() throws Exception {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}