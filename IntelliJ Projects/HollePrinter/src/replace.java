import java.util.*;
public class replace {
    String str;
    char[] chr;

    public replace(String str){
        this.str=str;
        chr= new char[str.length()];
        chr= str.toCharArray();
    }

    public String Switch(){
        str=str.replace('e','/');
        str=str.replace('o','*');
        str=str.replace('/','o');
        str=str.replace('*','e');
        return str;
    }
}
