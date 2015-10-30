
/**
 * @author rbwilliams
 *
 */
public class Guest extends User {
    
    

    /**
     * @param username      - of user
     * @param geoLocation   - location of user
     */
    public Guest(String username, double geoLocation) {
        super(username, geoLocation);
        this.accountType = AccountType.GUEST;
    }

}
