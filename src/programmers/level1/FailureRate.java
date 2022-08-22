package programmers.level1;

import java.util.*;

public class FailureRate {
    public static void main(String[] args) {
        FailureRate fr = new FailureRate();
        System.out.println(Arrays.toString(fr.solution(5,new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(fr.solution(4,new int[]{4,4,4,4,4})));
        System.out.println(Arrays.toString(fr.solution(10,new int[]{2,1,2,6,2,4,6,7,11,9,3,5,1,6})));
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int totalcount = stages.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int stageCount = 0;

            for (int stage : stages) {
                if (stage == i + 1) stageCount++;
            }

            if(stageCount == 0) map.put(i+1,0);
            else{
                map.put(i+1,100 * stageCount / totalcount);
                totalcount -= stageCount;
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).getKey();
        }

        return answer;
    }
}
