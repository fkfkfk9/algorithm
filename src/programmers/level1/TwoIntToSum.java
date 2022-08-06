package programmers.level1;

public class TwoIntToSum {
    public static void main(String[] args) {
        TwoIntToSum tits = new TwoIntToSum();
        System.out.println(tits.aTobSum(3,5));
        System.out.println(tits.aTobSum(3,3));
        System.out.println(tits.aTobSum(5,3));
    }

    public long aTobSum(int a, int b) {
        long answer = 0;
        if(Integer.compare(a,b)>0){
            int temp = a;
            a = b;
            b = temp;
        }
        for (int i = a; i <= b; i++) {
            answer += i;
        }
        return answer;
    }
}
