import java.util.Date;

/**
 * @author rbwilliams
 *
 */
public class Post {

    private final int ID;
    private static int count;
    private String text;
    private final Date SENT;
    private User sender;
    private Post replyTo;
    private boolean reply = false;
    private boolean valid = true;
    
    
    /**
     * @param sender    - who is sending the message
     * @param text      - message text
     * @param sent      - date the post was sent
     */
    public Post(User sender, String text, Date sent) {
        this.setText(text);
        this.SENT = sent;
        setCount(getCount() + 1);
        this.ID = getCount();
        this.setSender(sender);
    }
    
    /**
     * @param sender    - who is sending the message
     * @param replyTo      - reply to this post
     * @param text      - message text
     * @param sent      - date the post was sent
     */
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
    
    /**
     * @return ID of post
     */
    public int getID(){
        return ID;
    }
    
    /**
     * @return date the post was sent
     */
    public Date getSent(){
        return SENT;
    }


    /**
     * @return get the number of posts created
     */
    public static int getCount() {
        return count;
    }


    /**
     * @param set the number of posts created
     */
    private static void setCount(int count) {
        Post.count = count;
    }

    /**
     * @return get the text of the post
     */
    public String getText() {
        return text;
    }

    /**
     * @param set the text of the post
     */
    private void setText(String text) {
        this.text = text;
    }

    /**
     * @return get who sent the post
     */
    public User getSender() {
        return sender;
    }

    /**
     * @param set who i sending the post
     */
    private void setSender(User sender) {
        this.sender = sender;
    }

    /**
     * @return the post it is in reply to
     */
    public Post getReplyTo() {
        return replyTo;
    }

    /**
     * @param set which post to reply to
     */
    public void setReplyTo(Post replyTo) {
        this.replyTo = replyTo;
    }

    /**
     * @return if the post is valid or not
     */
    public boolean isValid() {
        return valid;
    }

    /**
     * @param set the validity of the post
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }

}
