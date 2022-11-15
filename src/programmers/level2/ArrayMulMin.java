package programmers.level2;

import java.util.Arrays;
import java.util.Collections;

public class ArrayMulMin {
    public static void main(String[] args) {

    }

    public int solution(int []A, int []B)
    {
        int answer = 0;
        Integer[] arrB = new Integer[B.length];

        for(int i = 0; i < A.length; i++){
            arrB[i] = B[i];
        }

        Arrays.sort(A);
        Arrays.sort(arrB, Collections.reverseOrder());

        for(int i = 0; i < A.length; i++){
            answer += A[i] * arrB[i];
        }

        return answer;
    }
}
