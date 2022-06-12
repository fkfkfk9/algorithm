package programmers.level1;

public class SqrtCal {

    public static void main(String[] args) {
        SqrtCal sc = new SqrtCal();
        System.out.println(sc.sqrtGetPlus1(5));
        System.out.println(sc.sqrtGetPlus1(121));
    }

    public long sqrtGetPlus1(long n) {
        long answer = 0;
        answer = (long) Math.rint(Math.sqrt(n));
        if(answer * answer != n) answer = -1;
        else answer = (answer + 1)*(answer + 1);

        return answer;
    }
}
