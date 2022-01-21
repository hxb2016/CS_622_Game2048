package IO;

import Block.Block;
/**The purpose of this class is to show number blocks interface in console*/
public class OutputInterface {
    public static void outputInterface(Block[][] blocksArray) {
        /*
         * this function is used to show the interface*/

        for (Block[] blocks : blocksArray) {
            for (int j = 0; j < blocks.length; j++) {
                if (j == blocks.length - 1) {
                    if (blocks[j].number == 0) {
                        System.out.printf("%-8s %n%n", "*");
                    } else {
                        System.out.printf("%-8d %n%n", blocks[j].number);
                    }
                } else {
                    if (blocks[j].number == 0) {
                        System.out.printf("%-8s", "*");
                    } else {
                        System.out.printf("%-8d", blocks[j].number);
                    }
                }
                blocks[j].ifCombine = false;//clean change from last moving
            }
        }
    }
}
