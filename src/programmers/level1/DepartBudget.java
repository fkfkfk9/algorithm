package programmers.level1;

import java.util.Arrays;

public class DepartBudget {
    public static void main(String[] args) {
        DepartBudget db = new DepartBudget();
        System.out.println(db.solution(new int[]{1,3,2,5,4},9));
        System.out.println(db.solution(new int[]{2,2,3,3},10));
    }

    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;

        Arrays.sort(d);
        for (int j : d) {
            if (sum + j <= budget) {
                sum += j;
                answer++;
            } else break;
        }

        return answer;
    }
}

