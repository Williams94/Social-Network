import java.util.ArrayList;

public class PremiumUser extends User {
    
    private static final int subscriptionFee = 30;  
    private boolean paidFee;
    
    protected ArrayList<Post> createdPosts;

    public PremiumUser(String username, double geoLocation) {
        super(username, geoLocation);
        this.accountType = AccountType.PREMIUM;
        this.setPaidFee(false);
        setCreatedPosts(new ArrayList<Post>());
    }
    
    public void payFee(int amount){
        if(amount >= subscriptionFee){
            setPaidFee(true);
        } else {
            System.out.println("User " + getUsername() + " needs to pay " + (subscriptionFee-amount) + " more to be a premium member.");
        }
    }
    
    public void createPost(Post p){
        try{
            if ((accountType == AccountType.PREMIUM && isPaidFee()) || (accountType == AccountType.ADMIN) && (this.blocked() != true)){
                getCreatedPosts().add(p);
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

    private boolean isPaidFee() {
        return paidFee;
    }

    private void setPaidFee(boolean paidFee) {
        this.paidFee = paidFee;
    }

    public ArrayList<Post> getCreatedPosts() {
        return createdPosts;
    }

    public void setCreatedPosts(ArrayList<Post> createdPosts) {
        this.createdPosts = createdPosts;
    }
}
