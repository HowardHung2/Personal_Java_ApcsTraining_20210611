package apcs.version2016.March;

import java.util.Scanner;

public class Answer_2 {

    /*
3 2 3
1 1
3 1
1 2
1 0 0


3 2 2
3 3
2 1
1 2
0 1
     */
    public static void main(String[] args) {

        //接收輸入
        Scanner keyboard = new Scanner(System.in);
        String[] datas = keyboard.nextLine().split(" ");
        int R = Integer.parseInt(datas[0]); //陣列長度
        int C = Integer.parseInt(datas[1]); //陣列寬度
        int M = Integer.parseInt(datas[2]); //指令集

        int[][] array = new int[R][C];
        int[] compute = new int[M];

        for (int i = 0; i < R; i++) {
            datas = keyboard.nextLine().split(" ");
            for (int j = 0; j < C; j++) {
                array[i][j] = Integer.parseInt(datas[j]);
            }
        }
        datas = keyboard.nextLine().split(" ");
        for (int j = 0; j < C; j++) {
            compute[j] = Integer.parseInt(datas[j]);
        }

        //將指令集反向執行		
        for (int i = compute.length - 1; i >= 0; i--) {
            if (compute[i] == 0) {
                array = y(array);
            } else {
                array = x(array);
            }
        }

        //輸出
        System.out.println(array.length + " " + array[0].length);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }

    //題目是順時針方向旋轉, 現在是要還原, 所以寫逆時針方向旋轉
    //建立新陣列, 將值複製到適當的位置
    public static int[][] y(int[][] array) {
        int[][] newArray = new int[array[0].length][array.length];

        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray[i].length; j++) {
                newArray[i][j] = array[j][array[0].length - i - 1];
            }
        }
        return newArray;
    }

    //上下翻轉
    public static int[][] x(int[][] array) {
        int[][] newArray = new int[array.length][array[0].length];

        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray[i].length; j++) {
                newArray[i][j] = array[array.length - i - 1][j];
            }
        }
        return newArray;
    }

}
