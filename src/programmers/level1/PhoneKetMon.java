package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class PhoneKetMon {
    public static void main(String[] args) {
        PhoneKetMon pkm = new PhoneKetMon();
    }

    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i:nums) {
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        if(map.size() == nums.length/2) answer = nums.length/2;
        else answer = map.size();

        return answer;
    }
}
