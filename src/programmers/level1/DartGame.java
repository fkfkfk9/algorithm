package programmers.level1;

public class DartGame {
    public static void main(String[] args) {
        DartGame dg = new DartGame();

        System.out.println(dg.solution("1S2D*3T"));
        System.out.println(dg.solution("1D2S#10S"));
        System.out.println(dg.solution("1D2S0T"));
        System.out.println(dg.solution("1S*2T*3S"));
        System.out.println(dg.solution("1D#2S*3S"));
        System.out.println(dg.solution("1T2D3D#"));
        System.out.println(dg.solution("1D2S3T*"));

    }

    public int solution(String dartResult) {
        int answer = 0;
        String[] arr = {"","",""};
        int[] iarr = new int[3];
        int arrIdx = 0;
        char[] chArr = dartResult.toCharArray();

        for (int i = 0; i <chArr.length ; i++) {
            arr[arrIdx] += chArr[i];
            if(chArr[i] == 68 || chArr[i] == 83 || chArr[i] == 84){
                if(i+1 < chArr.length && (chArr[i+1] == 35 || chArr[i+1] == 42)){
                    arr[arrIdx++] += chArr[i+1];
                    i++;
                }else arrIdx++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int score = 0;
            String area = "";
            String bonus = "";

            if(arr[i].substring(0,2).equals("10")){
                score = 10;
                area = arr[i].substring(2,3);
                if(arr[i].length() == 4) bonus = arr[i].substring(3,4);
            }else{
                score = Integer.parseInt(arr[i].substring(0,1));
                area = arr[i].substring(1,2);
                if(arr[i].length() == 3) bonus = arr[i].substring(2,3);
            }

            switch (area){
                case "S":
                    iarr[i] = score;
                    break;
                case "D":
                    iarr[i] = score*score;
                    break;
                case "T":
                    iarr[i] = score*score*score;
                    break;
            }

            if("*".equals(bonus)){
                iarr[i] *= 2;
                if(i > 0) iarr[i-1] *= 2;
            }else if("#".equals(bonus)){
                iarr[i] *= -1;
            }
        }

        for (int i = 0; i < arr.length; i++) answer += iarr[i];

        return answer;
    }
}
