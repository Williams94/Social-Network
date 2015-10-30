import java.util.Date;

/**
 * @author rbwilliams
 *
 */
public class Text extends Post {

    /**
     * @param sender    - who is sending the message
     * @param text      - message text
     * @param sent      - date the post was sent
     */
    public Text(User sender, String text, Date sent) {
        super(sender, text, sent);
    }
    
    /**
     * @param sender    - who is sending the message
     * @param post      - reply to this post
     * @param text      - message text
     * @param sent      - date the post was sent
     */
    public Text(User sender, Post post, String text, Date sent) {
        super(sender, post, text, sent);
    }

}
