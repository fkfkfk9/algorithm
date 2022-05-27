package programmers.level1;

import java.util.Arrays;

public class MetrixAdder {
    public static void main(String[] args) {
        MetrixAdder ma = new MetrixAdder();
        int[][] arr1 = {{1,2},{2,3}};
        int[][] arr2 = {{3,4},{5,6}};
        System.out.println(Arrays.deepToString(ma.adder(arr1,arr2)));
    }

    public int[][] adder(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }
}
