package programmers.level1;

public class Collatz {
    public static void main(String[] args) {
        Collatz collatz = new Collatz();
        System.out.println(collatz.calCollatz(1));
        System.out.println(collatz.calCollatz(6));
        System.out.println(collatz.calCollatz(16));
        System.out.println(collatz.calCollatz(626331));
    }

    public int calCollatz(int num) {
        return recursionCollatz(num, 1);
    }

    private int recursionCollatz(long num, int cnt){
        if(cnt == 500) return -1;

        if(num > 1) {
            if(num % 2 == 0) num /= 2;
            else num = (num * 3) + 1;

            if(num == 1) return cnt;
            else return recursionCollatz(num, ++cnt);
        }else return 0;
    }
}
