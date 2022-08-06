package programmers.level1;

public class DividedOneNum {
    public static void main(String[] args) {
        DividedOneNum don = new DividedOneNum();
        System.out.println(don.solution(10));
        System.out.println(don.solution(12));
    }

    public int solution(int n) {
        int answer = 0;

        for (int i = 2; i < n; i++) {
            if(n%i == 1){
                answer = i;
                break;
            }
        }

        return answer;
    }
}
