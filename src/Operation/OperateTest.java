package Operation;

import Block.Block;
import Block.InsideBlock;
import Game2048_test.App;
import Users.RegisteredUser;
import Users.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class OperateTest {
    public static void main(String[] args) {
        operationTest();
        //you will see below output in console, when you enter command 'd'
        // (At the same time the function will produce a random number at top left or bottom left):
        //4       2

        //*       4
    }

    public static void operationTest() {
        //Creat example blocksArray
        Block b1 = new InsideBlock(2, new int[]{0, 0});
        Block b2 = new InsideBlock(0, new int[]{0, 1});
        Block b3 = new InsideBlock(4, new int[]{1, 0});
        Block b4 = new InsideBlock(0, new int[]{1, 1});

        Block[][] blocksArray = new Block[][]{
                {b1, b2},//2    0
                {b3, b4},//0    4
        };

        User currentUser = new RegisteredUser("Xiaobing", 29, "male");
        currentUser.currentBlocksArray = blocksArray;

        //Start test
        Operate.operation(currentUser);
    }
    @Test
    public void moveUpTest() {
        //Creat example blocksArray
        Block b1 = new InsideBlock(2, new int[]{0, 0});
        Block b2 = new InsideBlock(0, new int[]{0, 1});
        Block b3 = new InsideBlock(0, new int[]{1, 0});
        Block b4 = new InsideBlock(4, new int[]{1, 1});

        Block[][] blocksArray = new Block[][]{
                {b1, b2},//2    0
                {b3, b4},//0    4
        };

        User currentUser = new RegisteredUser("Xiaobing", 29, "male");
        currentUser.currentBlocksArray = blocksArray;

        //Start Test
        Operate.moveUp(currentUser.currentBlocksArray[0][0], currentUser);
        assertEquals(2, currentUser.currentBlocksArray[0][0].number);
        assertEquals(0, currentUser.currentBlocksArray[0][1].number);
        assertEquals(0, currentUser.currentBlocksArray[1][0].number);
        assertEquals(4, currentUser.currentBlocksArray[1][1].number);

        Operate.moveUp(currentUser.currentBlocksArray[0][1], currentUser);
        assertEquals(2, currentUser.currentBlocksArray[0][0].number);
        assertEquals(0, currentUser.currentBlocksArray[0][1].number);
        assertEquals(0, currentUser.currentBlocksArray[1][0].number);
        assertEquals(4, currentUser.currentBlocksArray[1][1].number);

        Operate.moveUp(currentUser.currentBlocksArray[1][0], currentUser);
        assertEquals(2, currentUser.currentBlocksArray[0][0].number);
        assertEquals(0, currentUser.currentBlocksArray[0][1].number);
        assertEquals(0, currentUser.currentBlocksArray[1][0].number);
        assertEquals(4, currentUser.currentBlocksArray[1][1].number);

        Operate.moveUp(currentUser.currentBlocksArray[1][1], currentUser);
        assertEquals(2, currentUser.currentBlocksArray[0][0].number);
        assertEquals(4, currentUser.currentBlocksArray[0][1].number);
        assertEquals(0, currentUser.currentBlocksArray[1][0].number);
        assertEquals(0, currentUser.currentBlocksArray[1][1].number);

    }
    @Test
    public void moveLeftTest() {
        //Creat example blocksArray
        Block b1 = new InsideBlock(2, new int[]{0, 0});
        Block b2 = new InsideBlock(0, new int[]{0, 1});
        Block b3 = new InsideBlock(0, new int[]{1, 0});
        Block b4 = new InsideBlock(4, new int[]{1, 1});

        Block[][] blocksArray = new Block[][]{
                {b1, b2},//2    0
                {b3, b4},//0    4
        };

        User currentUser = new RegisteredUser("Xiaobing", 29, "male");
        currentUser.currentBlocksArray = blocksArray;

        //Start Test
        Operate.moveLeft(currentUser.currentBlocksArray[0][0], currentUser);
        assertEquals(2, currentUser.currentBlocksArray[0][0].number);
        assertEquals(0, currentUser.currentBlocksArray[0][1].number);
        assertEquals(0, currentUser.currentBlocksArray[1][0].number);
        assertEquals(4, currentUser.currentBlocksArray[1][1].number);

        Operate.moveLeft(currentUser.currentBlocksArray[0][1], currentUser);
        assertEquals(2, currentUser.currentBlocksArray[0][0].number);
        assertEquals(0, currentUser.currentBlocksArray[0][1].number);
        assertEquals(0, currentUser.currentBlocksArray[1][0].number);
        assertEquals(4, currentUser.currentBlocksArray[1][1].number);

        Operate.moveLeft(currentUser.currentBlocksArray[1][0], currentUser);
        assertEquals(2, currentUser.currentBlocksArray[0][0].number);
        assertEquals(0, currentUser.currentBlocksArray[0][1].number);
        assertEquals(0, currentUser.currentBlocksArray[1][0].number);
        assertEquals(4, currentUser.currentBlocksArray[1][1].number);

        Operate.moveLeft(currentUser.currentBlocksArray[1][1], currentUser);
        assertEquals(2, currentUser.currentBlocksArray[0][0].number);
        assertEquals(0, currentUser.currentBlocksArray[0][1].number);
        assertEquals(4, currentUser.currentBlocksArray[1][0].number);
        assertEquals(0, currentUser.currentBlocksArray[1][1].number);

    }

    @Test
    public void moveDownTest() {
        //Creat example blocksArray
        Block b1 = new InsideBlock(2, new int[]{0, 0});
        Block b2 = new InsideBlock(0, new int[]{0, 1});
        Block b3 = new InsideBlock(0, new int[]{1, 0});
        Block b4 = new InsideBlock(4, new int[]{1, 1});

        Block[][] blocksArray = new Block[][]{
                {b1, b2},//2    0
                {b3, b4},//0    4
        };

        User currentUser = new RegisteredUser("Xiaobing", 29, "male");
        currentUser.currentBlocksArray = blocksArray;

        //Start Test
        Operate.moveDown(currentUser.currentBlocksArray[0][0], currentUser);
        assertEquals(0, currentUser.currentBlocksArray[0][0].number);
        assertEquals(0, currentUser.currentBlocksArray[0][1].number);
        assertEquals(2, currentUser.currentBlocksArray[1][0].number);
        assertEquals(4, currentUser.currentBlocksArray[1][1].number);

        Operate.moveDown(currentUser.currentBlocksArray[0][1], currentUser);
        assertEquals(0, currentUser.currentBlocksArray[0][0].number);
        assertEquals(0, currentUser.currentBlocksArray[0][1].number);
        assertEquals(2, currentUser.currentBlocksArray[1][0].number);
        assertEquals(4, currentUser.currentBlocksArray[1][1].number);

        Operate.moveDown(currentUser.currentBlocksArray[1][0], currentUser);
        assertEquals(0, currentUser.currentBlocksArray[0][0].number);
        assertEquals(0, currentUser.currentBlocksArray[0][1].number);
        assertEquals(2, currentUser.currentBlocksArray[1][0].number);
        assertEquals(4, currentUser.currentBlocksArray[1][1].number);

        Operate.moveDown(currentUser.currentBlocksArray[1][1], currentUser);
        assertEquals(0, currentUser.currentBlocksArray[0][0].number);
        assertEquals(0, currentUser.currentBlocksArray[0][1].number);
        assertEquals(2, currentUser.currentBlocksArray[1][0].number);
        assertEquals(4, currentUser.currentBlocksArray[1][1].number);

    }
    @Test
    public void moveRightTest() {
        //Creat example blocksArray
        Block b1 = new InsideBlock(2, new int[]{0, 0});
        Block b2 = new InsideBlock(0, new int[]{0, 1});
        Block b3 = new InsideBlock(0, new int[]{1, 0});
        Block b4 = new InsideBlock(4, new int[]{1, 1});

        Block[][] blocksArray = new Block[][]{
                {b1, b2},//2    0
                {b3, b4},//0    4
        };

        User currentUser = new RegisteredUser("Xiaobing", 29, "male");
        currentUser.currentBlocksArray = blocksArray;

        //Start Test
        Operate.moveRight(currentUser.currentBlocksArray[0][0], currentUser);
        assertEquals(0, currentUser.currentBlocksArray[0][0].number);
        assertEquals(2, currentUser.currentBlocksArray[0][1].number);
        assertEquals(0, currentUser.currentBlocksArray[1][0].number);
        assertEquals(4, currentUser.currentBlocksArray[1][1].number);

        Operate.moveRight(currentUser.currentBlocksArray[0][1], currentUser);
        assertEquals(0, currentUser.currentBlocksArray[0][0].number);
        assertEquals(2, currentUser.currentBlocksArray[0][1].number);
        assertEquals(0, currentUser.currentBlocksArray[1][0].number);
        assertEquals(4, currentUser.currentBlocksArray[1][1].number);

        Operate.moveRight(currentUser.currentBlocksArray[1][0], currentUser);
        assertEquals(0, currentUser.currentBlocksArray[0][0].number);
        assertEquals(2, currentUser.currentBlocksArray[0][1].number);
        assertEquals(0, currentUser.currentBlocksArray[1][0].number);
        assertEquals(4, currentUser.currentBlocksArray[1][1].number);

        Operate.moveRight(currentUser.currentBlocksArray[1][1], currentUser);
        assertEquals(0, currentUser.currentBlocksArray[0][0].number);
        assertEquals(2, currentUser.currentBlocksArray[0][1].number);
        assertEquals(0, currentUser.currentBlocksArray[1][0].number);
        assertEquals(4, currentUser.currentBlocksArray[1][1].number);

    }
    @Test
    public void ifCanMoveUpTest() {
        //Creat example blocksArray
        Block b1 = new InsideBlock(2, new int[]{0, 0});
        Block b2 = new InsideBlock(0, new int[]{0, 1});
        Block b3 = new InsideBlock(0, new int[]{1, 0});
        Block b4 = new InsideBlock(4, new int[]{1, 1});

        Block[][] blocksArray = new Block[][]{
                {b1, b2},//2    0
                {b3, b4},//0    4
        };

        User currentUser = new RegisteredUser("Xiaobing", 29, "male");
        currentUser.currentBlocksArray = blocksArray;

        //Start Test
        boolean ifCanMoveUp0_0 = Operate.ifCanMoveUp(currentUser.currentBlocksArray[0][0], currentUser);
        boolean ifCanMoveUp0_1 = Operate.ifCanMoveUp(currentUser.currentBlocksArray[0][1], currentUser);
        boolean ifCanMoveUp1_0 = Operate.ifCanMoveUp(currentUser.currentBlocksArray[1][0], currentUser);
        boolean ifCanMoveUp1_1 = Operate.ifCanMoveUp(currentUser.currentBlocksArray[1][1], currentUser);
        assertFalse(ifCanMoveUp0_0);
        assertFalse(ifCanMoveUp0_1);
        assertFalse(ifCanMoveUp1_0);
        assertTrue(ifCanMoveUp1_1);
    }
    @Test
    public void ifCanMoveLeftTest() {
        //Creat example blocksArray
        Block b1 = new InsideBlock(2, new int[]{0, 0});
        Block b2 = new InsideBlock(0, new int[]{0, 1});
        Block b3 = new InsideBlock(0, new int[]{1, 0});
        Block b4 = new InsideBlock(4, new int[]{1, 1});

        Block[][] blocksArray = new Block[][]{
                {b1, b2},//2    0
                {b3, b4},//0    4
        };

        User currentUser = new RegisteredUser("Xiaobing", 29, "male");
        currentUser.currentBlocksArray = blocksArray;

        //Start Test
        boolean ifCanMoveLeft0_0 = Operate.ifCanMoveLeft(currentUser.currentBlocksArray[0][0], currentUser);
        boolean ifCanMoveLeft0_1 = Operate.ifCanMoveLeft(currentUser.currentBlocksArray[0][1], currentUser);
        boolean ifCanMoveLeft1_0 = Operate.ifCanMoveLeft(currentUser.currentBlocksArray[1][0], currentUser);
        boolean ifCanMoveLeft1_1 = Operate.ifCanMoveLeft(currentUser.currentBlocksArray[1][1], currentUser);
        assertFalse(ifCanMoveLeft0_0);
        assertFalse(ifCanMoveLeft0_1);
        assertFalse(ifCanMoveLeft1_0);
        assertTrue(ifCanMoveLeft1_1);
    }
    @Test
    public void ifCanMoveDownTest() {
        //Creat example blocksArray
        Block b1 = new InsideBlock(2, new int[]{0, 0});
        Block b2 = new InsideBlock(0, new int[]{0, 1});
        Block b3 = new InsideBlock(0, new int[]{1, 0});
        Block b4 = new InsideBlock(4, new int[]{1, 1});

        Block[][] blocksArray = new Block[][]{
                {b1, b2},//2    0
                {b3, b4},//0    4
        };

        User currentUser = new RegisteredUser("Xiaobing", 29, "male");
        currentUser.currentBlocksArray = blocksArray;

        //Start Test
        boolean ifCanMoveDown0_0 = Operate.ifCanMoveDown(currentUser.currentBlocksArray[0][0], currentUser);
        boolean ifCanMoveDown0_1 = Operate.ifCanMoveDown(currentUser.currentBlocksArray[0][1], currentUser);
        boolean ifCanMoveDown1_0 = Operate.ifCanMoveDown(currentUser.currentBlocksArray[1][0], currentUser);
        boolean ifCanMoveDown1_1 = Operate.ifCanMoveDown(currentUser.currentBlocksArray[1][1], currentUser);
        assertTrue(ifCanMoveDown0_0);
        assertFalse(ifCanMoveDown0_1);
        assertFalse(ifCanMoveDown1_0);
        assertFalse(ifCanMoveDown1_1);
    }
    @Test
    public void ifCanMoveRightTest() {
        //Creat example blocksArray
        Block b1 = new InsideBlock(2, new int[]{0, 0});
        Block b2 = new InsideBlock(0, new int[]{0, 1});
        Block b3 = new InsideBlock(0, new int[]{1, 0});
        Block b4 = new InsideBlock(4, new int[]{1, 1});

        Block[][] blocksArray = new Block[][]{
                {b1, b2},//2    0
                {b3, b4},//0    4
        };

        User currentUser = new RegisteredUser("Xiaobing", 29, "male");
        currentUser.currentBlocksArray = blocksArray;

        //Start Test
        boolean ifCanMoveRight0_0 = Operate.ifCanMoveRight(currentUser.currentBlocksArray[0][0], currentUser);
        boolean ifCanMoveRight0_1 = Operate.ifCanMoveRight(currentUser.currentBlocksArray[0][1], currentUser);
        boolean ifCanMoveRight1_0 = Operate.ifCanMoveRight(currentUser.currentBlocksArray[1][0], currentUser);
        boolean ifCanMoveRight1_1 = Operate.ifCanMoveRight(currentUser.currentBlocksArray[1][1], currentUser);
        assertTrue(ifCanMoveRight0_0);
        assertFalse(ifCanMoveRight0_1);
        assertFalse(ifCanMoveRight1_0);
        assertFalse(ifCanMoveRight1_1);
    }
    @Test
    public void isEndTest() {
        //Creat example blocksArray
        Block b1 = new InsideBlock(2, new int[]{0, 0});
        Block b2 = new InsideBlock(0, new int[]{0, 1});
        Block b3 = new InsideBlock(0, new int[]{1, 0});
        Block b4 = new InsideBlock(4, new int[]{1, 1});

        Block[][] blocksArray = new Block[][]{
                {b1, b2},//2    0
                {b3, b4},//0    4
        };

        User currentUser = new RegisteredUser("Xiaobing", 29, "male");
        currentUser.currentBlocksArray = blocksArray;

        //Start Test1
        assertFalse(Operate.isEnd(currentUser));

        //////////////////////////////////////////////
        //Creat example data
        b1 = new InsideBlock(2, new int[]{0, 0});
        b2 = new InsideBlock(4, new int[]{0, 1});
        b3 = new InsideBlock(4, new int[]{1, 0});
        b4 = new InsideBlock(2, new int[]{1, 1});

        blocksArray = new Block[][]{
                {b1, b2},//2    4
                {b3, b4},//4    2
        };

        currentUser = new RegisteredUser("Xiaobing", 29, "male");
        currentUser.currentBlocksArray = blocksArray;

        //Start Test1
        assertTrue(Operate.isEnd(currentUser));
    }
    @Test
    public void isWinTest() {
        //Creat example blocksArray
        Block b1 = new InsideBlock(2, new int[]{0, 0});
        Block b2 = new InsideBlock(0, new int[]{0, 1});
        Block b3 = new InsideBlock(0, new int[]{1, 0});
        Block b4 = new InsideBlock(4, new int[]{1, 1});

        Block[][] blocksArray = new Block[][]{
                {b1, b2},//2    0
                {b3, b4},//0    4
        };

        //Start Test1
        assertFalse(Operate.isWin(blocksArray));

        //////////////////////////////////////////////
        //Creat example data
        b1 = new InsideBlock(2, new int[]{0, 0});
        b2 = new InsideBlock(4, new int[]{0, 1});
        b3 = new InsideBlock(4, new int[]{1, 0});
        b4 = new InsideBlock(App.WINNUM, new int[]{1, 1});

        blocksArray = new Block[][]{
                {b1, b2},//2    4
                {b3, b4},//4    2
        };

        //Start Test1
        assertTrue(Operate.isWin(blocksArray));
    }

}
