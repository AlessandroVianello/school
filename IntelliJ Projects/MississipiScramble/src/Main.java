public class Main {
    public static void main(String[] args) {
        MississippiScramble x = new MississippiScramble();
        System.out.println(x.str+"\t"+"lunghezza: "+x.str.length());
        System.out.println();
        x.scrambleI();
        System.out.println(x.str+"\t"+"lunghezza: "+x.str.length());
        System.out.println();
        x.scrambleS();
        System.out.println(x.str+"\t"+"lunghezza: "+x.str.length());
    }
}