package programmers.level2;

public class JadenCaseStr {
    public static void main(String[] args) {
        JadenCaseStr jcs = new JadenCaseStr();
        System.out.println(jcs.solution("3people    unFollowed me   "));
    }

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] arrStr = s.split(" ");
        for (String str: arrStr) {
            if(str.isEmpty()) answer.append(" ");
            else{
                char firstChar = str.charAt(0);
                answer.append(Character.toUpperCase(firstChar) + str.substring(1).toLowerCase() + " ");
            }
        }

        if (answer.length() > 0) answer = new StringBuilder(answer.substring(0, answer.length() - 1));
        else answer = new StringBuilder(s);

        if(s.length() > answer.length()){
            answer.append(s.substring(answer.length()));
        }

        return answer.toString();
    }
}
