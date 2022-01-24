package Interface;

import Block.Block;
import Block.InsideBlock;
import org.junit.Assert;
import org.junit.Test;

public class GetEmptyLocationTest {
    //Creat example blocksArray
    Block b1 = new InsideBlock(2, new int[]{0, 0});
    Block b2 = new InsideBlock(0, new int[]{0, 1});
    Block b3 = new InsideBlock(4, new int[]{1, 0});
    Block b4 = new InsideBlock(0, new int[]{1, 1});

    Block[][] blocksArray=new Block[][]{
            {b1,b2},
            {b3,b4},
    };

    @Test
    public void getEmptyLocationTest() {
        //Start Test for getAvailableLocation()
        Assert.assertEquals(2, GetEmptyLocation.getEmptyLocation(blocksArray).size());
        Assert.assertArrayEquals(new int[]{0, 1}, GetEmptyLocation.getEmptyLocation(blocksArray).get(0));
        Assert.assertArrayEquals(new int[]{1, 1}, GetEmptyLocation.getEmptyLocation(blocksArray).get(1));
    }
    @Test
    public void blockIsEmptyTest() {
        //Start Test for blockIsEnable()
        Assert.assertFalse(GetEmptyLocation.blockIsEmpty(b1));
        Assert.assertTrue(GetEmptyLocation.blockIsEmpty(b2));
        Assert.assertFalse(GetEmptyLocation.blockIsEmpty(b3));
        Assert.assertTrue(GetEmptyLocation.blockIsEmpty(b4));
    }
}
