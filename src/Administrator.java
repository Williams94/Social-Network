import java.util.ArrayList;

public class Administrator extends PremiumUser {
    
    ArrayList<User> blockedUsers = new ArrayList<User>();

    public Administrator(String username, double geoLocation) {
        super(username, geoLocation);
        this.accountType = AccountType.ADMIN;
    }
    
    @Override
    public void removePost(Post post){
        for ( Post p : SocialNetwork.getAllPosts()){
            if (p.equals(post)){
               User u = p.getSender();
               u.removePost(p);
            }
        }

    }

}
