import java.util.ArrayList;
import java.util.Arrays;

public class SocialNetwork {
    
    private String name;
    private ArrayList<User> currentUsers;
    
    public SocialNetwork(String name){
        this.setName(name);
        currentUsers = new ArrayList<User>();
    }

    public void addUser(User user){
        try {
            if (user.registered()){
                currentUsers.add(user);
            } else {
                throw new UserNotRegisteredException("User "+ "'" + user.getUsername() + "'" + " must first register to the social network.");
            }
        } catch (UserNotRegisteredException e) {
            System.out.println(e);
        }
        
        
    }
    
    
    public void printCurrentUsers(){
        System.out.println("Printing Current Users(" + currentUsers.size() +")......");
        for (User user : currentUsers){
            System.out.println("Username: " + user.getUsername() + "  Location: " + user.getGeoLocation() 
                                + "  Account Type: " + user.getAccountType() + "  Blocked: " + user.blocked());
        }
    }
    
    public void printPosts(){
        System.out.println("Printing all posts(" + Post.getCount() + ").....");
        
        for (User user : currentUsers){
            try {
                user.printPosts();
            } catch (NullPointerException e){
                user.printPosts();
            }
            
        }
        
        
    }
    
    /************** Getters and setters *****************/
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