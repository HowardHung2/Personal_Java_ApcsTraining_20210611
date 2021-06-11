package apcs.version2016.March;

import java.util.ArrayList;
import java.util.Scanner;

public class Answer_3 {

    /* 程式測試值

5
160 180
150 200
280 300
300 330
190 210

1
120 120

     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner keyboard = new Scanner(System.in);
        int line = Integer.parseInt(keyboard.nextLine());

        ArrayList<A> list = new ArrayList<>();

        outer:
        for (int i = 0; i < line; i++) {
            String[] datas = keyboard.nextLine().split(" ");
            int start = Integer.parseInt(datas[0]);
            int end = Integer.parseInt(datas[1]);

            //建立新物件前, 先確認其值是完全獨立
            //(沒有介於目前集合中的物件的起始與結束值之間)
            for (A aa : list) {
                //若start大於己存在物件的end
                if (start > aa.end) {
                    continue; //檢查集合中的下一個物件
                }
                //若 end 小於己存在物件的 start
                if (end < aa.start) {
                    continue; //檢查集合中的下一個物件
                }
                //若start小於己存在物件的 start
                if (start <= aa.start) {
                    //而且end大於己存在物件的end
                    if (end > aa.end) {
                        aa.start = start;
                        aa.end = end;
                        continue outer; //修改己存在物件的值, 不必再檢查集合中的下一個物件
                    } else {
                        aa.start = start;
                        continue outer; //修改己存在物件的值, 不必再檢查集合中的下一個物件
                    }
                }
                //若start 介於己存在物件的start與end之間
                if (start >= aa.start && start <= aa.end) {
                    //若end 介於己存在物件的start與end之間
                    if (end >= aa.start && end <= aa.end) {
                        continue outer; //修改己存在物件的值, 不必再檢查集合中的下一個物件
                    } else {
                        aa.end = end;
                        continue outer; //修改己存在物件的值, 不必再檢查集合中的下一個物件
                    }
                }
            }
            //若沒有執行 continue outer;
            //表示沒有修改己存在之物件值, 必須建立新的獨立物件並置入集合中
            A a = new A(start, end);
            list.add(a);
        }

        int allLength = 0;
        for (A a : list) {
            allLength += a.getLength();
        }
        System.out.println(allLength);
    }

}

class A {

    int start;
    int end;
    int length;

    public A(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getLength() {
        return end - start;
    }

    public String toString() {
        return start + ":" + end;
    }
}
