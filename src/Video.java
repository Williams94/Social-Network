import java.util.Date;

/**
 * @author rbwilliams
 *
 */
public class Video extends Post {

    private static String fileType = "mp4";
    private String path;
    private String videotype;

    /**
     * @param sender    - who is sending the message
     * @param text      - message text
     * @param path      - path to file
     * @param sent      - date the post was sent
     */
    public Video(User sender, String text,  String path, Date sent) {
        super(sender, text, sent);
        
        setVideotype(path.toString().substring(path.toString().indexOf(".")+1));
        
        try{
            if (getFileType().equals(getVideotype())){
                this.setPath(path);
                
            } else {
                this.setValid(false);
             throw new FileTypeException("File type needs to be " + getFileType() + " not " + getVideotype());   
             
            }
        } catch (FileTypeException e){
            System.out.println(e);
        }
    }
    
    @Override
    public String toString(){
        return getSender().getUsername() + "'s " + getClass().toString().substring(6) + " post: " + getText() + 
               "  Sent: " + getSent() + 
               "  File path: " + getPath() + "  File type: " 
               + getVideotype();
    }
    
    @Override
    public void printPost(){
        System.out.println(toString());
    }

    /**
     * @return restrcited file type
     */
    public static String getFileType() {
        return fileType;
    }

    /**
     * @param fileType to be set
     */
    public static void setFileType(String fileType) {
        Video.fileType = fileType;
    }


    /**
     * @return path to file
     */
    private String getPath() {
        return path;
    }

    /**
     * @param path to file
     */
    private void setPath(String path) {
        this.path = path;
    }

    /**
     * @return video file type
     */
    private String getVideotype() {
        return videotype;
    }

    /**
     * @param videotype to be set
     */
    private void setVideotype(String videotype) {
        this.videotype = videotype;
    }

}
