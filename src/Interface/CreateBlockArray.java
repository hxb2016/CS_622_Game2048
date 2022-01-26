package Interface;

import Block.RandomBlock;
import Block.Block;
import Block.InsideBlock;
import Users.User;

/**
 * The purpose of this class is to init the BlocksArray in the game
 */
public class CreateBlockArray {

    public static void createBlockArray(int size, User currentUser) {
        //
        currentUser.currentBlocksArray = new Block[size][size];
        for (int i = 0; i < currentUser.currentBlocksArray.length; i++) {
            for (int j = 0; j < currentUser.currentBlocksArray[i].length; j++) {
                currentUser.currentBlocksArray[i][j] = new InsideBlock(0, new int[]{i, j});
            }
        }


        //Creat two random Blocks and put them into the blocksArray
        Block randomBlock1 = new RandomBlock(currentUser);
        currentUser.currentBlocksArray[randomBlock1.location[0]][randomBlock1.location[1]] = randomBlock1;

        Block randomBlock2 = new RandomBlock(currentUser);
        currentUser.currentBlocksArray[randomBlock2.location[0]][randomBlock2.location[1]] = randomBlock2;
    }

}
