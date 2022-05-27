package programmers.level1;

import java.util.Scanner;

public class DrawSquareWithStar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 1; i <= a*b; i++) {
            System.out.print("*");
            if(i % a == 0){
                System.out.print("\n");
            }
        }
    }
}
