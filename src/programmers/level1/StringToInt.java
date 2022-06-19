package programmers.level1;

public class StringToInt {
    public static void main(String[] args) {
        StringToInt sti = new StringToInt();

        System.out.println(sti.getAnswer("1234"));
        System.out.println(sti.getAnswer("-1234"));
        System.out.println(sti.getAnswer("+1234"));
    }

    public int getAnswer(String s) {
        int answer = 0;
        char CASTING_NUM = 48;
        char[] arr = s.toCharArray();
        int sign = 0;

        if(arr[0] == 45 || arr[0] == 43) sign = 1;

        for(int i = sign; i < arr.length; i++){
            int num = arr[i]-CASTING_NUM;
            answer += num * squareInt(arr.length-i-1);
        }

        if(arr[0] == 45) answer = ~answer+1;
        return answer;
    }

    public int squareInt(int cnt){
        if(cnt == 1) return 10;
        else if(cnt == 0) return 1;
        return squareInt(cnt-1) * 10;
    }
}
