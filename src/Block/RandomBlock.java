package Block;

import Interface.DealWithInterface;
import Users.User;

import java.util.List;
import java.util.Random;
/**The purpose of this class is to produce a random number block*/
public class RandomBlock extends Block {
    public RandomBlock(User user) {
        super();
        List<int[]> enableLocations = DealWithInterface.getAvailableLocation(user.currentBlocksArray);
        Random random = new Random();

        int randomNum = random.nextInt(1, 3) * 2;
        int[] randomLocation = enableLocations.get(random.nextInt(enableLocations.size()));

        this.number = randomNum;
        this.location = randomLocation;
    }

}
