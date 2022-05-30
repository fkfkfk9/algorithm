package programmers.level1;

public class HashadNum {
    public static void main(String[] args) {
        HashadNum hn = new HashadNum();
        System.out.println(hn.HashadNumCheck(10));
        System.out.println(hn.HashadNumCheck(12));
        System.out.println(hn.HashadNumCheck(11));
        System.out.println(hn.HashadNumCheck(13));
    }

    public boolean HashadNumCheck(int x) {
        boolean answer = true;
        String temp = x + "";
        int sum = 0;

        if(temp.length() > 1){
            String[] arr = temp.split("");

            for(String str : arr){
                sum += Integer.parseInt(str);
            }

            if(x%sum != 0) answer = false;
        }

        return answer;
    }
}
