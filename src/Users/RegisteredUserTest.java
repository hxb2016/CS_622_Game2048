package Users;

import Block.Block;
import Block.InsideBlock;
import org.junit.Assert;
import org.junit.Test;

public class RegisteredUserTest {
    static User user = new RegisteredUser("Xiaobing", 30, "Male");

    @Test
    public void getInformationTest() {
        Assert.assertEquals("Username: Xiaobing; Age: 30; Gender: Male", user.getInformation());
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals("RegisteredUser", user.getType());
    }

    @Test
    public void setIntroduceTest() {
        user.setIntroduce("I am student in MET.");
        Assert.assertEquals("I am student in MET.", user.introduce);
    }

    @Test
    public void steDataTest() {
        Block b1 = new InsideBlock(2, new int[]{0, 0});
        Block b2 = new InsideBlock(0, new int[]{0, 1});
        Block b3 = new InsideBlock(4, new int[]{1, 0});
        Block b4 = new InsideBlock(0, new int[]{1, 1});
        Block[][] blocksArray = new Block[][]{
                {b1, b2},
                {b3, b4},
        };
        user.currentResult = "win";
        user.currentBlocksArray = blocksArray;
        user.currentTakeTime = 10000000;

        ((RegisteredUser) user).setData();

        Assert.assertArrayEquals(blocksArray, ((RegisteredUser) user).lastBlocksArray);
        Assert.assertEquals(10000000, ((RegisteredUser) user).lastTakeTime);

        Assert.assertArrayEquals(blocksArray, ((RegisteredUser) user).bestBlocksArray);
        Assert.assertEquals(10000000, ((RegisteredUser) user).bestTakeTime);
    }
}
