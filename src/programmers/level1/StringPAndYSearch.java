package programmers.level1;

public class StringPAndYSearch {
    public static void main(String[] args) {
        StringPAndYSearch spays = new StringPAndYSearch();

        System.out.println(spays.pCntYCntCheck("pPoooyY"));
        System.out.println(spays.pCntYCntCheck("Pyy"));
    }

    boolean pCntYCntCheck(String s) {
        boolean answer = true;
        int pCnt = 0;
        int yCnt = 0;
        s = s.toLowerCase();

        for (String str: s.split("")) {
            if(str.contains("p")) pCnt++;
            if(str.contains("y")) yCnt++;
        }

        if(pCnt != yCnt) answer = false;

        return answer;
    }
}
