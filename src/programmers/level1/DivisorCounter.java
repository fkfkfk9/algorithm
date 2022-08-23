package programmers.level1;

public class DivisorCounter {
    public static void main(String[] args) {
        DivisorCounter dc = new DivisorCounter();
        System.out.println(dc.solution(13,17));
        System.out.println(dc.solution(24,27));
    }

    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int count = 0;
            if(i == 1) answer -= 1;
            else if(i == 2) answer += 2;
            else if(i == 3) answer += 3;
            else{
                for (int j = 1; j <= i/2; j++) {
                    if(i % j == 0) count++;
                }
                System.out.println(i + "는 " + (count+1) + "개");
                if((count+1) % 2 == 0) answer += i;
                else answer -= i;
            }
        }

        return answer;
    }
}
