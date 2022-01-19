package Game2048_test;

import Block.Block;
import Block.InsideBlock;
import Interface.CreatInterface;
import Interface.DealWithInterface;
import Users.RegisteredUser;
import Users.UnRegisteredUser;
import Users.User;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class JunitTest {
    @Test
    public void UnRegisteredUserGetInformationTest() {
        //test getInformation() method in class UnRegisteredUser
        User userUnregister = new UnRegisteredUser();
        Assert.assertEquals("You have not registered", userUnregister.getInformation());
    }

    @Test
    public void RegisteredUserGetInformationTest() {
        //test getInformation() method in class RegisteredUser
        User userRegister = new RegisteredUser("Xiaobing", 30, "Male");
        Assert.assertEquals("Username: Xiaobing; Age: 30; Gender: Male", userRegister.getInformation());
    }

    @Test
    public void DealWithInterfaceGetAvailableLocationTest() {
        //test getAvailableLocation() method in class DealWithInterface
        //the method need a Block Object array, if the Object.number==0 in the array, the location is available

        //creat a example Block Object array
        Block[][] blocks = new Block[][]
                {new Block[]{new InsideBlock(0, new int[]{0, 0}), new InsideBlock(4, new int[]{0, 1})},
                        new Block[]{new InsideBlock(2, new int[]{1, 0}), new InsideBlock(0, new int[]{1, 1})}};

        List<int[]> enableLocations = DealWithInterface.getAvailableLocation(blocks);
        Assert.assertEquals(2, enableLocations.size());
        Assert.assertArrayEquals(new int[]{0, 0}, enableLocations.get(0));
        Assert.assertArrayEquals(new int[]{1, 1}, enableLocations.get(1));

    }

    @Test
    public void CreatInterfaceSetInterfaceTest() {
        //test setInterface() method in class CreatInterface

        //make sure the size of interface equal to the number you set
        App.currentUser = new UnRegisteredUser();
        CreatInterface.setInterface(App.interfaceSize, App.currentUser);
        Assert.assertEquals(App.interfaceSize, App.currentUser.currentBlocksArray.length);
        for (int i = 0; i < App.interfaceSize; i++) {
            Assert.assertEquals(App.interfaceSize, App.currentUser.currentBlocksArray[i].length);
        }

        //make sure the game successfully init (there are two block Object.number do not equal to 0)
        List<int[]> enableLocations = DealWithInterface.getAvailableLocation(App.currentUser.currentBlocksArray);
        Assert.assertEquals(2, App.interfaceSize * App.interfaceSize - enableLocations.size());

    }
}
