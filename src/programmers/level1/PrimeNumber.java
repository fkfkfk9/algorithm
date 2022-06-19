package programmers.level1;

public class PrimeNumber {
    public static void main(String[] args) {
        PrimeNumber pn = new PrimeNumber();
        System.out.println(pn.primeNumCntCheck(10));
        System.out.println(pn.primeNumCntCheck(5));
    }

    public int primeNumCntCheck(int n) {
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            boolean cdCheck = true;
            if(i == 2 || i == 3) {
                answer++;
                continue;
            }
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if(j <= Math.sqrt(i) && i%j == 0) {
                    cdCheck = false;
                    break;
                }
            }
            if(cdCheck) answer++;
        }

        return answer;
    }
}
