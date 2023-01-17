package git.Algorithm.baekjoon;
import java.io.DataInputStream;


public class B15352 extends Reader{
    // 부모노드, 병합된 갯수
    private int[] parent, left, right, A;

    public static void main(String[] args) throws Exception {
        initFI();
        new B15352().solution();
    }
    public void solution() throws Exception {
        long ans = 0;
        // K : 팬 클럽 수, N : 팬 수
        nextInt();
        int N = nextInt();
        // 팬의 팬 클럽
        // 부모 값 -1로 초기화
        // 왼쪽
        // 오른쪽
        A = new int[N + 1];
        parent = new int[N + 1];
        left = new int[N + 1];
        right = new int[N + 1];
        for(int i = 1; i <= N; i++){
            parent[i] = -1;
        }

        for(int i = 1; i <= N; i++){
            A[i] = nextInt();
            if(A[i - 1] == A[i]){
                union(i - 1, i);
            }
            left[i] = i - 1;
            right[i] = i + 1;
        }
        left[1] = right[N] = -1;
        // 명령어 수
        int Q = nextInt();
        // 명령어
        for(int i = 0; i < Q; i++){
            int a = nextInt();
            int b = nextInt();
            if(a == 2){
                ans -= parent[findParent(b)];
            }
            else{
//                System.out.println("command = " + command[1]);
                remove(b, N);
            }
        }

        System.out.print(ans);
    }
    int findParent(int x){
        if(parent[x] < 0){
            return x;
        }
        else {
            return findParent(parent[x]);
        }
    }
    void union(int ele1, int ele2){
        int ele1Parent = findParent(ele1);
        int ele2Parent = findParent(ele2);
        if(ele1Parent == ele2Parent){
            return;
        }
        parent[ele1Parent] += parent[ele2Parent];

        parent[ele2Parent] = ele1Parent;
    }
    // 연속 되 있는 거 삭제 할 경우
    // 삭제 시 양옆 연결될 경우
    // 삭제 하는 게 부모일 경우 인덱스 보다 큰 거 작은 거 나눠서 계산
    // 한번에 계산 할수는 없나?
    // 121 2차원 배열 양옆을 알게 하고 지웠을 때 연결?
    // 갯수 파악은 어떻게 해야하나
    // 부모는 그대로 하고 오른쪽 값을 설정?
    /*

     */
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
    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    protected static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }



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