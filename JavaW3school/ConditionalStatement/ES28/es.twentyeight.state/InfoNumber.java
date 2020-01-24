package es.twentyeight.state;

public class InfoNumber {
    public String getInfo(float n){
        if (n==0)
            return "Zero";
        else {
            if (n>0 && Math.abs(n)<1)
                return "Small positive";
            if (n>0 && Math.abs(n)<=1000000)
                return "Positive";
            if (n>0 && Math.abs(n)>1000000)
                return "Large positive";
            if (n<0)
                return "Negative";
        }
        return "-1";
    }
}
