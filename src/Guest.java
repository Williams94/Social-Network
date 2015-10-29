
public class Guest extends User {
    
    

    public Guest(String username, double geoLocation) {
        super(username, geoLocation);
        this.accountType = AccountType.GUEST;
    }

}
