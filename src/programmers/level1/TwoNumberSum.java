package programmers.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoNumberSum {
    public static void main(String[] args) {
        TwoNumberSum tns = new TwoNumberSum();
        System.out.println(Arrays.toString(tns.solution(new int[]{2,1,3,4,1})));
        System.out.println(Arrays.toString(tns.solution(new int[]{5,0,2,7})));
    }

    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i]+numbers[j]);
            }
        }

        return set.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}
