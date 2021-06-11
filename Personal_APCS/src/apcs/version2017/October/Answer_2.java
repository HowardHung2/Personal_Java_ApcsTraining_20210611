package apcs.version2017.October;

import java.util.Scanner;

public class Answer_2 {


/* 測試資料

1
aBBdaaa

3
DDaasAAbbCC

2
aafAXbbCDCCC

3
DDaaAAbbCC
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int k = Integer.parseInt(keyboard.nextLine());
        String data = keyboard.nextLine();

        //記錄最大長度
        int biggestLength = 0;

        //記錄目前累計字串
        String ks = "";

        begin:
        for (int i = 0; i < data.length();) {
            String s = "";
            for (int j = 0; j < k; j++) {//每次串接k個字元
                if ((i + j) >= data.length()) {
                    break begin;
                }
                s += data.charAt(i + j);
            }

            //若ks目前是空的,表示目前字串大寫或小寫都可以, 只要讀進來的k個字元若是正確的,訧繼續讀k個字元 			
            if (ks.length() == 0) {
                if (sameUpperCase(s) || sameLowerCase(s)) {
                    ks += s;
                    i += k;
                    if (ks.length() > biggestLength) {
                        biggestLength = ks.length();
                    }
                    continue;
                }
            }
            //若ks目前不是空的, 必須由最後一個字元判斷現在要檢查的是大寫還是小寫
            if (ks.length() != 0 && ks.charAt(ks.length() - 1) >= 'a' && ks.charAt(ks.length() - 1) <= 'z' && sameUpperCase(s)) {
                ks += s;
                i += k;
                if (ks.length() > biggestLength) {
                    biggestLength = ks.length();
                }
                continue;
            }
            if (ks.length() != 0 && ks.charAt(ks.length() - 1) >= 'A' && ks.charAt(ks.length() - 1) <= 'Z' && sameLowerCase(s)) {
                ks += s;
                i += k;
                if (ks.length() > biggestLength) {
                    biggestLength = ks.length();
                }
                continue;
            }

            //執行到這裡, 表示連續字串己中斷, 必須從最後一次 k個字元前的下一個序號開始讀k個字元		
            if (ks.length() != 0) {
                i -= k;
            }
            i++;
            ks = "";
        }
        System.out.println(biggestLength);
    }

    public static boolean sameUpperCase(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 'A' || c > 'Z') {
                return false;
            }
        }
        return true;
    }

    public static boolean sameLowerCase(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 'a' || c > 'z') { // 不是小寫
                return false;
            }
        }
        return true;
    }

}
