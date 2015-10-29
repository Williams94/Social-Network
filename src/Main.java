import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
        
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
        
        Text p1 = new Text(ben, "Hi my name is ben, I'm new to Book Face", format.parse("11/10/2015 15:30"));
        ben.createPost(p1);
        
        Text p2 = new Text(bob, "This is my first Text to Book Face!", format.parse("12/10/2015 12:30"));
        bob.createPost(p2);
        
        Image i1 = new Image(sally, "Yo it's Sally...", "src/image.png", format.parse("13/10/2015 17:20"));
        sally.createPost(i1);
        
        Video v1 = new Video(bob, "My video", "src/video.mp4", format.parse("14/10/2015 18:15"));
        
        Audio a1 = new Audio(ben, "My new song", "src/audio.wav", format.parse("15/10/2015 10:55"));
        
        bob.createPost(v1);
        ben.createPost(a1);
        
        Post r1 = new Post(sally, p2, "I dont like your post", format.parse("12/10/2015 14:30"));
        sally.createPost(r1);
        
        
        
        Post r2 = new Post(bob, r1, "Thanks!", format.parse("12/10/2015 19:30"));
        bob.createPost(r2);
        
        Post r3 = new Post(lucy, p2, "Dont worry I like your post!", format.parse("12/10/2015 15:00"));
        
        lucy.createPost(r3);
        
        // Add Users to Social Network
        bookFace.addUser(ross);
        bookFace.addUser(ben);
        bookFace.addUser(bob);
        bookFace.addUser(sally);
        bookFace.addUser(lucy);
        
        bookFace.printCurrentState();
        System.out.println("\n");
        
        bob.printPosts();
        
        System.out.println("\n");
        
        bookFace.printCurrentState();
        
        }
}
