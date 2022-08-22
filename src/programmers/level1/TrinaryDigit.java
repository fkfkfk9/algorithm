package programmers.level1;

public class TrinaryDigit {
    public static void main(String[] args) {
        TrinaryDigit ts = new TrinaryDigit();
        System.out.println(ts.solution(45));
        System.out.println(ts.solution(125));
    }

    public int solution(int n) {
        int answer = 0;
        StringBuilder result = new StringBuilder();

        if(n < 3){
            answer = n;
        }else{
            while(true){
                result.append(n % 3);
                n /= 3;
                if(n<3){
                    result.append(n);
                    break;
                }
            }

            for (int i = 0; i < result.length(); i++) {
                answer += ((result.charAt(i) - '0') * Math.pow(3,result.length()-i-1));
            }
        }

        return answer;
    }
}
