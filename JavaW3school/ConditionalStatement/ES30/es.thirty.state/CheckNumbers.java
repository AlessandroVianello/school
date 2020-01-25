package es.thirty.state;

public class CheckNumbers {
    public String checkNumbers(int n1, int n2, int n3){
        if (n1==n2 && n2==n3)
            return "All numbers are equal";
        else {
            if(n1!=n2 && n2!=n3 && n1!=n3)
                return "All numbers are different";
            else
                return "Neither all are equal or different";
        }
    }
}
