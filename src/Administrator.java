import java.util.ArrayList;

public class Administrator extends PremiumUser {
    
    ArrayList<User> blockedUsers = new ArrayList<User>();

    public Administrator(String username, double geoLocation) {
        super(username, geoLocation);
        this.accountType = AccountType.ADMIN;
    }
    
    protected void setFileType(String fileType){
        try {
        if (this.accountType != AccountType.ADMIN){            
                throw new UserPermissionsException("User " + getUsername() + " needs " + AccountType.ADMIN 
                        + " account type, but has " + this.accountType + " in order to change file types");            
        } else {
            if ( fileType.equals("png") || fileType.equals("jpeg") || fileType.equals("gif")){
                Image.setFileType(fileType);                
            } else if (fileType.equals("wav") || fileType.equals("mp3") || fileType.equals("wma")){
                Audio.setFileType(fileType);
            } else if (fileType.equals("mp4") || fileType.equals("avi")){
                Video.setFileType(fileType);
            } else {
                throw new FileTypeException(fileType + " extension not supported, try " + Image.getFileType() + " for image, " + Audio.getFileType()
                + " for audio, " + Video.getFileType() + " for video.");
            }
            
        }
        } catch (UserPermissionsException e) {
            System.out.println(e);
        } catch (FileTypeException e){
            System.out.println(e);
        }
    }
    
    public void blockUser(User user){
        super.blockUser(user, true);
        blockedUsers.add(user);
    }
    
    public void unblockUser(User user){
        super.blockUser(user, false);
        blockedUsers.remove(user);
    }
    
    
    public void removePost(Post post){
        for ( Post p : SocialNetwork.getAllPosts()){
            if (p.equals(post)){
               User u = p.getSender();
               u.removePost(p);
            }
        }

    }

}
