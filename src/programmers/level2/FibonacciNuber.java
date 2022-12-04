package programmers.level2;

import java.math.BigInteger;

public class FibonacciNuber {
    public static void main(String[] args) {
        FibonacciNuber fn = new FibonacciNuber();
        System.out.println(fn.solution(3));
        System.out.println(fn.solution(5));
    }

    public int solution(int n) {
        BigInteger answer = new BigInteger("0");
        BigInteger beforeNum = new BigInteger("0");
        BigInteger peekNum = new BigInteger("1");

        for (int i = 0; i < n-1; i++) {
            answer = beforeNum.add(peekNum);
            beforeNum = peekNum;
            peekNum = answer;
        }

        return answer.remainder(new BigInteger("1234567")).intValue();
    }
}
