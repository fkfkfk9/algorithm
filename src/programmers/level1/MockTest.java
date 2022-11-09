package programmers.level1;

import java.util.Arrays;

public class MockTest {
    public static void main(String[] args) {
        MockTest mt = new MockTest();
        System.out.println(Arrays.toString(mt.solution(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(mt.solution(new int[]{1,3,2,4,2})));
    }

    public int[] solution(int[] answers) {
        int[] answer = null;
        int oneCnt = 0;
        int twoCnt = 0;
        int threeCnt = 0;

        int[] onePetten = {1,2,3,4,5};
        int[] twoPetten = {2,1,2,3,2,4,2,5};
        int[] threePetten = {3,3,1,1,2,2,4,4,5,5};

        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == onePetten[i%5]) oneCnt++;
            if(answers[i] == twoPetten[i%8]) twoCnt++;
            if(answers[i] == threePetten[i%10]) threeCnt++;
        }

        if(oneCnt > twoCnt && oneCnt > threeCnt) answer = new int[]{1};
        else if(twoCnt > oneCnt && twoCnt > threeCnt) answer = new int[]{2};
        else if(threeCnt > oneCnt && threeCnt > twoCnt) answer = new int[]{3};
        else if(oneCnt > twoCnt && oneCnt == threeCnt) answer = new int[]{1,3};
        else if(oneCnt > threeCnt && oneCnt == twoCnt) answer = new int[]{1,2};
        else if(twoCnt > oneCnt && threeCnt == twoCnt) answer = new int[]{2,3};
        else if(oneCnt == twoCnt && oneCnt == threeCnt) answer = new int[]{1,2,3};

        return answer;
    }
}
