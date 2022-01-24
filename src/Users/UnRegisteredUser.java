package Users;

/**The purpose of this class is creat an unregistered user*/
public class UnRegisteredUser extends User {

    public UnRegisteredUser() {
    }

    @Override
    public String getInformation() {
        return "You have not registered.";
    }

    /**
     * The purpose of getType method is to get type of user object
     */
    @Override
    public String getType() {
        return "UnRegisteredUser";
    }

    @Override
    public void setIntroduce(String introduction) {
        this.introduce = "You have not registered.";
    }

}


