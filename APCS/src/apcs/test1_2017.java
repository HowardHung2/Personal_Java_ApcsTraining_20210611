package apcs;

public class test1_2017 {
    
    public static void main(String[] args) {
        
        /*int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        
        Scanner sc1 = new Scanner(System.in);
        int a = sc1.nextInt(); //將sc1讀取值至a
        Scanner sc2 = new Scanner(System.in);
        int b = sc2.nextInt();
        Scanner sc3 = new Scanner(System.in);
        int c = sc3.nextInt();
        
        System.out.println("s1=" + a);
        System.out.println("s2=" + b);
        System.out.println("s3=" + c);
        
        Scanner sc1 = new Scanner(System.in);
        String sc = sc1.nextLine();
        String userinput[] = sc.split(" ");//透過空格切割形成陣列
        int a = Integer.parseInt(userinput[0]);
        int b = Integer.parseInt(userinput[1]);
        int c = Integer.parseInt(userinput[2]);
        boolean a1;
        boolean b1;
        boolean c1;
        int a = (int)sc.charAt(0);
        int b = (int)sc.charAt(0);
        int c = (int)sc.charAt(0);
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.out.println("c=" + c);
        
        //驗證數值是否為正數
        while( a<0 || b<0 ){
            System.out.printf("您輸入的數值有誤\n");
            return;
        }
    
        //驗證a及ｂ是否為0，如非0統一變成true以便計算
        if(a!=0)
            a1 = true;
        else
            a1 = false;
        if(b!=0)
            b1 = true;
        else
            b1 = false;
        if(c!=0)
            c1 = true;
        else
            c1 = false;
        
        if(a1&b1==c1)
            System.out.println("AND");
        if(a1|b1==c1)
            System.out.println("OR");
        if(a1^b1==c1)
            System.out.println("XOR");
        
        if(a1&b1!=c1 && a1|b1!=c1 && a1^b1!=c1)
            System.out.println("IMPOSSIBLE");*/
        
        String sc = "1 1 1";
        String input[] = sc.split(" ");
        int a = Integer.parseInt(input[0]);
        if(a != 0)
            a = 1;
        int b = Integer.parseInt(input[1]);
        if(b != 0)
            b = 1;
        int c = Integer.parseInt(input[2]);
        
        if((a&b)==c)
            System.out.println("AND");
        if((a|b)==c)
            System.out.println("OR");
        if((a^b)==c)
            System.out.println("XOR");
        if((a&b)!=c & (a|b)!=c & (a^b)==c)
            System.out.println("IMPOSSIBLE");
    }
    
}