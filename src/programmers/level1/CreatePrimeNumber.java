package programmers.level1;

public class CreatePrimeNumber {
    public static void main(String[] args) {
        CreatePrimeNumber cpn = new CreatePrimeNumber();
        System.out.println(cpn.solution(new int[]{1,2,3,4}));
        System.out.println(cpn.solution(new int[]{1,2,7,6,4}));
    }

    public int solution(int[] nums) {
        int answer = 0;
        //3개를 조합한 모든수를 찾기 위해 소수를 찾는거 까지 4중 반복문을 한다.
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    //소수인지 찾을 숫자
                    int num = nums[i]+nums[j]+nums[k];
                    //소수가 아닐경우 변경할 상태값
                    boolean isPrimeNum = true;

                    //소수는 1과 본인으로만 나누어 떨어지기 떄문에 2부터 제곱근까지 1번이라도 나누어 떨어지면 소수가 아니다.
                    for (int l = 2; l <= Math.sqrt(num) ; l++) {
                        if(num%l == 0){
                            isPrimeNum = false;
                            break;
                        }
                    }
                    //상태값이 변하지 않았으면 소수
                    if(isPrimeNum) answer++;
                }
            }
        }

        return answer;
    }
}
