package Interface;

import Block.*;
import Users.User;

public class CreatInterface {

    public static void setInterface(int size, User currentUser) {
        //
        currentUser.currentBlocksArray = new Block[size][size];
        for (int i = 0; i < currentUser.currentBlocksArray.length; i++) {
            for (int j = 0; j < currentUser.currentBlocksArray[i].length; j++) {
                currentUser.currentBlocksArray[i][j] = new InsideBlock(0, new int[]{i, j});
            }
        }

        Block randomBlock1 = new RandomBlock();
        currentUser.currentBlocksArray[randomBlock1.location[0]][randomBlock1.location[1]] = randomBlock1;

        Block randomBlock2 = new RandomBlock();
        currentUser.currentBlocksArray[randomBlock2.location[0]][randomBlock2.location[1]] = randomBlock2;
    }

}
