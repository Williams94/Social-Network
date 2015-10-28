import java.util.ArrayList;

public class PremiumUser extends User {
    
    private static final int subscriptionFee = 30;  
    private ArrayList<Post> createdPosts;

    public PremiumUser(String username, double geoLocation) {
        super(username, geoLocation);
        this.accountType = AccountType.PREMIUM;
        createdPosts = new ArrayList<Post>();
    }
    
    public void createPost(Post p){
        try{
            if (accountType == accountType.PREMIUM){
                createdPosts.add(p);
            } else {
                throw new UserPermissionsException("User " + getUsername() + " needs " + AccountType.PREMIUM 
                        + " account type, but has " + this.accountType);
            }
        } catch (UserPermissionsException e){
            System.out.println(e);
        }
    }
    
    public void deletePost(Post p){
        try{
            if (getPosts().contains(p)){
                createdPosts.remove(p);
            } else {
                throw new UserPermissionsException("User " + getUsername() + " needs to be an " + AccountType.ADMIN 
                        + " ato delete someone elses post, but is only a " + this.accountType + " user.");
            }
        } catch (UserPermissionsException e){
            System.out.println(e);
        }
    }
    
    public void createReply(Reply reply){
        try{
            if (accountType == accountType.PREMIUM){
                createdPosts.add(reply);
            } else {
                throw new UserPermissionsException("User " + getUsername() + " needs " + AccountType.PREMIUM 
                        + " account type, but has " + this.accountType);
            }
        } catch (UserPermissionsException e){
            System.out.println(e);
        }
    }
    
    @Override
    public ArrayList<Post> getPosts(){
        return createdPosts;
    }
    
    @Override
    public void printPosts(){
        if(!createdPosts.isEmpty()){
            System.out.println("Printing out " + getUsername() + "'s posts.......");
            for (Post post : createdPosts){
                if (post instanceof Reply){
                    ((Reply) post).printReply(); 
                } else {
                    post.printPost();                    
                    
                }
            }
        } else {
            System.out.println("No posts created yet for " + getUsername());
        }
        
    }
}
