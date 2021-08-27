import java.util.*;

public class ArrayEx {
    public static void main(String[] args) {
        /* 넘어온 배열에 중복되는 숫자가 있다면 ture, 없다면 false */
        boolean result = arrayDuplicateCheckNum(new int[]{1, 2, 3, 4, 5, 3, 7});
        boolean result2 = arrayDuplicateCheckNum2(new int[]{1, 2, 3, 4, 5, 3, 7});
        boolean result3 = arrayDuplicateCheckNum2(new int[]{1, 2, 3, 4, 5, 3, 7});

        if(result3){
            System.out.println("중복된 숫자가 있습니다.");
        }else{
            System.out.println("중복된 숫자가 없습니다.");
        }

        // char형 배열을 역순으로 리턴
        System.out.println(swapString("Hello World".toCharArray()));
        System.out.println(swapString2("Apple".toCharArray()));

        //숫자배열과 타겟숫자를 넘겨 배열에서 2개를 더해 타겟숫자와 같아지는 인덱스를 리턴해준다.
        System.out.println(Arrays.toString(arrayTwoSumTarget(new int[]{2,3,5,7}, 9)));
        System.out.println(Arrays.toString(arrayTwoSumTarget2(new int[]{2,3,5,7}, 9)));
        //숫자배열에서 3개를 더하여 target값이 나오는 인덱스를 리턴해주면 된다.
        System.out.println(Arrays.toString(arrayTwoSumTarget3(new int[]{2,3,5,7}, 10)));
        // 1~100까지의 숫자중 50개가 들어있는 배열을 정렬하되 시간복잡도를 O(n)으로 처리하라
        System.out.println(Arrays.toString(arrayIndexSort(new int[]{23,13,55,7})));
    }

    /*
    *  가장 단순한 방법 2번 반복하기 때문에 시간복잡도는 O(n제곱), 하나의 boolearn만 있으면 되므로 공간복잡도는 O(1)이다.
    * */
    private static boolean arrayDuplicateCheckNum(int[] numArr){
        for (int i = 0; i < numArr.length-1; i++) {
            for (int j = i+1; j < numArr.length; j++) {
                if(numArr[i] == numArr[j]){
                    return true;
                }
            }
        }

        return false;
    }

    /*
    * sort한 뒤 진행한다. sort기능은 반복문을 2번하는거보다 시간복잡도가 낮다.
    * */
    private static boolean arrayDuplicateCheckNum2(int[] numArr){
        Arrays.sort(numArr); //Arrays의 sort는 시간복잡도 O(NlogN), 공간복잡도 O(logN) 이다.

        //연속됨으로 반복문을 한번만 사용해도 된다.
        for (int i = 0; i < numArr.length-1; i++) {
            if(numArr[i] == numArr[i + 1]){
                return true;
            }
        }

        return false;
    }

    /*
      Set을 사용한다. Set의 경우 해시값으로 조회하기 때문에 공간복잡도가 O(1)이다.
      또 중복된값을 허용하지 않는다.
      같은 값이 있는지 확인하는 메서드 contains를 사용한다.
      한번 반복하기 때문에 시간복잡도는 O(N)이고, HashSet를 생성하기 때문에 공간복잡도 또한 O(N)이다.
     * */
    private static boolean arrayDuplicateCheckNum3(int[] numArr){
        Set<Integer> numSet = new HashSet<>();
        for (int num: numArr ) {
            if(numSet.contains(num)){
                return true;
            }else{
                numSet.add(num);
            }
        }
        return false;
    }

    //한번 반복하기 때문에 시간복잡도는 O(N), 리턴할 배열을 하나 만들기 때문에 공간복잡도 또한 O(N)이다.
    private static char[] swapString(char[] charArr){
        char[] result = new char[charArr.length];

        for (int i = charArr.length-1; i >= 0; i--) {
            result[charArr.length - 1 -i] += charArr[i];
        }

        return result;
    }

    //여전히 반복하기 때문에 시간복잡도는 그대로지만 추가 배열을 만들지 않아 공간복잡도가 O(1)이다.
    private static char[] swapString2(char[] charArr){
        for (int i = 0; i < charArr.length/2; i++) {
            char temp = charArr[i];
            charArr[i] = charArr[charArr.length - 1 - i];
            charArr[charArr.length - 1 - i] = temp;
        }

        return charArr;
    }

    /*
    * 가장 단순한 방법 나도 이렇게 풀었다.
    * 시간복잡도는 반복문이 중첩됨으로 O(n제곱)이고 공간복잡도는 2개짜리 배열하나만 있으면 되므로 O(1)이다.
    * */
    private static int[] arrayTwoSumTarget(int[] numArr, int target){
        for (int i = 0; i < numArr.length-1; i++) {
            for (int j = i+1; j < numArr.length; j++) {
                if(numArr[i] + numArr[j] == target){
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    /*
     * HashMap을 활용한다.
     * 시간복잡도는 반복문이 1번이므로 O(n)이다. 공간복잡도는 맵을 생성했으므로 O(n)이된다.
     * */
    private static int[] arrayTwoSumTarget2(int[] numArr, int target){
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < numArr.length; i++) {
            int result = target - numArr[i];
            if(numMap.containsKey(result) && numMap.get(result) != i){
                return new int[]{i, numMap.get(result)};
            }

            numMap.put(numArr[i], i);
        }

        return null;
    }

    /*
     * HashMap과 중첩 반복문을 모두 사용하였다.
     * 시간복잡도는 반복문이 2번이므로 O(n제곱)이다. 공간복잡도는 맵을 생성했으므로 O(n)이된다.
     * */
    private static int[] arrayTwoSumTarget3(int[] numArr, int target){
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < numArr.length; i++) {
            int result = target - numArr[i];
            for (int j = i+1; j < numArr.length; j++) {
                int result2 = result - numArr[j];

                if(numMap.containsKey(result2) && numMap.get(result2) != j && numMap.get(result2) != i){
                    return new int[]{i, j, numMap.get(result2)};
                }
            }
            numMap.put(numArr[i], i);
        }

        return null;
    }

    /*
     * 배열의 인덱스를 활용한다.
     * 반복문이 중첩되지 않기 때문에 O(n)이다.
     * 공간복잡도는 100까지로 숫자가 고정되어있어 O(1)이다.
     * */
    private static int[] arrayIndexSort(int[] numArr){
        //범위가 1~100까지기 때문에 100개의 크기 배열을 만든다.
        boolean[] boolArr = new boolean[100];

        //반복문을 돌며 배열에 있는 숫자를 인덱스로넣어주고 true로 변견한다.
        //이는 문제가 1~100사이의 50개를 지정해주어서이다. 만약 중복된 숫자가 나온다면 불가능하다.
        for (int num: numArr) {
            boolArr[num] = true;
        }

        int idx = 0;
        for (int i = 0; i < boolArr.length; i++) {
            if(boolArr[i]){
                numArr[idx++] = i;
            }
        }
        return numArr;
    }

}
