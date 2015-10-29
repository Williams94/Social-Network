import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        
        // Social Network
        SocialNetwork bookFace = new SocialNetwork("bookFace");

        // Users
        User ross = new User("ross", 1.2);
        PremiumUser ben = new PremiumUser("ben", 3.1);
        PremiumUser bob = new PremiumUser("bob", 5.0);
        Administrator sally = new Administrator("sally", 2.3);
        Administrator lucy = new Administrator("lucy",0.9);
        
        ross.register();
        ben.register();
        ben.payFee(30);
        bob.register();
        bob.payFee(30);
        sally.register();
        sally.payFee(30);
        lucy.register();
        
        Post p1 = new Post(ben, "Hi my name is ben, I'm new to Book Face");
        ben.createPost(p1);
        
        Post p2 = new Post(bob, "This is my first post to Book Face!");
        bob.createPost(p2);
        
        Post p3 = new Post(sally, "Yo it's Sally...");
        sally.createPost(p3);
        
        
        
        Reply r1 = new Reply(sally, p2, "I dont like your post");
        sally.createReply(r1);
        
        
        
        Reply r2 = new Reply(bob, r1, "Thanks!");
        bob.createReply(r2);
        
        
        
        // Add Users to Social Network
        bookFace.addUser(ross);
        bookFace.addUser(ben);
        bookFace.addUser(bob);
        bookFace.addUser(sally);
        bookFace.addUser(lucy);
        
        bookFace.printCurrentState();
        System.out.println("\n");
        
        lucy.blockUser(sally);
        
        bookFace.printCurrentState();

/*    bookFace.printPosts();
    System.out.println("\n");
    
    sally.removePost(p3);
    lucy.removePost(p2);
    
    
    
    bookFace.printPosts();
*/
        }
}
