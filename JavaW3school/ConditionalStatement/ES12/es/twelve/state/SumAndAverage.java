package es.twelve.state;

public class SumAndAverage {
    public double getSum(double[] array){
        double sum=0;
        for (int i=0;i<5;i++)
            sum += array[i];
        return sum;
    }

    public double getAverage(double[] array){
        return getSum(array)/array.length;
    }
}
