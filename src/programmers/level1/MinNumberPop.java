package programmers.level1;

import java.util.*;
import java.util.stream.*;

public class MinNumberPop {
    public static void main(String[] args) {
        MinNumberPop mnp = new MinNumberPop();
        System.out.println(Arrays.toString(mnp.ArrayPopMinNumber(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(mnp.ArrayPopMinNumber(new int[]{23,13,22,11,51,21,33,35,12,45,1,7,34,77,99})));
        System.out.println(Arrays.toString(mnp.ArrayPopMinNumber(new int[]{10})));
    }

    public int[] ArrayPopMinNumber(int[] arr) {
        if(arr.length <= 1) return new int[]{-1};
        else return IntStream.of(arr).boxed().filter(i -> i > IntStream.of(arr).min().orElse(-1)).mapToInt(num->num).toArray();
    }
}
