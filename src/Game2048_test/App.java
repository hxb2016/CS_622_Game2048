package Game2048_test;

import IO.OutputInterface;
import IO.SaveUsersData;
import Interface.CreatInterface;
import Operation.Operate;
import IO.GetUsersData;
import Users.RegisteredUser;
import Users.UnRegisteredUser;
import Users.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The purpose of this class is to run the game
 */
public class App {
    public static User currentUser;
    public final static int interfaceSize = 2;//In order to make test convenient, reduce the interface size from 4 to 2
    public final static int WINNUM = 16;
    public static String userDataPath = "src\\UserData\\Data.txt";

    public static void main(String[] args) {
        System.out.println("==Welcome to 2048 Game==");
        System.out.print("Please enter your username to login: ");
        Scanner in = new Scanner(System.in);
        String username = in.next();
        Map<String, User> usersData = null;//get local user data(but function I have not finished)
        try {
            usersData = GetUsersData.getUsersData(userDataPath);//Get users' data
            if (usersData == null) {
                usersData = new HashMap<>();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error happened when get data.");
            e.printStackTrace();
        }
        
        begin(usersData, username, userDataPath);

        Operate.operation(currentUser);

        end(usersData, username, userDataPath);

    }

    public static void begin(Map<String, User> usersData, String username, String userDataPath) {
        Scanner in = new Scanner(System.in);
        if (usersData != null && usersData.containsKey(username)) {//if username in the local data, the user is a registered user
            System.out.print("Good job! Whether to see the last record(y/n): ");
            String command = in.next();
            if (command.equals("y")) {//if you want see history data
                if (((RegisteredUser) usersData.get(username)).lastBlocksArray != null) {//if you have not played the game
                    OutputInterface.outputInterface(((RegisteredUser) usersData.get(username)).lastBlocksArray);
                } else {
                    System.out.println("You have not played.");
                }
                System.out.print("Start a New Game? (y/n): ");
                command = in.next();
                if (command.equals("y")) {
                    currentUser = usersData.get(username);
                } else {
                    System.out.println("You have quit!");
                    System.exit(0);
                }
            } else {
                currentUser = usersData.get(username);
            }
        } else {
            System.out.print("Sorry, you have no account. Register now? (y/n): ");
            String command = in.next();
            if (command.equals("y")) {//if you want register an account for the game
                System.out.print("Please enter your Age: ");
                int age = in.nextInt();
                System.out.print("Please enter your Gender: ");
                String gender = in.next();
                currentUser = new RegisteredUser(username, age, gender);
                assert usersData != null;
                usersData.put(username, currentUser);

                try {
                    SaveUsersData.saveUserData(usersData, userDataPath);
                } catch (IOException e) {
                    System.out.println("Error happened when save data.");
                    e.printStackTrace();
                }

                System.out.println("Good Job! Successfully registered!");
                System.out.print("Start a New Game? (y/n): ");
                command = in.next();
                if (!command.equals("y")) {
                    System.out.println("You have quit!");
                    System.exit(0);
                }
            } else {//if you do not want.......
                currentUser = new UnRegisteredUser();
                System.out.println("Start as guest");
            }
        }
        System.out.println("==New Game==\n");
        CreatInterface.setInterface(interfaceSize, currentUser);
        OutputInterface.outputInterface(currentUser.currentBlocksArray);
    }

    public static void end(Map<String, User> usersData, String username, String userDataPath) {
        Scanner in = new Scanner(System.in);
        System.out.print("Save your record? (y/n): ");
        String command = in.next();
        if (command.equals("y")) {
            if (currentUser.getType().equals("RegisteredUser")) {
                ((RegisteredUser) currentUser).setData();//set the data to prepare for saving
                try {
                    SaveUsersData.saveUserData(usersData, userDataPath);
                } catch (IOException e) {
                    System.out.println("Error happened when save data.");
                    e.printStackTrace();
                }
                System.out.println("Successfully save!");
            } else {
                System.out.print("Please enter your Age: ");
                int age = in.nextInt();
                System.out.print("Please enter your Gender: ");
                String gender = in.next();
                RegisteredUser newCurrentUser = new RegisteredUser(username, age, gender);
                newCurrentUser.currentResult = currentUser.currentResult;
                newCurrentUser.currentBlocksArray = currentUser.currentBlocksArray;
                newCurrentUser.currentTakeTime = currentUser.currentTakeTime;
                newCurrentUser.setData();//set the data to prepare for saving
                usersData.put(username, newCurrentUser);
                try {
                    SaveUsersData.saveUserData(usersData, userDataPath);
                } catch (IOException e) {
                    System.out.println("Error happened when save data.");
                    e.printStackTrace();
                }
                System.out.println("Successfully Registered and Save!");
            }
        }
        System.out.println("==You have quit from the game==");
    }
}
