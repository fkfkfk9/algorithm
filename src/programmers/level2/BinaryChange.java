package programmers.level2;

public class BinaryChange {
    public static void main(String[] args) {
        BinaryChange bc = new BinaryChange();
    }

    public int[] solution(String s) {
        int[] answer = new int[2];
        int zeroDelCnt = 0;
        int binaryCnt = 0;

        while(true){
            int len = s.length();
            s = s.replace("0", "");
            zeroDelCnt += len - s.length();
            binaryCnt++;
            if(s.length() == 1) break;
            else s = Integer.toBinaryString(s.length());
        }

        answer[0] = binaryCnt;
        answer[1] = zeroDelCnt;

        return answer;
    }

}


