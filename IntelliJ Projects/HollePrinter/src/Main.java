import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str;
        System.out.println("Inserire frase da scambiare 'e' con 'o' ed 'o' con 'e': ");
        str=in.nextLine();
        Replace rep = new Replace(str);
        str=rep.Switch();
        System.out.println("La frase scambiata: " + "\"" + str + "\"");
    }
}
