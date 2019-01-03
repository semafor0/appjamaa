package one.jamaa.appjamaa.information;

public class Projects {

    public String title;
    public String user;
    public String trust;
    public String fundingGoal;
    public String profit;
    public String duration;

    public Projects(){

    }

    public Projects(String title, String user, String trust, String fundingGoal, String profit, String duration) {
        this.title = title;
        this.user = user;
        this.trust = trust;
        this.fundingGoal = fundingGoal;
        this.profit = profit;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getUser() {
        return user;
    }

    public String getTrust() {
        return trust;
    }

    public String getFundingGoal() {
        return fundingGoal;
    }

    public String getProfit() {
        return profit;
    }

    public String getDuration() {
        return duration;
    }


}
