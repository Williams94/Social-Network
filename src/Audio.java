import java.util.Date;

/**
 * @author rbwilliams
 *
 */
public class Audio extends Post {
    
    private static String fileType = "wav";
    private String path;
    private String audioType;

    /**
     * @param sender    - who is sending the message
     * @param text      - message text
     * @param path      - path to file
     * @param sent      - date the post was sent
     */
    public Audio(User sender, String text,  String path , Date sent) {
        super(sender, text, sent);
        
        setAudioType(path.toString().substring(path.toString().indexOf(".")+1));
        
        try{
            if (getFileType().equals(getAudioType())){
                this.setPath(path);
            } else {
                this.setValid(false);
             throw new FileTypeException("File type needs to be " + getFileType() + " not " + getAudioType());   
            }
        } catch (FileTypeException e){
            System.out.println(e);
        }
    }
    
    @Override
    public String toString(){
        return getSender().getUsername() + "'s " + getClass().toString().substring(6) + " post: " + getText() + 
               "  Sent: " + getSent() + "  File path: " + getPath() + "  File type: " + getAudioType();
    }
    
    @Override
    public void printPost(){
        System.out.println(toString());
    }

    /**
     * @return restricted file type
     */
    public static String getFileType() {
        return fileType;
    }

    /**
     * @param fileType to be restricted to
     */
    public static void setFileType(String fileType) {
        Audio.fileType = fileType;
    }


    /**
     * @return path of file
     */
    private String getPath() {
        return path;
    }

    /**
     * @param path to be set
     */
    private void setPath(String path) {
        this.path = path;
    }

    /**
     * @return audio file type
     */
    private String getAudioType() {
        return audioType;
    }

    /**
     * @param audioType of file
     */
    private void setAudioType(String audioType) {
        this.audioType = audioType;
    }

}
