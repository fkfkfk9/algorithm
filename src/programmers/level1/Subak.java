package programmers.level1;

public class Subak {
    public static void main(String[] args) {
        Subak s = new Subak();

        System.out.println(s.numToSubak(3));
        System.out.println(s.numToSubak(4));
        System.out.println(s.numToSubak(5));
    }

    public String numToSubak(int n) {
        String answer = "";

        for(int i=0; i<n; i++){
            if(i%2 == 0) answer += "수";
            else answer += "박";
        }

        return answer;
    }
}
