import java.util.ArrayList;

public class SocialNetwork {
    
    private String name;
    private ArrayList<User> currentUsers;
    
    public SocialNetwork(String name){
        this.setName(name);
        
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public ArrayList<User> getCurrentUsers() {
        return currentUsers;
    }

    public void setCurrentUsers(ArrayList<User> currentUsers) {
        this.currentUsers = currentUsers;
    }
    
    
    

}
