package git.Algorithm.programmers.lv2;

import java.math.BigInteger;

public class FineSquare {

    public long solution(int w, int h) {
        long answer = 1;
        long div = 1;
        long smallW = 0;
        long smallH = 0;
        for(int i = w; i > 0; i--){
            if(w % i == 0 && h % i == 0){
                div = i;
                break;
            }
        }
        smallW = w/div;
        smallH = h/div;
        answer = (long)w*h - (smallW + smallH - 1)*div;

        return answer;
    }

    //BigInteger Class의 메서드를 이용하여 GCD구하는 법
    private static int gcdThing(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }
}
