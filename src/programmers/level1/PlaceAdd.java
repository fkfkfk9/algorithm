package programmers.level1;

import java.util.Arrays;

public class PlaceAdd {
    public static void main(String[] args) {
        PlaceAdd pa = new PlaceAdd();
        System.out.println(pa.returnAnswer(123));
        System.out.println(pa.returnAnswer(987));
    }

    public int returnAnswer(int n) {
        String str = n + "";
        return Arrays.stream(str.split("")).mapToInt(Integer::parseInt).sum();
    }
}
