package programmers.level1;

import java.util.Arrays;
import java.util.OptionalDouble;

public class ArrayAvg {
    public static void main(String[] args) {
        ArrayAvg aa = new ArrayAvg();
        int[] numArr = {1,2,3,4};
        int[] numArr2 = {5,5};
        System.out.println(aa.intArrayAvg(numArr));
        System.out.println(aa.intArrayAvg(numArr2));
    }

    public double intArrayAvg(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }
}
