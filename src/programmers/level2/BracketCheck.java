package programmers.level2;

public class BracketCheck {
    public static void main(String[] args) {
        BracketCheck bc = new BracketCheck();

    }

    boolean solution(String s) {
        boolean answer = true;
        int openBracketCnt = 0;
        int closeBracketCnt = 0;
        char[] arr = s.toCharArray();
        if(arr[0] == ')') answer = false;
        else{
            for (char c: arr) {
                if(c == '(') openBracketCnt++;
                else if(c == ')') closeBracketCnt++;
                if(openBracketCnt < closeBracketCnt || openBracketCnt > arr.length/2) {
                    answer = false;
                    break;
                }
            }
            if(answer && openBracketCnt != closeBracketCnt) answer = false;
        }

        return answer;
    }
}
