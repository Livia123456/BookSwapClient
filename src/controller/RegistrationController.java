package controller;

import model.Email;
import model.UserInfo;
import model.UserInfoUpdate;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


/**
 * This class is responsible for the methods associated with the registration and log-in methods
 * of the program.
 * @author Livia Tengelin, Olle Huss, Sebastian Zulj
 */
public class RegistrationController {

    private Controller controller;

    public RegistrationController(Controller controller) {
        this.controller = controller;
    }

    public void checkIfEmailIsRegistered(Email email) {
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


    public void newUser(String currentEmail, String userName, char[] password) {
        System.out.println(new String(password));
        UserInfo userInfo = new UserInfo(new Email(currentEmail), new String(password));
        userInfo.setName(userName);
        controller.getServer().sendMessage(userInfo);
    }

    public boolean validEmail(String email) {
        boolean hasAtSymbol = false;
        boolean hasFullStop = false;
        char[] array = email.toCharArray();
        for (char c : array) {
            if (c == 64) {
                hasAtSymbol = true;
            } else if (hasAtSymbol && c == 46) {
                hasFullStop = true;
            }
        }
        return (hasAtSymbol && hasFullStop);
    }

    public boolean checkNewPersonalInfo(String newName, String newPassword, String newEmail) {
        char[] newPasswordArray = newPassword.toCharArray();
        boolean newPasswordIsValid = validPassword(newPasswordArray);
        boolean newEmailIsValid = validEmail(newEmail);

        if(newEmailIsValid && newPasswordIsValid) {
            UserInfoUpdate newUserInfo = new UserInfoUpdate(new Email(newEmail), newPassword, newName);
            controller.getServer().sendMessage(newUserInfo);
            return true;
        } else {
            return false;
        }
    }

}
