package Game2048_test;

import Users.RegisteredUser;
import Users.UnRegisteredUser;
import Users.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Not suitable for JUnit
 */
public class AppTest {
    static Map<String, User> userData = new HashMap<>();
    static String username_1 = "Xiaobing";
    static String username_2 = "Kw";
    static String userDataPath = "src\\UserData\\DataTest.txt";

    public static void main(String[] args) {
        App.currentUser = new RegisteredUser(username_1, 30, "male");
        userData.put(username_1, App.currentUser);
        testBegin();
        testEnd();
    }

    public static void testBegin() {
        //Start test for begin():
        System.out.println("====Start test for begin()====\n");
        // Test_1 for registered user
        System.out.println("Test_1 for Registered user\n");
        App.begin(userData, username_1, userDataPath);

        //Output example for Test_1:
        //Good job! Whether to see the last record(y/n): y
        //You have not played.
        //Start a New Game? (y/n): y
        //==New Game==

        //*       *       *       *

        //4       *       *       *

        //*       *       4       *

        //*       *       *       *


        System.out.println("\nTest_2 for UnRegistered user\n");
        // Test_2 for UnRegistered user
        App.begin(userData, username_2, userDataPath);

        //Output example for Test_2:
        //Sorry, you have no account. Register now? (y/n): y
        //Please enter your Age: 30
        //Please enter your Gender: male
        //Good Job! Successfully registered!
        //Start a New Game? (y/n): y
        //==New Game==

        //*       *       *       *

        //*       *       *       *

        //2       *       *       4

        //*       *       *       *
    }

    public static void testEnd() {
        //Creat example data
        userData = new HashMap<>();
        userData.put(username_1, App.currentUser);

        System.out.println("====Start test for end()====\n");
        System.out.println("Test_2 for UnRegistered user\n");
        //Start test for end():
        App.currentUser.currentResult = "win";
        // Test_1 for registered user
        App.end(userData, username_1, userDataPath);
        //Output example for Test_1:
        //Save your record? (y/n): y
        //Successfully save!
        //==You have quit from the game==

        System.out.println("\nTest_2 for UnRegistered user\n");
        App.currentUser = new UnRegisteredUser();
        App.currentUser.currentResult = "win";
        // Test_2 for UnRegistered user
        App.end(userData, username_2, userDataPath);
        //Save your record? (y/n): y
        //Please enter your Age: 23
        //Please enter your Gender: male
        //Successfully Registered and Save!
        //==You have quit from the game==
    }
}
