package IO;

import Block.Block;
import Block.InsideBlock;
import org.junit.Assert;

/**
 * Not suitable for JUnit
 */
public class OutputInterfaceTest {
    public static void main(String[] args) {
        //Creat example data
        Block b1 = new InsideBlock(2, new int[]{0, 0});
        Block b2 = new InsideBlock(0, new int[]{0, 1});
        Block b3 = new InsideBlock(4, new int[]{1, 0});
        Block b4 = new InsideBlock(0, new int[]{1, 1});

        b1.ifCombine = true;

        Block[][] blocksArray = new Block[][]{
                {b1, b2},
                {b3, b4},
        };

        //Start test
        OutputInterface.outputInterface(blocksArray);

        Assert.assertFalse(b1.ifCombine);

        //In console, you will see below output
                //2       *

                //4       *
    }
}
