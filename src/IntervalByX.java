import java.util.Arrays;

public class IntervalByX {
    public static void main(String[] args) {
        IntervalByX ibx = new IntervalByX();
        System.out.println(Arrays.toString(ibx.solution(2,5)));
    }

    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = (long)x * (i+1);
        }

        return answer;
    }
}
