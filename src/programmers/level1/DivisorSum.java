package programmers.level1;

public class DivisorSum {
    public static void main(String[] args) {
        DivisorSum ds = new DivisorSum();

        System.out.println(ds.solution(12));
        System.out.println(ds.solution(5));
    }

    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0) answer += i;
        }
        return answer;
    }
}
