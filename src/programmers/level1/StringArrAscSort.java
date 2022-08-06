package programmers.level1;

import java.util.Arrays;

public class StringArrAscSort {
    public static void main(String[] args) {
        StringArrAscSort saas = new StringArrAscSort();
        System.out.println(Arrays.toString(saas.nIdxCompareArr(new String[]{"sun", "bed", "car"},1)));
        System.out.println(Arrays.toString(saas.nIdxCompareArr(new String[]{"abce", "abcd", "cdx"},2)));
    }

    public String[] nIdxCompareArr(String[] strings, int n) {
        for (int i = 0; i < strings.length-1; i++) {
            for (int j = i+1; j < strings.length; j++) {
                if(strings[i].substring(n,n+1).compareTo(strings[j].substring(n,n+1))>0) arrIdxChange(strings,i,j);
                else if(strings[i].substring(n,n+1).compareTo(strings[j].substring(n,n+1)) == 0){
                    if(strings[i].compareTo(strings[j])>0) arrIdxChange(strings,i,j);
                }
            }
        }
        return strings;
    }

    private void arrIdxChange(String[] arr, int idx1, int idx2){
        String temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
