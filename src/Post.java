import java.util.Date;

public class Post {

    private final int ID;
    private static int count;
    private String text;
    private final Date SENT;
    private User sender;
    private Post replyTo;
    private boolean reply = false;
    
    
    public Post(User sender, String text, Date sent) {
        this.setText(text);
        this.SENT = sent;
        setCount(getCount() + 1);
        this.ID = getCount();
        this.setSender(sender);
    }
    
    public Post(User sender,Post replyTo, String text, Date sent){
        this.setText(text);
        this.SENT = sent;
        setCount(getCount() + 1);
        this.ID = getCount();
        this.setSender(sender);
        this.setReplyTo(replyTo);
        reply = true;
    }
    
    
    
    public String toString(){
        if (this.reply){
            return getSender().getUsername() + "'s " + getClass().toString().substring(6) + " post: " + getText() + "  Sent: " + getSent()
            + " \n\t In reply to " + replyTo.toString();
        } else {
            return getSender().getUsername() + "'s " + getClass().toString().substring(6) + " post: " + getText() + "  Sent: " + getSent();
        }
    }
    
    public void printPost(){
        System.out.println(toString());
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

    public User getSender() {
        return sender;
    }

    private void setSender(User sender) {
        this.sender = sender;
    }

    public Post getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(Post replyTo) {
        this.replyTo = replyTo;
    }

}
