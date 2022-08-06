package programmers.level1;

public class SecretMap {
    public static void main(String[] args) {
        SecretMap sm = new SecretMap();
        String[] arr = sm.solution(5,new int[]{9, 20, 28, 18, 11},new int[]{30, 1, 21, 17, 28});
        String[] arr2 = sm.solution(6,new int[]{46, 33, 33 ,22, 31, 50},new int[]{27 ,56, 19, 14, 14, 10});

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String wall = "";
            String arrStr = Integer.toBinaryString(arr1[i] | arr2[i]);

            arrStr = arrStr.replaceAll("1", "#");
            arrStr = arrStr.replaceAll("0", " ");

            if(arrStr.length() < n){
                for (int j = 0; j < n-arrStr.length(); j++) {
                    wall += " ";
                }
                arrStr = wall + arrStr;
            }

            answer[i] = arrStr;
        }

        return answer;
    }
}
