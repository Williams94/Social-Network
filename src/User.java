import java.util.ArrayList;

public class User {

    private String username;
    private double geoLocation;
    private boolean registered;
    protected AccountType accountType;
    private boolean blocked;
    
    public User(String username, double geoLocation){
        this.setUsername(username);
        this.setGeoLocation(geoLocation);
        this.registered = false;
        this.blocked = false;
        this.accountType = AccountType.USER;
    }
    

    public ArrayList<Post> getPosts(){
        return null;
    }
    
   public void printPosts(){
       //System.out.println("No posts to show for " + getUsername() + ", probably because of their account type being " + getAccountType());
   }
   
   public void removePost(Post p){
       
   }
    
    public void register(){
        registered = true;
    }
    
    public boolean registered(){
        return registered;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(double geoLocation) {
        this.geoLocation = geoLocation;
    }
    
    public AccountType getAccountType(){
        return accountType;
    }
    
    public boolean blocked(){
        return blocked;
    }
    
    protected void blockUser(User u, boolean block){
        if (this.accountType != AccountType.ADMIN){
            try {
                throw new UserPermissionsException("User " + getUsername() + " needs " + AccountType.ADMIN 
                        + " account type, but has " + this.accountType);
            } catch (UserPermissionsException e) {
                System.out.println(e);
            }
        } else {
            u.blocked = block;
        }
    }
    
    public String toString(){
        return "Username: " + getUsername() + "  Location: " + getGeoLocation() + "  Account Type: " + getAccountType() 
                + "  Blocked: " + blocked();
    }
    
    public void printUser(){
        System.out.println(toString());
    }
    
    
    
}
