package programmers.level1;

import java.util.function.Function;

public class EvenOdd {
    public static void main(String[] args) {
        EvenOdd ed = new EvenOdd();
        System.out.println(ed.detterminEvenOdd(3));
        System.out.println(ed.detterminEvenOdd(4));
    }

    public String detterminEvenOdd(int num) {
        return num % 2 == 0 ? "Even":"Odd";
    }
}
