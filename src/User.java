import java.util.ArrayList;

/**
 * @author rbwilliams
 *
 */
public class User {

    private String username;
    private double geoLocation;
    private boolean registered;
    protected AccountType accountType;
    private boolean blocked;
    
    /**
     * @param username      - of user
     * @param geoLocation   - location of user
     */
    public User(String username, double geoLocation){
        this.setUsername(username);
        this.setGeoLocation(geoLocation);
        this.registered = false;
        this.blocked = false;
        this.accountType = AccountType.USER;
    }
    

    /**
     * @return null since Users can't post therefore have no posts
     */
    public ArrayList<Post> getPosts(){
        return null;
    }
    
    /**
     * prints nothing since Users can't post therefore have no posts
     */
    public void printPosts(){
       //System.out.println("No posts to show for " + getUsername() + ", probably because of their account type being " + getAccountType());
    }
   
    /**
     *  @param post to be removed, but can't since only User
     */
    public void removePost(Post p){
       try {
        throw new UserPermissionsException("User " + getUsername() + " needs to be an " + AccountType.ADMIN 
                   + " to delete someone elses post, but is only a " + this.accountType + " user.");
    } catch (UserPermissionsException e) {
        System.out.println(e);
    }
    }
    
    
    /**
     *  registers the user
     */
    public void register(){
        registered = true;
    }
    
    
    /**
     * @return true if the user is registered
     */
    public boolean registered(){
        return registered;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return users location
     */
    public double getGeoLocation() {
        return geoLocation;
    }

    /**
     * @param geoLocation of user
     */
    public void setGeoLocation(double geoLocation) {
        this.geoLocation = geoLocation;
    }
    
    /**
     * @return type of account
     */
    public AccountType getAccountType(){
        return accountType;
    }
    
    /**
     * @return true if user has been blocked
     */
    public boolean blocked(){
        return blocked;
    }
    
    /**
     * Since only administrators can block users this will throw an exception if called by any other type of user
     * @param u     - user to block
     * @param block - true to block user false to unblock
     */
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


    /**
     * Since only administrators can restrict file types this will throw an exception if called by any other type of user
     * @param fileType - file type to be restricted to
     */
    protected void setFileType(String fileType) {
        try {
            throw new UserPermissionsException("User " + getUsername() + " needs " + AccountType.ADMIN 
                    + " account type, but has " + this.accountType);
        } catch (UserPermissionsException e) {
            System.out.println(e);
        }
    }
    
    
    
}
