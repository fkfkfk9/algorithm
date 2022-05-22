import java.util.Arrays;

public class RecursionReverseString {
    public static void main(String[] args) {
        RecursionReverseString rrs = new RecursionReverseString();
        char[] s = {'h','e','l','l','o'};
        System.out.println("변경 전 : " + Arrays.toString(s));
        rrs.reverseString(s);
        System.out.println("변경 후 : " + Arrays.toString(s));
        char[] s2 = {'H','a','n','n','a', 'h'};
        System.out.println("변경 전 : " + Arrays.toString(s2));
        rrs.reverseString(s2);
        System.out.println("변경 후 : " + Arrays.toString(s2));
    }

    public void reverseString(char[] s) {
        recursionReverse(s, s.length/2-1);
    }

    private void recursionReverse(char[] s, int cnt){
        if(cnt >= 0){
            char temp = s[cnt];
            s[cnt] = s[s.length-1-cnt];
            s[s.length-1-cnt] = temp;
            if(cnt != 0) recursionReverse(s, --cnt);
        }
    }
}
