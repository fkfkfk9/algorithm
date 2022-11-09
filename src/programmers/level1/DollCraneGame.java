package programmers.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DollCraneGame {
    public static void main(String[] args) {
        DollCraneGame dcg = new DollCraneGame();
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(dcg.solution(board,moves));
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Stack<Integer>> dollsList = new ArrayList<>();
        Stack<Integer> baguni = new Stack<>();

        //스택을 만들어줄 만큼 반복시킨다. NxN이기 때문에 어느쪽 길이든 상관없다.
        for (int i = 0; i < board.length; i++) {
            Stack<Integer> dollsStack = new Stack<>();
            //벼열은 열이지만 행만 뽑아 Stack에 넣어준다.
            for (int j = board.length-1; j > -1; j--) {
                //0은 인형이 없는것이므로 무시한다.
                if(board[j][i] > 0) dollsStack.push(board[j][i]);
            }

            dollsList.add(dollsStack);
        }

        for (int move:moves) {
            int doll = 0;
            //스택이 비워져있지 않다면 가장위의 수를 뽑는다 즉 가장 위의 인형을 뽑는다.
            if(dollsList.get(move-1).size() > 0) doll = dollsList.get(move-1).pop();
            else continue;

            //최상단 값이 같다면 제거하고 리턴할 값을 늘린다.
            if(baguni.size() > 0 && baguni.peek() == doll){
                baguni.pop();
                answer += 2;
                continue;
            }else baguni.push(doll);
        }

        return answer;
    }
}
