package IO;

import Block.Block;

public class OutputInterface {
    public static void outputInterface(Block[][] blocksArray) {
        /*
         * this function is used to show the interface*/

        for (Block[] blocks : blocksArray) {
            for (int j = 0; j < blocks.length; j++) {
                if (j == blocks.length - 1) {
                    if (blocks[j].number == 0) {
                        System.out.println(" * ");
                    } else {
                        System.out.println(" " + blocks[j].number + " ");
                    }
                } else {
                    if (blocks[j].number == 0) {
                        System.out.print(" * ");
                    } else {
                        System.out.print(" " + blocks[j].number + " ");
                    }
                }

                blocks[j].ifCombine = false;//clean change from last moving
            }
        }
    }
}
