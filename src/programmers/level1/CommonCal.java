package programmers.level1;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CommonCal {
    public static void main(String[] args) {
        CommonCal cc = new CommonCal();
        System.out.println(Arrays.toString(cc.calculator(3,12)));
        System.out.println(Arrays.toString(cc.calculator(2,5)));
    }

    public int[] calculator(int n, int m) {
        int minNum = n;
        int maxNum = m;

        if(n>m) {
            minNum = m;
            maxNum = n;
        }

        return new int[]{maxCommon(minNum,maxNum),minCommon(minNum,maxNum)};
    }

    private int maxCommon(int minNum, int maxNum){
        List<Integer> minList = new ArrayList<>();
        List<Integer> maxList = new ArrayList<>();

        for (int i = 1; i <= maxNum; i++) {
            if(minNum % i == 0) minList.add(i);
        }

        for (int i = 1; i <= maxNum; i++) {
            if(maxNum % i == 0) maxList.add(i);
        }

        List<Integer> result = minList.stream().filter(num -> maxList.stream().anyMatch(Predicate.isEqual(num))).collect(Collectors.toList());
        return result.stream().max(Integer::compare).orElse(-1);
    }

    private int minCommon(int minNum, int maxNum){
        int result = 0;

        if(maxNum % minNum == 0) result = maxNum;
        else {
            int[] minArr = new int[maxNum];
            int[] maxArr = new int[minNum];

            for (int i = 1; i <= maxNum; i++) {
                minArr[i-1] = minNum * i;
            }

            for (int i = 1; i <= minNum; i++) {
                maxArr[i-1] = maxNum * i;
            }

            for (int i : minArr) {
                for (int j : maxArr) {
                    if (i == j) {
                        result = i;
                        break;
                    }
                }
                if(result > 0) break;
            }
        }

        return result;
    }
}
