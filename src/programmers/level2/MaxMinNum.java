package programmers.level2;

public class MaxMinNum {
    public static void main(String[] args) {
        MaxMinNum mmn = new MaxMinNum();
        System.out.println(mmn.solution("1 2 3 4"));
    }

    public String solution(String s) {
        String[] arrStr = s.split(" ");
        int max = Integer.parseInt(arrStr[0]);
        int min = Integer.parseInt(arrStr[0]);

        for (int i = 0; i < arrStr.length; i++) {
            if(Integer.parseInt(arrStr[i]) > max) max = Integer.parseInt(arrStr[i]);
            if(Integer.parseInt(arrStr[i]) < min) min = Integer.parseInt(arrStr[i]);
        }

        return min + " " + max;
    }
}
