package Users;

import Block.Block;

/**
 * The purpose of this class is to create a registered user by given username, age and gender
 */
public class RegisteredUser extends User {
    public Block[][] lastBlocksArray;
    public long lastTakeTime;
    public Block[][] bestBlocksArray = null;
    public long bestTakeTime = 0;


    public RegisteredUser(String name, int age, String gender) {
        super(name, age, gender);
    }

    /**
     * The purpose of setData method is to set data when the game end
     */
    public void setData() {
        this.lastBlocksArray = this.currentBlocksArray;
        this.lastTakeTime = this.currentTakeTime;
        if (this.currentResult.equals("win")) {
            if (this.bestBlocksArray == null) {
                this.bestTakeTime = this.currentTakeTime;
                this.bestBlocksArray = this.currentBlocksArray;
            } else {
                if (this.bestTakeTime > this.currentTakeTime) {
                    this.bestTakeTime = this.currentTakeTime;
                    this.bestBlocksArray = this.currentBlocksArray;
                }
            }
        }

    }

    /**
     * The purpose of getInformation method is to get username, age and gender
     */
    @Override
    public String getInformation() {
        return "Username: " + this.username + "; Age: " + this.age + "; Gender: " + this.gender;
    }

    /**
     * The purpose of getType method is to get type of user object
     */
    @Override
    public String getType() {
        return "RegisteredUser";
    }

    /**
     * The purpose of setIntroduce method is to set some information about users
     */
    @Override
    public void setIntroduce(String introduction) {
        this.introduce = introduction;
    }
}
