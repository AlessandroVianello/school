package es.thirtyone.state;

public class CheckOrder {
    public String checkOrder(int n1, int n2, int n3) {
        if (n1<n2 && n2<n3)
            return "Increasing order";
        if (n1>n2 && n2>n3)
            return "Decreasing order";
        return "Neither increasing or decreasing order";
    }
}
