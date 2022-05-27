package programmers.level1;

public class PhoneNumToStar {
    public static void main(String[] args) {
        PhoneNumToStar pnts = new PhoneNumToStar();
        System.out.println(pnts.numberToStar("01033334444"));
        System.out.println(pnts.numberToStar("027778888"));
    }

    public String numberToStar(String phone_number) {
        StringBuilder answer = new StringBuilder();

        for(int i = 0;i < phone_number.length()-4;i++){
            answer.append("*");
        }

        answer.append(phone_number.substring(phone_number.length() - 4));

        return answer.toString();
    }
}
