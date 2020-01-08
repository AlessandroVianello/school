package es.three.state;

public class SearchMax {
    public int findMax(int number1, int number2, int number3){
        int max=number1;

        if (max<number2)
            max=number2;
        if (max<number3)
            max=number3;

        return max;
    }
}
