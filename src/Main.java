import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        
        // Social Network
        SocialNetwork bookFace = new SocialNetwork("bookFace");

        // Users
        User ross = new User("ross", 1.2);
        ross.register();
        
        PremiumUser ben = new PremiumUser("ben", 3.1);
        ben.register();
        Post p1 = new Post(ben, "Hi my name is ben, I'm new to Book Face");
        ben.createPost(p1);
        
        PremiumUser bob = new PremiumUser("bob", 5.0);
        bob.register();
        Post p2 = new Post(bob, "This is my first post to Book Face!");
        bob.createPost(p2);
        
        PremiumUser sally = new PremiumUser("sally", 2.3);
        sally.register();
        Post p3 = new Post(sally, "Yo it's Sally...");
        sally.createPost(p3);
        sally.deletePost(p2);
        Reply r1 = new Reply(sally, p2, "I dont like your post");
        sally.createReply(r1);
        
        Reply r2 = new Reply(bob, r1, "Thanks!");
        bob.createReply(r2);
        
        // Add Users to Social Network
        bookFace.addUser(ross);
        bookFace.addUser(ben);
        bookFace.addUser(bob);
        bookFace.addUser(sally);
        
        bookFace.printCurrentUsers();
        System.out.println("\n");
        bookFace.printPosts();
    }

}
