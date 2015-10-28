
public class Reply extends Post {
    
    private Post repliedTo;

    public Reply(User sender, Post repliedTo, String text) {
        super(sender, text);
        this.setRepliedTo(repliedTo);
    }
    
    public void printReply(){
        System.out.println(getID() + ": " + getText() + "  Sent: " + getSent() + 
                " \n\t In reply to " + repliedTo.getPost());
    }
    
    

    public Post getRepliedTo() {
        return repliedTo;
    }

    public void setRepliedTo(Post repliedTo) {
        this.repliedTo = repliedTo;
    }

}
