package Interface;

import Block.Block;

import java.util.ArrayList;
import java.util.List;
/**The purpose of this class is to get all the number block that are empty*/
public class DealWithInterface {
    public static List<int[]> getAvailableLocation(Block[][] blocksArray) {
        List<int[]> enableLocation = new ArrayList<>();
        for (Block[] blocks : blocksArray) {
            for (Block block : blocks) {
                if (blockIsEnable(block)) {
                    enableLocation.add(block.location);
                }
            }
        }
        return enableLocation;
    }

    private static boolean blockIsEnable(Block block) {
        return block.number == 0;
    }
}
