package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class PersonalityTypeTest {
    public static void main(String[] args) {
        PersonalityTypeTest ptt = new PersonalityTypeTest();
    }

    public String solution(String[] survey, int[] choices) {
        //성격유형을 체크하기 위한 맵
        //앞의 Integer에는 지표번호가 뒤의 Integer에는 점수가 들어간다.
        //한쪽점수는 음수로 한쪽은 양수로 하여 최종 점수에 따라 성격 유형 판단
        Map<Integer,Integer> typeMap = new HashMap<>();
        typeMap.put(1,0);
        typeMap.put(2,0);
        typeMap.put(3,0);
        typeMap.put(4,0);
        String answer = "";

        for (int i = 0; i < survey.length; i++) {
            //이번 정답이 4라면 더 이상 반복 시킬 필요가 없다.
            //4보다 크다면 오른쪽 문자를 작다면 왼쪽 문자를 가져와 점수를 올려주면 된다.
            String choiceChar = "";
            if(choices[i] > 4) choiceChar = survey[i].substring(1,2);
            else if(choices[i] == 4) continue;
            else choiceChar = survey[i].substring(0,1);

            switchTypeCal(typeMap,choiceChar,choices[i]);
        }

        if(typeMap.get(1) < 0) answer = "R";
        else if(typeMap.get(1) > 0) answer = "T";
        else answer = "R";

        if(typeMap.get(2) < 0) answer += "C";
        else if(typeMap.get(2) > 0) answer += "F";
        else answer += "C";

        if(typeMap.get(3) < 0) answer += "J";
        else if(typeMap.get(3) > 0) answer += "M";
        else answer += "J";

        if(typeMap.get(4) < 0) answer += "A";
        else if(typeMap.get(4) > 0) answer += "N";
        else answer += "A";

        return answer;
    }
    //들어오는 문자와 체크한 정답에 따라 점수 계산
    private void switchTypeCal(Map<Integer,Integer> map, String typeChar, int choice){
        //4에서 선택한 답변을 뺸 후 절대 값을 취하면 그게 곧 점수
        switch (typeChar){
            case "R" : map.put(1,map.get(1) - Math.abs(4-choice));
                break;
            case "T" : map.put(1,map.get(1) + Math.abs(4-choice));
                break;
            case "C" : map.put(2,map.get(2) - Math.abs(4-choice));
                break;
            case "F" : map.put(2,map.get(2) + Math.abs(4-choice));
                break;
            case "J" : map.put(3,map.get(3) - Math.abs(4-choice));
                break;
            case "M" : map.put(3,map.get(3) + Math.abs(4-choice));
                break;
            case "A" : map.put(4,map.get(4) - Math.abs(4-choice));
                break;
            case "N" : map.put(4,map.get(4) + Math.abs(4-choice));
                break;
        }
    }
}
