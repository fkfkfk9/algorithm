package programmers.level2;

public class CapetLenth {
    public static void main(String[] args) {

    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int x = 0;
        int y = 0;
        // 가로는 세로와 같은경우가 최대이기 때문에 두수의 합의 제곱근 까지만 반복한다.
        while(y <= Math.sqrt(brown+yellow)){
            if(((y*y) - (2+brown/2)*y + brown + yellow) == 0){
                x = brown / 2 - y + 2;
                break;
            }
            y++;
        }

        answer[0] = x;
        answer[1] = y;

        return answer;
    }
}
