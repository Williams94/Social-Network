import java.util.Date;

/**
 * @author rbwilliams
 *
 */
public class Image extends Post {
    
    private static String fileType = "png";
    private String path;
    private String imageType;

    /**
     * @param sender    - who is sending the message
     * @param text      - message text
     * @param path      - path to file
     * @param sent      - date the post was sent
     */
    public Image(User sender, String text,  String path , Date sent) {
        super(sender, text, sent);
        
        setImageType(path.toString().substring(path.toString().indexOf(".")+1));
        
        try{
            if (getFileType().equals(getImageType())){
                this.setPath(path);
            } else {
             this.setValid(false);
             throw new FileTypeException("File type needs to be " + getFileType() + " not " + getImageType());   
            }
        } catch (FileTypeException e){
            System.out.println(e);
        }
    }
    
    @Override
    public String toString(){
        return getSender().getUsername() + "'s " + getClass().toString().substring(6) + " post: " + getText() + 
               "  Sent: " + getSent() + "  File path: " + getPath() + "  File type: " + getImageType();
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
        Image.fileType = fileType;
    }


    /**
     * @return path to file
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
     * @return image file type
     */
    private String getImageType() {
        return imageType;
    }

    /**
     * @param imageType of file
     */
    private void setImageType(String imageType) {
        this.imageType = imageType;
    }


  



}
