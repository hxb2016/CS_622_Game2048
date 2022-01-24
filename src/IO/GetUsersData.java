package IO;

import Users.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

/**
 * The purpose of this class is to get users data from local data
 */
public class GetUsersData {
    /**
     * The purpose of getUsersData method is to get users data from local data
     */
    public static Map<String, User> getUsersData(String path) throws IOException, ClassNotFoundException {
        if(new File(path).exists()) {//if file exist, get data
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
            Map<String, User> o = (Map<String, User>) inputStream.readObject();
            inputStream.close();
            return o;
        }else{//if not, return null
            return null;
        }
    }

}
