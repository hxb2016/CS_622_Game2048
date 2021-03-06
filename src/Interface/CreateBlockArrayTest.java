package Interface;

import Users.RegisteredUser;
import Users.User;
import org.junit.Assert;
import org.junit.Test;

public class CreateBlockArrayTest {
    @Test
    public void createBlockArrayTest() {
        //Creat example user object
        User user = new RegisteredUser("Xiaobing", 30, "male");
        //Start test
        CreateBlockArray.createBlockArray(2, user);
        Assert.assertEquals(user.currentBlocksArray.length,2);
        Assert.assertEquals(user.currentBlocksArray[0].length,2);
        Assert.assertEquals(user.currentBlocksArray[1].length,2);
    }
}
