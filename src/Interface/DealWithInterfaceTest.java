package Interface;

import Block.Block;
import Block.InsideBlock;
import org.junit.Assert;
import org.junit.Test;

public class DealWithInterfaceTest {
    //Creat example data
    Block b1 = new InsideBlock(2, new int[]{0, 0});
    Block b2 = new InsideBlock(0, new int[]{0, 1});
    Block b3 = new InsideBlock(4, new int[]{1, 0});
    Block b4 = new InsideBlock(0, new int[]{1, 1});

    Block[][] blocksArray=new Block[][]{
            {b1,b2},
            {b3,b4},
    };

    @Test
    public void getAvailableLocationTest() {
        //Start Test for getAvailableLocation()
        Assert.assertEquals(2,DealWithInterface.getAvailableLocation(blocksArray).size());
        Assert.assertArrayEquals(new int[]{0, 1},DealWithInterface.getAvailableLocation(blocksArray).get(0));
        Assert.assertArrayEquals(new int[]{1, 1},DealWithInterface.getAvailableLocation(blocksArray).get(1));
    }
    @Test
    public void blockIsEnableTest() {
        //Start Test for blockIsEnable()
        Assert.assertFalse(DealWithInterface.blockIsEnable(b1));
        Assert.assertTrue(DealWithInterface.blockIsEnable(b2));
        Assert.assertFalse(DealWithInterface.blockIsEnable(b3));
        Assert.assertTrue(DealWithInterface.blockIsEnable(b4));
    }
}
