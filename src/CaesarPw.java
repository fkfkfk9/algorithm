import java.util.Objects;

public class CaesarPw {
    public static void main(String[] args) {
        CaesarPw cp = new CaesarPw();
        System.out.println("AB : " + cp.caesarEncrypt("AB", 1));
        System.out.println("z : " + cp.caesarEncrypt("z", 1));
        System.out.println("a B z : " + cp.caesarEncrypt("a B z", 4));
    }

    public String caesarEncrypt(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < s.length();i++){
            char encrypWord = s.charAt(i);
            if(encrypWord != 32){
                String type = "";

                if(encrypWord < 91) type = "lowercase";
                else if(encrypWord > 96) type = "uppercase";

                encrypWord += n;
                encrypWord = overflowCheck(encrypWord, type);
            }

            answer.append(encrypWord);
        }

        return answer.toString();
    }

    private char overflowCheck(char encrypWord, String type){
        if(Objects.equals(type, "lowercase")){
            if(encrypWord > 90) encrypWord = (char)(encrypWord - 26);
            else return encrypWord;
        }else if(Objects.equals(type, "uppercase")){
            if(encrypWord > 122) encrypWord = (char)(encrypWord - 26);
            else return encrypWord;
        }

        return overflowCheck(encrypWord, type);
    }
}
