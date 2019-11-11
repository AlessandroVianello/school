public class MississippiScramble {

    String str;

    MississippiScramble(){
        str="Mississippi";
    }

    public void scrambleI(){
        str=str.replace("i","ii");
    }

    public void scrambleS(){
        str=str.replace("ss","s");
    }

}
