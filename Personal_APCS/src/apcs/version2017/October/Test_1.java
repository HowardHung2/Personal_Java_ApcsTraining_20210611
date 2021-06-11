package apcs.version2017.October;

public class Test_1 {
    
    public static void main(String[] args) {
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