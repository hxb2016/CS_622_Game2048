package Interface;

import Block.Block;

import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of this class is to get all the number block that are empty
 */
public class GetEmptyLocation {
    /**
     * The purpose of getEmptyLocation method is to get all the number block that are empty
     */
    public static List<int[]> getEmptyLocation(Block[][] blocksArray) {
        List<int[]> enableLocation = new ArrayList<>();
        for (Block[] blocks : blocksArray) {
            for (Block block : blocks) {
                if (blockIsEmpty(block)) {
                    enableLocation.add(block.location);
                }
            }
        }
        return enableLocation;
    }

    /**
     * The purpose of blockIsEmpty method is to judge that a block is empty or not
     */
    public static boolean blockIsEmpty(Block block) {
        return block.number == 0;
    }
}
