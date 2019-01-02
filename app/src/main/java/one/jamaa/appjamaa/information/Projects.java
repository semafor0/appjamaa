package one.jamaa.appjamaa.information;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class Projects {

    public int iconID;
    public String person;
    public int profitability;
    private @ServerTimestamp Date timestamp;


    public Projects(int iconID, String person, int profitability) {
        this.iconID = iconID;
        this.person = person;
        this.profitability = profitability;
    }

}
