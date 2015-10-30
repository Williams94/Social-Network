import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;

/**
 * @author rbwilliams
 *
 */
public class SocialNetwork {
    
    private String name;
    private static ArrayList<User> currentUsers;
    
    /**
     * @param name of the social network
     */
    public SocialNetwork(String name){
        this.setName(name);
        currentUsers = new ArrayList<User>();
    }

    /**
     * @param user to add to the social network
     */
    public void addUser(User user){
        try {
            if (user.registered()){
                currentUsers.add(user);
            } else {
                throw new UserNotRegisteredException("User "+ "'" + user.getUsername() + "'" + " must first register to the social network.");
            }
        } catch (UserNotRegisteredException e) {
            System.out.println(e);
        }
    }
    
    
    /**
     * prints out the current users on the social network
     */
    public void printCurrentUsers(){
        System.out.println("Printing Current Users(" + currentUsers.size() +")......");
        for (User user : currentUsers){
            user.printUser();
        }
    }
    
    
    /**
     * prints all the posts in the social network
     */
    public void printPosts(){
        System.out.println("Printing all posts(" + getAllPosts().size() + ").....");
        for ( Post p : getAllPosts()){
            p.printPost();
        }
    }
    
    /**
     * @param prints all the posts on the date specified 
     */
    public void printPosts(Date date){
        boolean found = false;
        System.out.println("All posts from " + date.toString().substring(0, 10) + ":");
        for (Post p : getAllPosts()){
            if (p.getSent().toString().substring(0, 10).equals(date.toString().substring(0, 10))){
                p.printPost();
                found = true;
            }
        }
        if (!found){
            System.out.println("No posts on that day!");
        }
    }
    
 
    
    /**
     * @return current users in form of an array list
     */
    public static ArrayList<Post> getAllPosts(){
        
            ArrayList<Post> allPosts = new ArrayList<Post>();
            
            for (User user : currentUsers){
                try {
                
                for ( Post post : user.getPosts()){
                    allPosts.add(post);
                }
                } catch (NullPointerException e){
            user.printPosts();
        }
            }            

        return allPosts;
    }
    
    /**
     * prints users and posts
     */
    public void printCurrentState(){
        printCurrentUsers();
        System.out.println("\n");
        printPosts();
    }
    

    /**
     * @return name of the social network
     */
    String getName() {
        return name;
    }

    /**
     * @param set the name of the social network
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     * @return current users array list
     */
    public static ArrayList<User> getCurrentUsers() {
        return currentUsers;
    }

    /**
     * @param ser currentUsers array list
     */
    public void setCurrentUsers(ArrayList<User> currentUsers) {
        this.currentUsers = currentUsers;
    }
    
    
    

}
