import java.util.*;

public class StringCompress {

    public static void main(String[] args) {
        StringCompress sc = new StringCompress();
        System.out.println(sc.solution("aabbaccc")); //2a2ba3c -> 7
        System.out.println(sc.solution("ababcdcdababcdcd")); // 2ababcdcd -> 9
        System.out.println(sc.solution("abcabcdede")); // 2abcdede -> 8
        System.out.println(sc.solution("abcabcabcabcdededededede")); // 2abcabc2dedede -> 14
        System.out.println(sc.solution("xababcdcdababcdcd"));  // X -> 17
    }

    public int solution(String s) {
        String answer = "";
        List<String> list = new ArrayList<String>();

        //1개 단위로 짜르는 경우부터 최대의 경우인 절반으로 자르는 경우까지 반복시킨다.
        for (int i = 1; i <= s.length()/2; i++) {
            int beginIndex = 0;
            int lastIndex = 0;
            StringBuilder compressStr = new StringBuilder();
            List<String> pieceList = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();

            while(lastIndex+i <= s.length()){
                lastIndex += i;
                pieceList.add(s.substring(beginIndex, lastIndex));
                beginIndex += i;
            }

            if(lastIndex < s.length()) compressStr.append(s.substring(lastIndex));

            for (int j = 0; j < pieceList.size()-1; j++) {
                if(pieceList.get(j).equals(pieceList.get(j+1))){
                    map.put(pieceList.get(j), map.getOrDefault(pieceList.get(j)+1, 2));
                }else{
                    if(j == 0) map.put(pieceList.get(j), 1);
                    if(map.containsKey(pieceList.get(j+1))) compressStr.append(pieceList.get(j+1));
                    else map.put(pieceList.get(j+1), 1);
                }
            }

            for (String key:map.keySet()) {
                if(map.get(key) > 1) compressStr.append(map.get(key)).append(key);
                else compressStr.append(key);
            }
            list.add(String.valueOf(compressStr));
        }
        // 메서드 참조를 사용하여 정렬
        list.sort(Comparator.comparing(String::length));
        // 정렬되었기 때문에 0번쨰가 가장 짧다.
        answer = list.get(0);
        return answer.length();
    }
}
