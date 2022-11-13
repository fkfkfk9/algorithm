package programmers.level1;

import java.util.*;

public class BadUserReport {
    public static void main(String[] args) {
        BadUserReport bur = new BadUserReport();
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        //key : 신고 당한 유저, value : 신고한 유저 리스트
        Map<String, List<String>> map = new HashMap<>();
        //id만큼 배열을 만들어준다.
        int[] answer = new int[id_list.length];
        //0으로 초기화 해준다.
        for (int i:answer) i = 0;

        for (String str:report) {
            String user = str.split(" ")[0];
            String badUser = str.split(" ")[1];
            List<String> userList = null;

            if(map.containsKey(badUser)){
                userList = map.get(badUser);
                //같은 유저가 신고하지 않을 경우에만 추가해준다.
                if(!userList.contains(user)) userList.add(user);
            }else{
                //처음 신고당한 사람일 경우
                userList = new ArrayList<>();
                userList.add(user);
            }

            map.put(badUser,userList);
        }

        //map을 반복시킨다.
        for (String key : map.keySet()) {
            List<String> userList = map.get(key);
            //신고 횟수가 k번이 넘을 경우
            if(userList.size() >= k){
                for(String user : userList){
                    //id리스트에서 신고한 유저의 위치를 찾아 해당 위치의 리턴값을 1 추가해준다.
                    int idx = Arrays.asList(id_list).indexOf(user);
                    answer[idx] = answer[idx] + 1;
                }
            }
        }

        return answer;
    }
}
