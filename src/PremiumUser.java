import java.util.ArrayList;

/**
 * @author rbwilliams
 *
 */
public class PremiumUser extends User {
    
    private static final int subscriptionFee = 30;  
    private boolean paidFee;
    
    protected ArrayList<Post> createdPosts;

    /**
     * @param username      - of user
     * @param geoLocation   - location of user
     */
    public PremiumUser(String username, double geoLocation) {
        super(username, geoLocation);
        this.accountType = AccountType.PREMIUM;
        this.setPaidFee(false);
        setCreatedPosts(new ArrayList<Post>());
    }
    
    /**
     * @param amount to pay needs to be >=30 
     */
    public void payFee(int amount){
        if(amount >= subscriptionFee){
            setPaidFee(true);
        } else {
            System.out.println("User " + getUsername() + " needs to pay " + (subscriptionFee-amount) + " more to be a premium member.");
        }
    }
    
    /**
     * @param post to be created
     */
    public void createPost(Post p){
        try{
            if ((accountType == AccountType.PREMIUM && isPaidFee()) || (accountType == AccountType.ADMIN) && (this.blocked() != true)){
                if (p.isValid()){
                    getCreatedPosts().add(p);
                }
            } else if(!isPaidFee()){
                throw new UserPermissionsException("User " + getUsername() + " needs to pay the subscript fee of £" + subscriptionFee);
            } else if(this.blocked()){
                throw new UserPermissionsException("User " + getUsername() + " has been blocked by and Administrator");
            } else {
                throw new UserPermissionsException("User " + getUsername() + " needs " + AccountType.PREMIUM 
                        + " account type, but has " + this.accountType);
            }
        } catch (UserPermissionsException e){
            System.out.println(e);
        }
    }
    
    public void removePost(Post p){
        try{
            if(isPaidFee() && createdPosts.contains(p) && (this.blocked() != true)){
                getCreatedPosts().remove(p);
            } else if(!isPaidFee()){
                throw new UserPermissionsException("User " + getUsername() + " needs to pay the subscript fee of £" + subscriptionFee);
            } else if(this.blocked()){
                throw new UserPermissionsException("User " + getUsername() + " has been blocked by and Administrator");
            } else {
                throw new UserPermissionsException("User " + getUsername() + " needs to be an " + AccountType.ADMIN 
                        + " ato delete someone elses post, but is only a " + this.accountType + " user.");
            }
        } catch (UserPermissionsException e){
            System.out.println(e);
        }
    }
    
    @Override
    public ArrayList<Post> getPosts(){
        return getCreatedPosts();
    }
    
    @Override
    public void printPosts(){
        if(!getCreatedPosts().isEmpty()){
            System.out.println("Printing out " + getUsername() + "'s posts.......");
            for (Post post : getCreatedPosts()){
                    post.printPost();                    
            }
        } else {
            System.out.println("No posts created yet for " + getUsername());
        }
        
    }

    /**
     * @return true if the user has paid the correct fee
     */
    private boolean isPaidFee() {
        return paidFee;
    }

    /**
     * @param set paidfee boolean
     */
    private void setPaidFee(boolean paidFee) {
        this.paidFee = paidFee;
    }

    /**
     * @return all posts created by this user
     */
    public ArrayList<Post> getCreatedPosts() {
        return createdPosts;
    }

    /**
     * @param createdPosts set the created posts of this user
     */
    public void setCreatedPosts(ArrayList<Post> createdPosts) {
        this.createdPosts = createdPosts;
    }
}
