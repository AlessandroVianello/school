public class main {
    public static void main(String[] args) {
        mississipiScramble x = new mississipiScramble();
        System.out.println(x.str+"\t"+"lunghezza: "+x.str.length());
        System.out.println();
        x.scrambleI();
        System.out.println(x.str+"\t"+"lunghezza: "+x.str.length());
        System.out.println();
        x.scrambleS();
        System.out.println(x.str+"\t"+"lunghezza: "+x.str.length());
    }
}