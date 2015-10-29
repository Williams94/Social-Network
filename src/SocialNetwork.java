import java.util.ArrayList;
import java.util.Date;

public class SocialNetwork {
    
    private String name;
    private static ArrayList<User> currentUsers;
    
    public SocialNetwork(String name){
        this.setName(name);
        currentUsers = new ArrayList<User>();
    }

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
    
    
    public void printCurrentUsers(){
        System.out.println("Printing Current Users(" + currentUsers.size() +")......");
        for (User user : currentUsers){
            user.printUser();
        }
    }
    
    
    public void printPosts(){
        System.out.println("Printing all posts(" + getAllPosts().size() + ").....");
        for ( Post p : getAllPosts()){
            p.printPost();
        }
    }
    
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
    
    public void printCurrentState(){
        printCurrentUsers();
        System.out.println("\n");
        printPosts();
    }
    
    /************** Getters and setters *****************/
    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public static ArrayList<User> getCurrentUsers() {
        return currentUsers;
    }

    public void setCurrentUsers(ArrayList<User> currentUsers) {
        this.currentUsers = currentUsers;
    }
    
    
    

}
