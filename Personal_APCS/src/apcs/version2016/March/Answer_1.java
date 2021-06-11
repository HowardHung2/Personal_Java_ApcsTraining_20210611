package apcs.version2016.March;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Answer_1 {


/*

10
0 11 22 33 55 66 77 99 88 44

1
13

2
73 65
 * */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int count = Integer.parseInt(keyboard.nextLine());

        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();

        String[] datas = keyboard.nextLine().split(" ");
        for (int i = 0; i < count; i++) {
            int score = Integer.parseInt(datas[i]);
            if (score < 60) {
                listA.add(score); //不及格分數
            } else {
                listB.add(score); //及格分數
            }
        }
        Collections.sort(listA);
        Collections.sort(listB);

        String s = "";
        for (int i : listA) {
            s += i + " ";
        }
        for (int i : listB) {
            s += i + " ";
        }
        s = s.substring(0, s.length() - 1);

        System.out.println(s);
        if (listA.size() == 0) {
            System.out.println("best case");
        } else {
            System.out.println(listA.get(listA.size() - 1));
        }
        if (listB.size() == 0) {
            System.out.println("worse case");
        } else {
            System.out.println(listB.get(0));
        }

    }

}
