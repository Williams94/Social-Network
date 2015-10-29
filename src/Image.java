import java.util.Date;

public class Image extends Post {
    
    private static String fileType = "png";
    private String path;

    public Image(User sender, String text,  String path , Date sent) {
        super(sender, text, sent);
        
        String imageType = path.toString().substring(path.toString().indexOf(".")+1);
        
        try{
            if (getFileType().equals(imageType)){
                this.setPath(path);
            } else {
             throw new FileTypeException("File type needs to be " + getFileType() + " not " + imageType);   
            }
        } catch (FileTypeException e){
            System.out.println(e);
        }
    }
    
    @Override
    public String toString(){
        return getSender().getUsername() + "'s " + getClass().toString().substring(6) + " post: " + getText() + 
               "  Sent: " + getSent() + "  File path: " + getPath() + "  File type: " + getFileType();
    }
    
    @Override
    public void printPost(){
        System.out.println(toString());
    }

    public static String getFileType() {
        return fileType;
    }

    public static void setFileType(String imageType) {
        Image.fileType = imageType;
    }


    private String getPath() {
        return path;
    }

    private void setPath(String path) {
        this.path = path;
    }


  



}
