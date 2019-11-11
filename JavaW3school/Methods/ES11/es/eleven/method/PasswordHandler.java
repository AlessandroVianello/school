package es.eleven.method;

public class PasswordHandler {

    private String password;
    private int n_digits;

    public PasswordHandler(String password){
        this.password=password;
        n_digits=0;
    }

    public String checkPassword(){

        if(password.length()<8)
            throw new IllegalArgumentException("password can't be less than eight characters");
        for (int i=0;i<password.length();i++)
            if (password.charAt(i)<'0' && 'z'>password.charAt(i) && password.charAt(i)!=Character.SPACE_SEPARATOR)
                throw new IllegalArgumentException("password must only contain characters and digits");
        for (int i=0;i<password.length();i++) {
            if(Character.isDigit(password.charAt(i)))
                n_digits++;
            if(n_digits<2 && (i+1)==password.length())
                throw new IllegalArgumentException("password must have at least two digits");
        }

        return "Password is Valid: "+getPassword();
    }

    public String getPassword() {
        return password;
    }
}
