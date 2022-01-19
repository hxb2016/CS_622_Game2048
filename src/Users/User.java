package Users;

import Block.Block;

public abstract class User {
    public String username;
    public int age;
    public String gender;
    public String introduce;
    public Block[][] currentBlocksArray;//it is used to creat number block interface
    public long currentTakeTime;// it is used to record the timer users take
    public String currentResult;// it is used to record win or fail

    public User() {//this constructor is used to creat Unregistered user
    }

    public User(String username, int age, String gender) {//this constructor is used to creat Registered user
        this.username = username;
        this.age = age;
        this.gender = gender;
    }

    public abstract String getInformation();//this method will return you name, age and gender as a String data type

    public abstract String getType();

    public abstract void setIntroduce(String introduce);
}
