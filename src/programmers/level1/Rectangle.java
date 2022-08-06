package programmers.level1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rectangle {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();

        int[][] arr1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int[][] arr2 = {{10, 7}, {12, 3}, {8, 15}, {5, 15}};

        rectangle.solution(arr2);
    }

    public int solution(int[][] sizes) {
        int answer = 0;
        Set<String> set = new HashSet<>();
        set.add("1");
        return answer;
    }
}
