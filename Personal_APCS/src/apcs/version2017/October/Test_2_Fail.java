package apcs.version2017.October;

import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Test_2_Fail {

    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in); // 輸入k值
        Scanner sc2 = new Scanner(System.in); // 輸入英文字串
        int k = Integer.parseInt(sc1.nextLine()); // 將k值讀出
        String input = sc2.nextLine(); // 將英文字串轉成String
        int[] data = new int[input.length()]; // 儲存英文字串的大小寫資訊 0為小寫 1為大寫

        // 將英文字串轉成大小寫資訊並存於data[]
        for (int i = 0; i < input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i)) == true) {
                data[i] = 1;
            }
            if (Character.isUpperCase(input.charAt(i)) == false) {
                data[i] = 0;
            }
            // System.out.println(input.charAt(i));
            // System.out.print(data[i]);
        }

        // 測試區段
        //IntStream.of(data).forEach(x -> System.out.print(x)); // 測試data內存放的大小寫資訊
        int UpperMax = getContinueUpper(k, data);
        System.out.print(UpperMax);
    }

    public static int getContinueUpper(int k, int[] input) {
        int UpperCase = 1; // 紀錄最長的大寫字串
        int[] UpperCaseArray = new int[20];
        int r = 0; // 紀錄UpperCaseArray的位置

        // IntStream.of(input).forEach(System.out::print);
        // System.out.println();
        for (int i = 0; i < input.length - 1; i++) {
            // System.out.printf("已進入迴圈一, 第%d輪\n", i);
            // IntStream.of(UpperCaseArray).forEach(System.out::print);
            // System.out.println();
            if (input[i] == 1) {
                for (int j = i;; j++) {
                    // System.out.printf("\n已進入迴圈二, 第%d輪\n", j);
                    if (j == input.length - 1) {
                        UpperCaseArray[r] = UpperCase;
                        UpperCase = 1;
                        r++;
                        break;
                    }
                    if (input[j + 1] == 1) {
                        UpperCase += 1;
                        continue;
                    }
                    if (input[j + 1] == 0) {
                        UpperCaseArray[r] = UpperCase;
                        UpperCase = 1;
                        r++;
                        break;
                    }
                }
            } else {
                continue;
            }
        }

        int UpperMax = 0;
        for (int i = 0; i < UpperCaseArray.length; i++) {
            if (UpperCaseArray[i] > UpperMax) {
                UpperMax = UpperCaseArray[i];
            }
        }
        return UpperMax;
    }

    public static int getLongestUpper(int[] input) {
        int max = 0;
        int[] result = new int[20];
        int r = 0;
        int finalMax = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 1) {
                max += 1;
                continue;
            }
            if (input[i] != 1) {
                result[r] = max;
                r++;
                max = 0;
            }

        }
        IntSummaryStatistics stat = IntStream.of(result).summaryStatistics();
        for (int i = 0; i > result.length; i++) {
            if (result[i] > finalMax) {
                finalMax = result[i];
            }
        }
        return stat.getMax();
    }

}
