package Operation;

import Block.Block;
import Block.InsideBlock;
import Block.RandomBlock;
import Game2048_test.App;
import IO.OutputInterface;
import Users.User;

import java.util.Scanner;

/**
 * The purpose of this class is to deal with moving and combining of block, when the game system receive a command
 */
public class Operate {
    public static boolean ifMoving = false;

    /**
     * The purpose of operation method is to deal with moving and combining of block, when the game system receive a command
     */
    public static void operation(User currentUser) {
        Scanner input = new Scanner(System.in);
        while (!isWin(currentUser.currentBlocksArray) && !isEnd(currentUser)) {
            System.out.print("Please Enter Next Command(w/a/s/d,Quit press 'k'): ");
            String command = input.next();

            if (command.equals("k")) {
                System.out.println("You have quit from the game");
                break;
            }

            if (command.equals("w") || command.equals("a")) {
                for (int i = 0; i < currentUser.currentBlocksArray.length; i++) {
                    for (int j = 0; j < currentUser.currentBlocksArray[i].length; j++) {
                        switch (command) {
                            case "w" -> moveUp(currentUser.currentBlocksArray[i][j], currentUser);
                            case "a" -> moveLeft(currentUser.currentBlocksArray[i][j], currentUser);
                        }
                    }
                }
            } else {
                for (int i = currentUser.currentBlocksArray.length - 1; i >= 0; i--) {
                    for (int j = currentUser.currentBlocksArray[i].length - 1; j >= 0; j--) {
                        switch (command) {
                            case "s" -> moveDown(currentUser.currentBlocksArray[i][j], currentUser);
                            case "d" -> moveRight(currentUser.currentBlocksArray[i][j], currentUser);
                        }
                    }
                }
            }

            if (ifMoving) {//it will generate a random block, if any block has been moved
                Block randomBlock = new RandomBlock(currentUser);
                currentUser.currentBlocksArray[randomBlock.location[0]][randomBlock.location[1]] = randomBlock;
                ifMoving = false;
            }

            OutputInterface.outputInterface(currentUser.currentBlocksArray);
        }
        if (isEnd(currentUser)) {
            System.out.println("===Game Over===");
            if (isWin(currentUser.currentBlocksArray)) {
                currentUser.currentResult = "win";
                System.out.println("YOU WIN!!!");
            } else {
                currentUser.currentResult = "fail";
                System.out.println("Sorry Your Fail!");
            }
            System.out.println("You take 0 minute and 0 second");
        }
    }

    //==============================================================================

    /**
     * The purpose of moveUp method is to deal with blocks which need move up
     */
    public static void moveUp(Block block, User currentUser) {
        boolean ifBreak = false;
        while (ifCanMoveUp(block, currentUser) && !ifBreak) {
            ifMoving = true;
            Block newBlock = new InsideBlock(0, block.location);
            if (currentUser.currentBlocksArray[block.location[0] - 1][block.location[1]].number != 0) {//judge that if a block first time happen combining
                ifBreak = true;
                block.ifCombine = true;
            }
            block.number = currentUser.currentBlocksArray[block.location[0] - 1][block.location[1]].number + block.number;
            block.location = currentUser.currentBlocksArray[block.location[0] - 1][block.location[1]].location;
            currentUser.currentBlocksArray[block.location[0]][block.location[1]] = block;

            currentUser.currentBlocksArray[newBlock.location[0]][newBlock.location[1]] = newBlock;
        }
    }

    /**
     * The purpose of moveLeft method is to deal with blocks which need move left
     */
    public static void moveLeft(Block block, User currentUser) {

        boolean ifBreak = false;
        while (ifCanMoveLeft(block, currentUser) && !ifBreak) {
            ifMoving = true;
            Block newBlock = new InsideBlock(0, block.location);

            if (currentUser.currentBlocksArray[block.location[0]][block.location[1] - 1].number != 0) {//judge that if a block first time happen combining
                ifBreak = true;
                block.ifCombine = true;
            }
            block.number = currentUser.currentBlocksArray[block.location[0]][block.location[1] - 1].number + block.number;
            block.location = currentUser.currentBlocksArray[block.location[0]][block.location[1] - 1].location;
            currentUser.currentBlocksArray[block.location[0]][block.location[1]] = block;
            currentUser.currentBlocksArray[newBlock.location[0]][newBlock.location[1]] = newBlock;

        }
    }

    /**
     * The purpose of moveDown method is to deal with blocks which need move down
     */
    public static void moveDown(Block block, User currentUser) {
        boolean ifBreak = false;
        while (ifCanMoveDown(block, currentUser) && !ifBreak) {
            ifMoving = true;
            Block newBlock = new InsideBlock(0, block.location);
            if (currentUser.currentBlocksArray[block.location[0] + 1][block.location[1]].number != 0) {//judge that if a block first time happen combining
                ifBreak = true;
                block.ifCombine = true;
            }

            block.number = currentUser.currentBlocksArray[block.location[0] + 1][block.location[1]].number + block.number;
            block.location = currentUser.currentBlocksArray[block.location[0] + 1][block.location[1]].location;
            currentUser.currentBlocksArray[block.location[0]][block.location[1]] = block;

            currentUser.currentBlocksArray[newBlock.location[0]][newBlock.location[1]] = newBlock;

        }
    }

    /**
     * The purpose of moveRight method is to deal with blocks which need move right
     */
    public static void moveRight(Block block, User currentUser) {
        boolean ifBreak = false;
        while (ifCanMoveRight(block, currentUser) && !ifBreak) {
            ifMoving = true;
            Block newBlock = new InsideBlock(0, block.location);
            if (currentUser.currentBlocksArray[block.location[0]][block.location[1] + 1].number != 0) {//judge that if a block first time happen combining
                ifBreak = true;
                block.ifCombine = true;
            }

            block.number = currentUser.currentBlocksArray[block.location[0]][block.location[1] + 1].number + block.number;
            block.location = currentUser.currentBlocksArray[block.location[0]][block.location[1] + 1].location;
            currentUser.currentBlocksArray[block.location[0]][block.location[1]] = block;

            currentUser.currentBlocksArray[newBlock.location[0]][newBlock.location[1]] = newBlock;
        }
    }

    //========================================================================================================

    /**
     * The purpose of ifCanMoveUp method is to judge that if a block can move up
     */
    public static boolean ifCanMoveUp(Block block, User currentUser) {
        if (block.location[0] == 0) {//if the block on the edge, it can not move
            return false;
        }

        if (block.number == 0) {//if the block.number equal to 0, it can not move
            return false;
        }

        if (currentUser.currentBlocksArray[block.location[0] - 1][block.location[1]].ifCombine) {
            //if the next block of the block on the direction of movement has been combined, it can not move
            return false;
        }

        //if the next block.number of the block on the direction of movement equal to 0 or the block.number, it can move
        return currentUser.currentBlocksArray[block.location[0] - 1][block.location[1]].number == 0
                || currentUser.currentBlocksArray[block.location[0] - 1][block.location[1]].number == block.number;
    }

    /**
     * The purpose of ifCanMoveLeft method is to judge that if a block can move left
     */
    public static boolean ifCanMoveLeft(Block block, User currentUser) {
        if (block.location[1] == 0) {
            return false;
        }

        if (block.number == 0) {
            return false;
        }

        if (currentUser.currentBlocksArray[block.location[0]][block.location[1] - 1].ifCombine) {
            return false;
        }

        return currentUser.currentBlocksArray[block.location[0]][block.location[1] - 1].number == 0
                || currentUser.currentBlocksArray[block.location[0]][block.location[1] - 1].number == block.number;

    }

    /**
     * The purpose of ifCanMoveDown method is to judge that if a block can move down
     */
    public static boolean ifCanMoveDown(Block block, User currentUser) {
        if (block.location[0] == currentUser.currentBlocksArray.length - 1) {
            return false;
        }

        if (block.number == 0) {
            return false;
        }

        if (currentUser.currentBlocksArray[block.location[0] + 1][block.location[1]].ifCombine) {
            return false;
        }

        return currentUser.currentBlocksArray[block.location[0] + 1][block.location[1]].number == 0
                || currentUser.currentBlocksArray[block.location[0] + 1][block.location[1]].number == block.number;
    }

    /**
     * The purpose of ifCanMoveRight method is to judge that if a block can move right
     */
    public static boolean ifCanMoveRight(Block block, User currentUser) {
        if (block.location[1] == currentUser.currentBlocksArray.length - 1) {
            return false;
        }

        if (block.number == 0) {
            return false;
        }

        if (currentUser.currentBlocksArray[block.location[0]][block.location[1] + 1].ifCombine) {
            return false;
        }

        return currentUser.currentBlocksArray[block.location[0]][block.location[1] + 1].number == 0
                || currentUser.currentBlocksArray[block.location[0]][block.location[1] + 1].number == block.number;

    }

    /**
     * The purpose of isEnd method is to judge that if the game is ending
     */
    public static boolean isEnd(User currentUser) {
        for (Block[] blocks : currentUser.currentBlocksArray) {
            for (Block block : blocks) {
                if (ifCanMoveDown(block, currentUser) || ifCanMoveUp(block, currentUser) || ifCanMoveLeft(block, currentUser) || ifCanMoveRight(block, currentUser)) {
                    return isWin(currentUser.currentBlocksArray);
                }
            }
        }
        return true;
    }

    /**
     * The purpose of isWin method is to judge that if the game is winning
     */
    public static boolean isWin(Block[][] blocksArray) {
        int maxNum = 0;
        for (Block[] blocks : blocksArray) {
            for (Block block : blocks) {
                maxNum = Math.max(maxNum, block.number);
            }
        }
        return maxNum >= App.WINNUM;
    }
}
