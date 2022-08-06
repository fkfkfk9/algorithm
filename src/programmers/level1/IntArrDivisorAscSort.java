package programmers.level1;

import java.util.*;

public class IntArrDivisorAscSort {
    public static void main(String[] args) {

    }

    public int[] solution(int[] arr, int divisor) {
        int[] answer = null;
        List<Integer> list = new ArrayList<>();
        for (int j : arr) {
            if (j % divisor == 0) list.add(j);
        }
        answer = list.stream().filter(i->i%divisor==0).sorted().mapToInt(Integer::intValue).toArray();

        return answer.length == 0 ? new int[]{-1}:answer;
    }
}
