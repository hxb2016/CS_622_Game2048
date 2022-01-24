package Block;

import Interface.GetEmptyLocation;
import Users.User;

import java.util.List;
import java.util.Random;

/**
 * The purpose of this class is to produce a random number block by given user
 */
public class RandomBlock extends Block {
    public RandomBlock(User user) {
        super();
        List<int[]> enableLocations = GetEmptyLocation.getEmptyLocation(user.currentBlocksArray);//Get empty Blocks(Block.number==0) and push they into a List
        Random random = new Random();

        int randomNum = random.nextInt(1, 3) * 2;//Creat a random number
        int[] randomLocation = enableLocations.get(random.nextInt(enableLocations.size()));//Randomly pick up an empty location from enableLocations and set this block at the place

        this.number = randomNum;
        this.location = randomLocation;
    }

}
