package es.eight.state;

import org.jetbrains.annotations.NotNull;

public class LetterType {


    public String getType(@NotNull String letter){
        if (letter.length()>1 || letter.charAt(0) < 65 && letter.charAt(0) > 90 || letter.charAt(0) < 97 && letter.charAt(0) > 122)
            return "Invalid input";
        if (letter.equals("a") || letter.equals("e") || letter.equals("i") || letter.equals("o") || letter.equals("u"))
            return "Input letter is a Vocal";
        else
            return "Input letter is a Consonant";
    }
}
