package IO;

import Users.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 * The purpose of this class is to save users data
 */
public class SaveUsersData {
    /**
     * The purpose of saveUserData method is to save users data by given userData and saving path
     */
    public static void saveUserData(Map<String, User> usersData, String path) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(usersData);
        objectOutputStream.close();
    }
}
