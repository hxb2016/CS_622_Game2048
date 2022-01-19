package Operation;

import Block.Block;
import Block.InsideBlock;
import Block.RandomBlock;
import Game2048_test.App;
import IO.OutputInterface;
import Interface.DealWithInterface;

import java.util.List;
import java.util.Scanner;

public class Operate {
    public final static int WINNUM = 2048;
    public static boolean ifMoving = false;

    public static void operation() {
        Scanner input = new Scanner(System.in);
        while (!isWin(App.currentUser.currentBlocksArray) && !isEnd(App.currentUser.currentBlocksArray)) {
            System.out.print("Please Enter Next Command(w/a/s/d,Quit press 'k'): ");
            String command = input.next();

            if (command.equals("k")) {
                System.out.println("You have quit from the game");
                break;
            }

            if (command.equals("w") || command.equals("a")) {
                for (int i = 0; i < App.currentUser.currentBlocksArray.length; i++) {
                    for (int j = 0; j < App.currentUser.currentBlocksArray[i].length; j++) {
                        switch (command) {
                            case "w" -> moveUp(App.currentUser.currentBlocksArray[i][j]);
                            case "a" -> moveLeft(App.currentUser.currentBlocksArray[i][j]);
                        }
                    }
                }
            } else {
                for (int i = App.currentUser.currentBlocksArray.length - 1; i >= 0; i--) {
                    for (int j = App.currentUser.currentBlocksArray[i].length - 1; j >= 0; j--) {
                        switch (command) {
                            case "s" -> moveDown(App.currentUser.currentBlocksArray[i][j]);
                            case "d" -> moveRight(App.currentUser.currentBlocksArray[i][j]);
                        }
                    }
                }
            }

            if (ifMoving) {//it will generate a random block, if any block has been moved
                Block randomBlock = new RandomBlock();
                App.currentUser.currentBlocksArray[randomBlock.location[0]][randomBlock.location[1]] = randomBlock;
                ifMoving = false;
            }

            OutputInterface.outputInterface(App.currentUser.currentBlocksArray);
        }
        if (isEnd(App.currentUser.currentBlocksArray)) {
            System.out.println("===Game Over===");
            if (isWin(App.currentUser.currentBlocksArray)) {
                App.currentUser.currentResult = "win";
                System.out.println("YOU WIN!!!");
            } else {
                App.currentUser.currentResult = "fail";
                System.out.println("Sorry Your Fail!");
            }
            System.out.println("You take 0 minute and 0 second");
        }
    }

    //==============================================================================
    public static void moveUp(Block block) {
        boolean ifBreak = false;
        while (ifCanMoveUp(block) && !ifBreak) {
            ifMoving = true;
            Block newBlock = new InsideBlock(0, block.location);
            if (App.currentUser.currentBlocksArray[block.location[0] - 1][block.location[1]].number != 0) {//judge if the first combining happen
                ifBreak = true;
                block.ifCombine = true;
            }
            block.number = App.currentUser.currentBlocksArray[block.location[0] - 1][block.location[1]].number + block.number;
            block.location = App.currentUser.currentBlocksArray[block.location[0] - 1][block.location[1]].location;
            App.currentUser.currentBlocksArray[block.location[0]][block.location[1]] = block;

            App.currentUser.currentBlocksArray[newBlock.location[0]][newBlock.location[1]] = newBlock;
        }
    }


    public static void moveLeft(Block block) {

        boolean ifBreak = false;
        while (ifCanMoveLeft(block) && !ifBreak) {
            ifMoving = true;
            Block newBlock = new InsideBlock(0, block.location);

            if (App.currentUser.currentBlocksArray[block.location[0]][block.location[1] - 1].number != 0) {//judge if the first combining happen
                ifBreak = true;
                block.ifCombine = true;
            }
            block.number = App.currentUser.currentBlocksArray[block.location[0]][block.location[1] - 1].number + block.number;
            block.location = App.currentUser.currentBlocksArray[block.location[0]][block.location[1] - 1].location;
            App.currentUser.currentBlocksArray[block.location[0]][block.location[1]] = block;
            App.currentUser.currentBlocksArray[newBlock.location[0]][newBlock.location[1]] = newBlock;

        }
    }


    public static void moveDown(Block block) {
        boolean ifBreak = false;
        while (ifCanMoveDown(block) && !ifBreak) {
            ifMoving = true;
            Block newBlock = new InsideBlock(0, block.location);
            if (App.currentUser.currentBlocksArray[block.location[0] + 1][block.location[1]].number != 0) {//judge if the first combining happen
                ifBreak = true;
                block.ifCombine = true;
            }

            block.number = App.currentUser.currentBlocksArray[block.location[0] + 1][block.location[1]].number + block.number;
            block.location = App.currentUser.currentBlocksArray[block.location[0] + 1][block.location[1]].location;
            App.currentUser.currentBlocksArray[block.location[0]][block.location[1]] = block;

            App.currentUser.currentBlocksArray[newBlock.location[0]][newBlock.location[1]] = newBlock;

        }
    }


    public static void moveRight(Block block) {
        boolean ifBreak = false;
        while (ifCanMoveRight(block) && !ifBreak) {
            ifMoving = true;
            Block newBlock = new InsideBlock(0, block.location);
            if (App.currentUser.currentBlocksArray[block.location[0]][block.location[1] + 1].number != 0) {//judge if the first combining happen
                ifBreak = true;
                block.ifCombine = true;
            }

            block.number = App.currentUser.currentBlocksArray[block.location[0]][block.location[1] + 1].number + block.number;
            block.location = App.currentUser.currentBlocksArray[block.location[0]][block.location[1] + 1].location;
            App.currentUser.currentBlocksArray[block.location[0]][block.location[1]] = block;

            App.currentUser.currentBlocksArray[newBlock.location[0]][newBlock.location[1]] = newBlock;
        }
    }

    //========================================================================================================
    public static boolean ifCanMoveUp(Block block) {//judge if the block can move up
        if (block.location[0] == 0) {//if the block on the edge, it can not move
            return false;
        }

        if (block.number == 0) {//if the block.number equal to 0, it can not move
            return false;
        }

        if (App.currentUser.currentBlocksArray[block.location[0] - 1][block.location[1]].ifCombine) {
            //if the next block of the block on the direction of movement has been combined, it can not move
            return false;
        }

        //if the next block.number of the block on the direction of movement equal to 0 or the block.number, it can move
        return App.currentUser.currentBlocksArray[block.location[0] - 1][block.location[1]].number == 0
                || App.currentUser.currentBlocksArray[block.location[0] - 1][block.location[1]].number == block.number;
    }


    public static boolean ifCanMoveLeft(Block block) {// judge the block can move to left
        if (block.location[1] == 0) {
            return false;
        }

        if (block.number == 0) {
            return false;
        }

        if (App.currentUser.currentBlocksArray[block.location[0]][block.location[1] - 1].ifCombine) {
            return false;
        }

        return App.currentUser.currentBlocksArray[block.location[0]][block.location[1] - 1].number == 0
                || App.currentUser.currentBlocksArray[block.location[0]][block.location[1] - 1].number == block.number;

    }


    public static boolean ifCanMoveDown(Block block) {// judge the block can move to down
        if (block.location[0] == App.interfaceSize - 1) {
            return false;
        }

        if (block.number == 0) {
            return false;
        }

        if (App.currentUser.currentBlocksArray[block.location[0] + 1][block.location[1]].ifCombine) {
            return false;
        }

        return App.currentUser.currentBlocksArray[block.location[0] + 1][block.location[1]].number == 0
                || App.currentUser.currentBlocksArray[block.location[0] + 1][block.location[1]].number == block.number;
    }


    public static boolean ifCanMoveRight(Block block) {// judge the block can move to right
        if (block.location[1] == App.interfaceSize - 1) {
            return false;
        }

        if (block.number == 0) {
            return false;
        }

        if (App.currentUser.currentBlocksArray[block.location[0]][block.location[1] + 1].ifCombine) {
            return false;
        }

        return App.currentUser.currentBlocksArray[block.location[0]][block.location[1] + 1].number == 0
                || App.currentUser.currentBlocksArray[block.location[0]][block.location[1] + 1].number == block.number;

    }


    public static boolean isEnd(Block[][] blocksArray) {
        List<int[]> enableLocation = DealWithInterface.getAvailableLocation(blocksArray);
        return enableLocation.size() == 0;
    }

    public static boolean isWin(Block[][] blocksArray) {
        int maxNum = 0;
        for (Block[] blocks : blocksArray) {
            for (Block block : blocks) {
                maxNum = Math.max(maxNum, block.number);
            }
        }
        return maxNum >= WINNUM;
    }
}
