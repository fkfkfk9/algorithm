package programmers.level2;

import java.util.ArrayDeque;

public class SameNumbersRemove {
    public static void main(String[] args) {
        SameNumbersRemove snr = new SameNumbersRemove();
        System.out.println(snr.solution("baabaa"));
        System.out.println(snr.solution("cdcd"));
    }

    public int solution(String s)
    {
        int answer = 0;
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] arr = s.split("");
        if(s.length() > 0) stack.addLast(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if(stack.size() > 0 && stack.getLast().equals(arr[i])) stack.removeLast();
            else stack.addLast(arr[i]);
        }

        if(stack.size() == 0) answer = 1;

        return answer;
    }
}
