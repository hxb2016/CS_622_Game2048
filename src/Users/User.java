package Users;

import Block.Block;

import java.io.Serializable;

/**This class is an abstract class*/
public abstract class User implements Serializable {
    public static final long serialVersionUID = 1L;
    public String username;
    public int age;
    public String gender;
    public String introduce;
    public Block[][] currentBlocksArray;//it is used to create number block interface
    public long currentTakeTime;// it is used to record the timer users take
    public String currentResult;// it is used to record win or fail

    public User() {//this constructor is used to create Unregistered user
    }

    public User(String username, int age, String gender) {//this constructor is used to create Registered user
        this.username = username;
        this.age = age;
        this.gender = gender;
    }

    public abstract String getInformation();//this method will return you name, age and gender as a String data type

    public abstract String getType();

    public abstract void setIntroduce(String introduce);
}
