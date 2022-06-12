package programmers.level1;

import java.util.Arrays;

public class ReversIntArray {
    public static void main(String[] args) {
        ReversIntArray ria = new ReversIntArray();
        System.out.println(Arrays.toString(ria.longToReverseIntArr(12345)));
    }

    public int[] longToReverseIntArr(long n) {
        char[] arr = Long.toString(n).toCharArray();
        reverseString(arr, arr.length/2-1);
        return Arrays.stream(new String(arr).split("")).mapToInt(Integer::parseInt).toArray();
    }

    private void reverseString(char[] arr, int check){
        if(check >= 0){
            char temp = arr[check];
            arr[check] = arr[arr.length-1-check];
            arr[arr.length-1-check] = temp;
            if(check != 0) reverseString(arr, --check);
        }
    }
}
