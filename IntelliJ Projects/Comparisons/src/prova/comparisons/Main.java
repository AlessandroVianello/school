package prova.comparisons;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector <User> users = new Vector<>();
        users.add(new User("Mario",30));
        users.add(new User("Luigi",32));
        users.add(new User("Peach",26));
        users.add(new User("Wario",40));
        users.add(new User("Waluigi",35));
        users.add(new User("Toad",4));

        Collections.sort(users);
        for (User user:users)
            System.out.println(user.toString());

        System.out.println("-----------------------");

        UsernameComparator cmp = new UsernameComparator();
        Collections.sort(users,cmp);
        for (User user:users)
            System.out.println(user.toString());
        System.out.println(cmp.getCounter()+1);

        System.out.println("-----------------------");


        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getAge()-o1.getAge();
            }
        });
        for (User user:users)
            System.out.println(user.toString());

        System.out.println("-----------------------");


        Collections.sort(users, (o1, o2) -> o2.getAge()-o1.getAge());
        for (User user:users)
            System.out.println(user.toString());
    }
}
