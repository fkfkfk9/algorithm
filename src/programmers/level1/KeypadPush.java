package programmers.level1;

import java.util.Stack;

public class KeypadPush {
    public static void main(String[] args) {
        KeypadPush kp = new KeypadPush();
        //System.out.println(kp.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(kp.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        //System.out.println(kp.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }

    public String solution(int[] numbers, String hand) {
        String answer = "";
        //왼손 엄지손가락 좌표를 넣어줄 스택
        Stack<Integer> lStack = new Stack<>();
        //오른손 엄지손가락 좌표를 넣어줄 스택
        Stack<Integer> rStack = new Stack<>();
        //키패드 좌표 리스트
        int[][] keypad = {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2},{3,0},{3,1},{3,2}};

        for (int number:numbers) {
            //좌표 리스트상 0은 11번쨰 이다.
            if(number == 0) number = 11;
            int lDiff = 0;
            int rDiff = 0;

            //각 왼손, 오른손, 가운데 경우로 나눈다.
            if(number == 1 || number == 4 || number == 7){
                answer += "L";
                //좌표입력
                lStack.push(number);
            }else if(number == 3 || number == 6 || number == 9){
                answer += "R";
                rStack.push(number);
            }else{
                //왼손의 거리
                //스택이 비어서 시작지점일 경우
                if(lStack.empty()) rDiff = (Math.abs(keypad[9][0] - keypad[number-1][0]) + Math.abs(keypad[9][1] - keypad[number-1][1]));
                lDiff = (Math.abs(keypad[lStack.peek()-1][0] - keypad[number-1][0]) + Math.abs(keypad[lStack.peek()-1][1] - keypad[number-1][1]));
                //오른손의 거리
                //스택이 비어서 시작지점일 경우
                if(rStack.empty()) rDiff = (Math.abs(keypad[11][0] - keypad[number-1][0]) + Math.abs(keypad[11][1] - keypad[number-1][1]));
                else rDiff = (Math.abs(keypad[rStack.peek()-1][0] - keypad[number-1][0]) + Math.abs(keypad[rStack.peek()-1][1] - keypad[number-1][1]));

                if(lDiff > rDiff){
                    answer += "R";
                    rStack.push(number);
                }else if(rDiff > lDiff){
                    answer += "L";
                    lStack.push(number);
                }else{
                    if("right".equals(hand)){
                        answer += "R";
                        rStack.push(number);
                    }else if("left".equals(hand)){
                        answer += "L";
                        lStack.push(number);
                    }
                }
            }
        }

        return answer;
    }
}
