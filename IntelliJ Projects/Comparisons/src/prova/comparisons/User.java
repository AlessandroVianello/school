package prova.comparisons;

public class User implements Comparable<User>{

    private String username;
    private int age;

    public User(String username, int age){
        if (age<0)
            throw new IllegalArgumentException("age con't be lower than 0");
        this.age=age;
        this.username=username;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public String toString(){
        return "Comparison ["+getUsername()+", "+getAge()+"]";
    }

    @Override
    public int compareTo(User o) {
        if(this.age<o.age)
            return -1;
        if (this.age>o.age)
            return 1;
        return 0;
    }
}
