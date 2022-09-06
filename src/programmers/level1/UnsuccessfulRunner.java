package programmers.level1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UnsuccessfulRunner {
    public static void main(String[] args) {
        UnsuccessfulRunner ur = new UnsuccessfulRunner();

    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for (String str:completion) {
            if(map.containsKey(str)) map.put(str, map.get(str)+1);
            else map.put(str,1);
        }
        for (String str:participant) {
            if(map.containsKey(str)) map.put(str, map.get(str)+1);
            else answer = str;
        }

        if("".equals(answer)){
            int maxNum = 0;
            String idxKey = "";
            for (String key : map.keySet()) {
                if (map.get(key) % 2 == 1 && maxNum < map.get(key)) {
                    maxNum = map.get(key);
                    idxKey = key;
                }
            }
            answer = idxKey;
        }

        return answer;
    }
}
