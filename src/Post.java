import java.util.Date;

public class Post {

    private final int ID;
    private static int count;
    private String text;
    private final Date SENT;
    private User sender;
    
    
    public Post(User sender, String text) {
        this.setText(text);
        this.SENT = new Date();
        setCount(getCount() + 1);
        this.ID = getCount();
        this.setSender(sender);
    }
    
    public String getPost(){
        return getSender().getUsername() + "'s post, number " +  getID() + ": " + getText() + "  Sent: " + getSent();
    }
    
    public void printPost(){
        System.out.println(getPost());
    }
    
    public int getID(){
        return ID;
    }
    
    public Date getSent(){
        return SENT;
    }


    public static int getCount() {
        return count;
    }


    private static void setCount(int count) {
        Post.count = count;
    }

    public String getText() {
        return text;
    }

    private void setText(String text) {
        this.text = text;
    }

    private User getSender() {
        return sender;
    }

    private void setSender(User sender) {
        this.sender = sender;
    }

}
