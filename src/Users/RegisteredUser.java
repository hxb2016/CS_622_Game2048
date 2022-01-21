package Users;

import Block.Block;

/**
 * The purpose of this class is creat a registered user
 */
public class RegisteredUser extends User {
    public Block[][] lastBlocksArray;
    public long lastTakeTime;
    public Block[][] bestBlocksArray = null;
    public long bestTakeTime = 0;


    public RegisteredUser(String name, int age, String gender) {
        super(name, age, gender);
    }

    public void setData() {
        this.lastBlocksArray = this.currentBlocksArray;
        this.lastTakeTime = this.currentTakeTime;
        if (this.currentResult.endsWith("win")) {
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

    @Override
    public String getInformation() {
        return "Username: " + this.username + "; Age: " + this.age + "; Gender: " + this.gender;
    }

    @Override
    public String getType() {
        return "RegisteredUser";
    }

    @Override
    public void setIntroduce(String introduction) {
        this.introduce = introduction;
    }
}
