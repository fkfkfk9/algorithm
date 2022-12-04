package programmers.level2;

public class NumberShow {
    public static void main(String[] args) {
        NumberShow ns = new NumberShow();
        System.out.println(ns.solution(15));
    }

    public int solution(int n) {
        //본인은 항상 포함되므로 1로시작
        int answer = 1;

        for (int i = 1; i <= n/2; i++) {
            int sum = 0;
            int grow = 0;
            while(sum < n){
                sum += i+grow;
                grow++;
            }
            if(sum == n) answer++;
        }

        return answer;
    }
}
