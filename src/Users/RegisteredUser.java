package Users;

import Block.Block;

public class RegisteredUser extends User {
    protected Block[][] lastBlocksArray;
    protected long lastTakeTime;
    protected Block[][] bestBlocksArray = null;
    protected long bestTakeTime = 0;


    public RegisteredUser(String name, int age, String gender) {
        super(name, age, gender);
    }

    public void setData(User currentUser) {
        this.lastBlocksArray = currentUser.currentBlocksArray;
        this.lastTakeTime = currentUser.currentTakeTime;
        if (currentUser.currentResult.endsWith("win")) {
            if (this.bestBlocksArray == null) {
                this.bestTakeTime = currentUser.currentTakeTime;
                this.bestBlocksArray = currentUser.currentBlocksArray;
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
