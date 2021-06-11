package apcs.version2017.October;

import java.util.Scanner;

public class Answer_1 {
    /*

0 0 0

1 1 1

3 0 1

0 0 1

     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String[] datas = keyboard.nextLine().split(" ");
        int a = Integer.parseInt(datas[0]);
        int b = Integer.parseInt(datas[1]);
        int result = Integer.parseInt(datas[2]);

        boolean i = true;
        if (result == 0) {
            if (a == 0 || b == 0) {
                System.out.println("AND");
                i = false;
            }
            if (a == 0 && b == 0) {
                System.out.println("OR");
                i = false;
            }
            if (a == 0 && b == 0 || a != 0 && b != 0) {
                System.out.println("XOR");
                i = false;
            }
        } else {
            if (a != 0 && b != 0) {
                System.out.println("AND");
                i = false;
            }
            if (a != 0 || b != 0) {
                System.out.println("OR");
                i = false;
            }
            if (a == 0 && b != 0 || a != 0 && b == 0) {
                System.out.println("XOR");
                i = false;
            }
        }
        if (i) {
            System.out.println("IMPOSSIBLE");
        }

    }

}
