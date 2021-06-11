package apcs.version2016.March;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Test_1 {

    public static void main(String[] args) {
        Scanner sc0 = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        int len = sc0.nextInt();
        String[] nums = new String[len];
        String a = sc.nextLine();
        nums = a.split(" ");
        int[] Score = new int[len];
        //int[] Score = Stream.of(collect).forEach(int s -> Score);
        //System.out.print(collect.length);
        for (int j = 0; j < nums.length; j++) {
            Score[j] = Integer.parseInt(nums[j]);
        }
        // int[] Score = {100, 20, 80, 69, 57};
        int min = IntStream.of(Score).filter(s -> s >= 60).min().getAsInt();
        int max = IntStream.of(Score).filter(s -> s <= 60).max().getAsInt();
        Arrays.sort(Score);
        IntStream.of(Score).forEach(s -> System.out.print(s + " "));
        System.out.println();
        if (min <= 60) {
            System.out.println("worst case");
        } else {
            System.out.println(min);
        }
        if (max >= 60) {
            System.out.println("best case");
        } else {
            System.out.println(max);
        }
    }
}
