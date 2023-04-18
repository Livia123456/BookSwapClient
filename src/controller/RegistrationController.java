package controller;

import model.Email;
import model.UserInfo;

public class RegistrationController {
    private Controller controller;
    public RegistrationController(Controller controller) {
        this.controller = controller;
    }

    public void validEmail(Email email) {
        controller.getServer().sendMessage(email);
    }

    public boolean validPassword(char[] password) {
        if(password.length < 6) {
            return false;
        }
        boolean hasDigit = false;
        boolean hasLetter = false;
        for (char c : password) {
            if (c >= 48 && c <= 57) {
                hasDigit = true;
            }
            if (Character.toLowerCase(c) >= 97 && Character.toLowerCase(c) <= 122) {
                hasLetter = true;
            }
        }
        return (hasLetter && hasDigit);
    }

    public static void main(String[] args) {
//        RegistrationController rc = new RegistrationController();
//        System.out.println(rc.validPassword("hej"));
//        System.out.println(rc.validPassword("password"));
//        System.out.println(rc.validPassword("h1234"));
//        System.out.println(rc.validPassword("1122345567"));
//        System.out.println(rc.validPassword("hej123"));
    }

    public void newUser(String currentEmail, String userName, char[] password) {
        UserInfo userInfo = new UserInfo(currentEmail, password.toString());
        userInfo.setName(userName);
        controller.getServer().sendMessage(userInfo);
    }
}
