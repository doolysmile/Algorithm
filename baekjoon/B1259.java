package git.Algorithm.baekjoon;
import java.util.*;
public class B1259 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        while(true) {
            int n = sc.nextInt();
            String num = Integer.toString(n);

            if(n == 0){
                break;
            }
            int L = 0;
            int R = num.length() - 1;

            while(true) {
                if(L >=R) {
                    System.out.println("yes");
                    break;
                }
                if(num.charAt(L) != num.charAt(R)) {
                    System.out.println("no");
                    break;
                }
                L++;
                R--;
            }

        }



    }
}


