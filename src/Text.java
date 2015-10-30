import java.util.Date;

public class Text extends Post {

    public Text(User sender, String text, Date sent) {
        super(sender, text, sent);
    }
    
    public Text(User sender, Post post, String text, Date sent) {
        super(sender, post, text, sent);
    }

}
