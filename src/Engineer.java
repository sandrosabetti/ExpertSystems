import java.util.Scanner;

import org.apache.log4j.Logger;

public class Engineer {

    String[] login = new String[20];
    String[] password = new String[20];

//    private static Logger logger=Logger.getLogger("simple");

    public static boolean logged_in = false;

    Engineer(){
        set_login_and_password();
    }

    private void set_login_and_password() {
        login[0] = "a";
        password[0] = "1";
    }


    public boolean authorization(String inputted_login, String inputted_password) {
        for (int i = 0; i < login.length; i++) {
            if ((inputted_login.equals(login[i])) && (inputted_password.equals(password[i]))) {
                logged_in = true;
            }
        }
        return logged_in;
    }
}
