package programmers.level1;

import java.util.Arrays;

public class StrangeWordMaking {
    public static void main(String[] args) {
        StrangeWordMaking swm = new StrangeWordMaking();
        System.out.println(swm.returnAnswer("try hello world"));
        System.out.println(swm.returnAnswer("world"));
        System.out.println(swm.returnAnswer("w      o r ld asd gffs ar scdfg wt dscgfhs wert dfgh asegsdfhsthjsth   "));
    }

    public String returnAnswer(String s) {
        StringBuilder answer = new StringBuilder();

        if(!s.contains(" ")){
            upperLowerCaseMaking(answer, s);
            answer.append(" ");
            answer.append(lastSpace(s, s));
        }else{
            String[] arr = s.split(" ");

            for (String str : arr) {
                System.out.println(str);
                upperLowerCaseMaking(answer, str);
                answer.append(" ");
            }

            answer.append(lastSpace(s, arr[arr.length-1]));
        }

        return answer.substring(0, answer.length()-1).toString();
    }

    private void upperLowerCaseMaking(StringBuilder sb, String str){
        for (int i = 0; i < str.length(); i++) {
            if(i%2 != 0) sb.append(str.substring(i, i + 1).toLowerCase());
            else sb.append(str.substring(i, i + 1).toUpperCase());
        }
    }

    private String lastSpace(String str, String lastWord){
        return str.substring(str.lastIndexOf(lastWord) + lastWord.length());
    }
}
