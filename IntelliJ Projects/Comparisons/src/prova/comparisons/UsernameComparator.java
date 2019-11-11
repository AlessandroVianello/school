package prova.comparisons;

import java.util.Comparator;

public class UsernameComparator implements Comparator<User> {

    private int callCounter=0;

    public void resetCounter(){
        callCounter=0;
    }

    public int getCounter(){
        return callCounter;
    }

    @Override
    public int compare(User o1, User o2) {
        callCounter++;
        return o1.getUsername().compareToIgnoreCase(o2.getUsername());
    }
}
