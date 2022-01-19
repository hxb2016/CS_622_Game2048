package Interface;

import Block.Block;

import java.util.ArrayList;
import java.util.List;

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
