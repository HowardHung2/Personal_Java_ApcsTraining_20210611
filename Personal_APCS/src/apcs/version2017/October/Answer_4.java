package apcs.version2017.October;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Answer_4 {

    /*測試資料

2
20 10
1 1

3
3 4 5
1 2 3
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int count = Integer.parseInt(keyboard.nextLine());

        ArrayList<A> list = new ArrayList<>();
        String[] ws = keyboard.nextLine().split(" ");
        String[] fs = keyboard.nextLine().split(" ");

        for (int i = 0; i < count; i++) {
            A a = new A();
            a.w = Integer.parseInt(ws[i]);
            a.f = Integer.parseInt(fs[i]);
            list.add(a);

        }
        Collections.sort(list);

        int value = getValue(list);
        System.out.println(value);
    }
    //計算目前排序的消耗值

    public static int getValue(ArrayList<A> list) {
        int value = 0;
        //從最後一個開始
        //最後一個的次數  * 上面物件重量的總和
        //第一個不用算
        for (int index = list.size() - 1; index > 0; index--) {
            A a = list.get(index);

            //計算上面物件重量的總和
            int allW = 0;
            for (int i = 0; i < index; i++) {
                allW += list.get(i).w;
            }

            //每一個物件消耗量的總和
            value += allW * a.f;
        }
        return value;
    }

}

class A implements Comparable<A> {

    int w;
    int f;

    /*
	//次數一次時, 用這個排序即可
	public int compareTo(A a) {
		return w - a.w;
	}
     */
    public int compareTo(A a) {
        return w * a.f - a.w * f;
    }

    public String toString() {
        return w + ":" + f;
    }
}
