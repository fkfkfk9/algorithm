package programmers.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ActiveWear {
    public static void main(String[] args) {
        ActiveWear aw = new ActiveWear();
        System.out.println(aw.solution(5,new int[]{2,4}, new int[]{1,3,5}));
        System.out.println(aw.solution(5,new int[]{2,4}, new int[]{3}));
        System.out.println(aw.solution(3,new int[]{3}, new int[]{1}));
        System.out.println(aw.solution(5,new int[]{2,3}, new int[]{3,4}));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        int borrow = 0;
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for (int lostN:lost) {
            lostSet.add(lostN);
        }
        for (int reserveN:reserve) {
            reserveSet.add(reserveN);
        }

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int lostN:lost) {
            if(!reserveSet.contains(lostN)){
                for (int reserveN:reserve) {
                    if(!lostSet.contains(reserveN) && (lostN + 1 == reserveN || lostN - 1 == reserveN)){
                        lostSet.add(reserveN);
                        borrow++;
                        break;
                    }
                }
            }else borrow++;
        }
        return answer + borrow;
    }
}
