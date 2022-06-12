package programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class IntSort {
    public static void main(String[] args) {
        IntSort is = new IntSort();
        System.out.println(is.descSort(118372));
    }

    public long descSort(long n) {
        StringBuilder str = new StringBuilder(n + "");
        String[] arr = str.toString().split("");
        String[] result = null;

        result = Arrays.stream(arr).sorted(Comparator.reverseOrder()).toArray(String[]::new);
        str = new StringBuilder();

        for (String s : result) str.append(s);

        return Long.parseLong(str.toString());
    }

}
