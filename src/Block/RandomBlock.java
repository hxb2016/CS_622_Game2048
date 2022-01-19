package Block;

import Interface.DealWithInterface;
import Game2048_test.App;

import java.util.List;
import java.util.Random;

public class RandomBlock extends Block {
    public RandomBlock() {
        super();
        List<int[]> enableLocations = DealWithInterface.getAvailableLocation(App.currentUser.currentBlocksArray);
        Random random = new Random();

        int randomNum = random.nextInt(1, 3) * 2;
        int[] randomLocation = enableLocations.get(random.nextInt(enableLocations.size()));

        this.number = randomNum;
        this.location = randomLocation;
    }

}
