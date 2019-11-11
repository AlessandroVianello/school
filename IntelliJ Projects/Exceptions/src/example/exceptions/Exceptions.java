package example.exceptions;

import java.io.*;

public class Exceptions {
    public static void main(String[] args){

        File myFile = new File("C:\\Users\\pronto all'uso\\Desktop\\school\\IntelliJ Projects\\Exceptions\\file.txt");
        InputStream myInputStream = null;
        try {
            myInputStream = new FileInputStream(myFile);
            int myByte=myInputStream.read();
            System.out.println(myByte);
        } catch (FileNotFoundException e) {
            System.out.println(myFile+" doesn't exist");
        }catch (IOException e){
            System.out.println(myFile+" is illegible or closed");
        }finally {
            try {
                myInputStream.close();
            } catch (IOException e) {
            }
        }
        /*else
            System.out.println(myFile+" doesn't exist");*/
    }
}
