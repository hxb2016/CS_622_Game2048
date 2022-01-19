package Game2048_test;

import IO.OutputInterface;
import IO.SaveUsersData;
import Interface.CreatInterface;
import Operation.Operate;
import IO.GetUsersData;
import Users.RegisteredUser;
import Users.UnRegisteredUser;
import Users.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class App {
    public static User currentUser;
    public final static int interfaceSize = 4;

    public static void main(String[] args) {
        System.out.println("==Welcome to 2048 Game==");
        System.out.print("Please enter your username: ");
        Scanner in = new Scanner(System.in);
        String username = in.next();
        Map<String, User> usersData = GetUsersData.getUserData("example path");//get local user data(but function I have not finished)

        usersData = new HashMap<>();//because there is file to save the user data, this just is an example data for test
        usersData.put("Xiaobing", null);//example data

        if (usersData.containsKey(username)) {//if username in the local data, the user is a registered user
            currentUser = new RegisteredUser("Xiaobing", 30, "Male");//example data in order to avoid program errors
            System.out.print("You had registered. Do you want to see your last result(y/n): ");
            String command = in.next();
            if (command.equals("y")) {//if you want see history data
                System.out.println("there is no data will show here..., because I have not done");
            }
            System.out.println("==New Game==\n");
            CreatInterface.setInterface(interfaceSize, currentUser);
            OutputInterface.outputInterface(currentUser.currentBlocksArray);
        } else {
            System.out.print("You have not registered, Do you want register now(y/n): ");
            String command = in.next();
            if (command.equals("y")) {//if you want register an account for the game
                currentUser = new RegisteredUser(username, 30, "Male");////example data in order to avoid program errors
                System.out.println("Good Job! You have registered!");
            } else {//if you do not want.......
                currentUser = new UnRegisteredUser();////example data in order to avoid program errors
                System.out.println("You will start as guest");
            }
            System.out.println("==New Game==\n");
            CreatInterface.setInterface(interfaceSize, currentUser);
            OutputInterface.outputInterface(currentUser.currentBlocksArray);

        }

        Operate.operation();

        System.out.print("Do you want save the result this time? (y/n): ");
        String command = in.next();
        if (command.equals("y")) {
            if (currentUser.getType().equals("RegisteredUser")) {
                ((RegisteredUser) currentUser).setData(currentUser);//set the data to prepare for saving
                usersData.put(currentUser.username, currentUser);
                SaveUsersData.saveUsersData(usersData, "example path");//example data
                System.out.println("You have successfully save!");
            } else {
                RegisteredUser newCurrentUser = new RegisteredUser(username, 30, "Male");//example data in order to avoid program errors
                newCurrentUser.currentResult = currentUser.currentResult;
                newCurrentUser.currentTakeTime = currentUser.currentTakeTime;
                newCurrentUser.setData(newCurrentUser);//set the data to prepare for saving
                usersData.put(newCurrentUser.username, newCurrentUser);
                SaveUsersData.saveUsersData(usersData, "example path");//example data
                System.out.println("You have successfully registered and save!");
            }
        }
        System.out.println("==You have quited from the game==");

    }
}
