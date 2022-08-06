package programmers.level1;

public class RideUseCal {
    public static void main(String[] args) {
        RideUseCal ruc = new RideUseCal();
        System.out.println(ruc.solution(3,20,4));
    }

    public long solution(int price, int money, int count) {
        long answer = 0;

        for (int i = 0; i < count; i++) {
            answer += (long) price * (i+1);
        }

        if(money - answer >= 0) answer = 0;
        else answer = (money - answer) * -1;

        return answer;
    }
}
