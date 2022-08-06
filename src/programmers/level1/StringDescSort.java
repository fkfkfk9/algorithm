package programmers.level1;

public class StringDescSort {
    public static void main(String[] args) {
        StringDescSort sds = new StringDescSort();
        System.out.println(sds.sortDesc("Zbcdefg"));
    }

    public String sortDesc(String s) {
        String[] arr = s.split("");
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i].compareTo(arr[j])<0){
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return String.join("",arr);
    }
}
