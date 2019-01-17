package one.jamaa.appjamaa.information;

public class Users {


    public String userName;
    public String joinDate;
    public String participated;
    public String managed;
    public String profit;
    public String invested;
    public String trust;

    public Users(){

    }

    public Users(String userName, String joinDate, String participated, String managed, String profit, String invested, String trust) {
        this.userName = userName;
        this.joinDate = joinDate;
        this.participated = participated;
        this.managed = managed;
        this.profit = profit;
        this.invested = invested;
        this.trust = trust;
    }

    public String getUserName() {
        return userName;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public String getParticipated() {
        return participated;
    }

    public String getManaged() {
        return managed;
    }

    public String getProfit() {
        return profit;
    }

    public String getInvested() {
        return invested;
    }

    public String getTrust() {
        return trust;
    }

}
