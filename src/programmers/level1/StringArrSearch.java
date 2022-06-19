package programmers.level1;

public class StringArrSearch {
    public static void main(String[] args) {
        StringArrSearch sas = new StringArrSearch();
        System.out.println(sas.searchKim(new String[]{"Jane","Kim"}));
    }

    public String searchKim(String[] seoul) {
        String answer = "";
        for (int i = 0; i < seoul.length; i++) {
            if("Kim".equals(seoul[i])) {
                answer = "김서방은 " + i + "에 있다";
                //프로그래머스 보고 추가 정답을 찾을때는 break를 생활화해야
                break;
            }
        }
        return answer;
    }
}
