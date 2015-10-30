import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;

/**
 * @author rbwilliams
 *
 */
public class Main {

   
    public static void main(String[] args) throws ParseException {
        
        
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
        
        // Social Network
        SocialNetwork bookFace = new SocialNetwork("bookFace");

        // Users
        Guest ross = new Guest("ross", 1.2);
        PremiumUser ben = new PremiumUser("ben", 3.1);
        PremiumUser bob = new PremiumUser("bob", 5.0);
        PremiumUser dave = new PremiumUser("dave", 12.9);
        Administrator sally = new Administrator("sally", 2.3);
        Administrator lucy = new Administrator("lucy",0.9);
        
        ross.register();
        ben.register();
        ben.payFee(30);
        bob.register();
        bob.payFee(30);
        dave.payFee(30);
        dave.register();
        sally.register();
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
        
        Text r1 = new Text(sally, p2, "I dont like your post", format.parse("12/10/2015 14:30"));
        sally.createPost(r1);
        
        
        
        Text r2 = new Text(bob, r1, "Thanks!", format.parse("12/10/2015 19:30"));
        bob.createPost(r2);
        
        Text r3 = new Text(lucy, p2, "Dont worry I like your post!", format.parse("12/10/2015 15:00"));
        
        lucy.createPost(r3);
        
        Text p3 = new Text(dave, "Book Face is great!", format.parse("16/10/2015 23:05"));
        Text p6 = new Text(dave, "Not so sure about it now though...", format.parse("17/10/2015 21:15"));
        
        dave.createPost(p3);
        dave.createPost(p6);
        
        // Add Users to Social Network
        bookFace.addUser(ross);
        bookFace.addUser(ben);
        bookFace.addUser(bob);
        bookFace.addUser(dave);
        bookFace.addUser(sally);
        bookFace.addUser(lucy);
        
        GUI gui = new GUI();
        gui.printCurrentStateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                bookFace.printCurrentState();
                System.out.println("\n");
            }
        });
        gui.printPostsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                bookFace.printPosts();
                System.out.println("\n");
            }
        });
        gui.printCurrentUsersButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                bookFace.printCurrentUsers();
                System.out.println("\n");
            }
        });
        gui.printPostsFromDateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                String date = gui.getDate.getText();
                try {
                    bookFace.printPosts(format2.parse(date));
                    System.out.println("\n");
                } catch (ParseException e) {
                    System.out.println("Incorrect date format try 12/10/2015");
                    System.out.println("\n");
                }
                date = " ";
            }
        });
        gui.postsComboBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Post p = (Post) gui.postsComboBox.getSelectedItem();
            }
            
        });
        gui.userComboBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                User u = (User) gui.userComboBox.getSelectedItem();
            }
            
        });
        gui.deletePostButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                Post p = (Post) gui.postsComboBox.getSelectedItem();
                User u = (User) gui.userComboBox.getSelectedItem();
                if (u == null || p == null){
                    System.out.println("Select a post and a user to delete the post");
                } else {
                    u.removePost(p);
                    gui.postsComboBox.removeItem(gui.postsComboBox.getSelectedItem());
                }   
            }   
        });
        gui.printUsersPostsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                User u = (User) gui.userComboBox.getSelectedItem();
                if(u != null ){
                u.printPosts();
                } else {
                    System.out.println("Select a user first");
                }
            }
        });
        gui.blockUserButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                User u = (User) gui.userBlockComboBox.getSelectedItem();
                User u2 = (User) gui.userComboBox.getSelectedItem();
                if(u != null && u2 != null){
                    u2.blockUser(u, true);
                    System.out.println("Blocked: " + u.toString());
                    
                } else {
                    System.out.println("Select an admin user to block this user");
                }
            }
        });
        gui.unBlockUserButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                User u = (User) gui.userBlockComboBox.getSelectedItem();
                User u2 = (User) gui.userComboBox.getSelectedItem();
                if(u != null && u2 != null){
                u2.blockUser(u, false);
                System.out.println("Un-Blocked: " + u.toString());
                } else {
                    System.out.println("Select an admin user to un-block this user");
                }
            }
        });
        gui.setGeoLocationButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try{
                User u = (User) gui.userComboBox.getSelectedItem();
                if (u != null){
                    u.setGeoLocation(Double.parseDouble(gui.getGeoLocation.getText())); 
                    System.out.println(u.getUsername() + "'s Geo-Location changed to " + u.getGeoLocation());
                } else {
                    System.out.println("Select a user first");
                }
                } catch (NumberFormatException e2){
                    System.out.println("Incorrect Geo-Location");
                }
                
            }
        });
        gui.printUserButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                User u = (User) gui.userComboBox.getSelectedItem();
                if (u != null){
                    u.printUser();
                } else {
                    System.out.println("Select a user first");
                }
            }
        });
        gui.changeFileTypeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String fileType = (String) gui.fileTypeComboBox.getSelectedItem();
                User u = (User) gui.userComboBox.getSelectedItem();
                if(fileType != null && u != null){
                    u.setFileType(fileType);
                    System.out.println("File type changed to " + fileType);
                    
                } else {
                    System.out.println("Select a user and file type first");
                }
            }
        });
        gui.incorrectFileTypeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                Image i2 = new Image(sally, "Yo it's Sally...", "src/image.png", format.parse("18/10/2015 17:20"));
                Video v2 = new Video(bob, "My video", "src/video.avi", format.parse("20/10/2015 18:15"));
                Audio a2 = new Audio(ben, "My new song", "src/audio.mp3", format.parse("21/10/2015 10:55"));
                
                sally.createPost(i2);
                bob.createPost(v2);
                ben.createPost(a2);
                } catch (ParseException e2){
                    System.out.println("Failed to parse date");
                }
            }
        });
        }
        
}
