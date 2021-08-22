import java.util.Arrays;

public class ArrayEx {
    public static void main(String[] args) {
        /* 넘어온 배열에 중복되는 숫자가 있다면 ture, 없다면 false */
        boolean result = arrayDuplicateCheckNum(new int[]{1, 2, 3, 4, 5, 3, 7});

        if(result){
            System.out.println("중복된 숫자가 있습니다.");
        }else{
            System.out.println("중복된 숫자가 없습니다.");
        }
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
}
