import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
     * 가장 단순한 방법 나도 이렇게 풀었다.
     * 시간복잡도는 반복문이 중첩됨으로 O(n제곱)이고 공간복잡도는 2개짜리 배열하나만 있으면 되므로 O(1)이다.
     * */
    private static int[] arrayTwoSumTarget2(int[] numArr, int target){
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < numArr.length-1; i++) {
            numMap.put(numArr[i], i);
        }

        for (int i = 0; i < numArr.length-1; i++) {
            int result = target - numArr[i];
            if(numMap.containsKey(result) && numMap.get(result) != i){
                return new int[]{i, j};
            }
        }

        return null;
    }

}
