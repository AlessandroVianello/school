package es.six.method;

public class SumNumbers{
    private String num;

    public SumNumbers(){
        this(null);
    }

    public SumNumbers(String num){
        this.num=num;
    }

    public int sum(){
        if (Integer.parseInt(num)<0)
            throw new IllegalArgumentException("number can't be lower than 0");
        int n=0;
        for (int i=0;i<num.length();i++){
            n=n+Character.getNumericValue(num.charAt(i));
        }
        return n;
    }

    public int sum(String num){
        if (Integer.parseInt(num)<0)
            throw new IllegalArgumentException("number can't be lower than 0");
        this.num=num;
        int n=0;
        for (int i=0;i<this.num.length();i++){
            n=n+Character.getNumericValue(this.num.charAt(i));
        }
        return n;
    }

}
