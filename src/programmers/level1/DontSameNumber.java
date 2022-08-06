package programmers.level1;

import java.util.*;

public class DontSameNumber {
    public static void main(String[] args) {
        DontSameNumber dsn = new DontSameNumber();
        System.out.println(Arrays.toString(dsn.solution(new int[]{1,1,3,3,0,1,1})));
        System.out.println(Arrays.toString(dsn.solution(new int[]{4,4,4,3,3})));
        System.out.println(Arrays.toString(dsn.solution2(new int[]{1,1,3,3,0,1,1})));
        System.out.println(Arrays.toString(dsn.solution2(new int[]{4,4,4,3,3})));
    }

    public int[] solution(int []arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int answerLen = 0;

        for (int i:arr) {
            if(map.containsKey(answerLen)){
                if(map.get(answerLen) != i) map.put(++answerLen,i);
            }else{
                map.put(answerLen,i);
            }
        }

        return map.values().stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution2(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i:arr){
            if(stack.empty()) stack.push(i);
            else if(stack.peek() != i) stack.push(i);
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
