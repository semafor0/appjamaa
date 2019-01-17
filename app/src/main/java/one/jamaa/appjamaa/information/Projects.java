package one.jamaa.appjamaa.information;

public class Projects {

    public String user;
    public String title;
    public String trust;
    public String location;
    public String begin;
    public String end;
    public String duration;
    public String fundingGoal;
    public String profit;
    public String profitHigh;
    public String investorShare;
    public String mudaribShare;

    public Projects(){
    }

    public Projects(String user, String title, String trust, String location, String begin,
                    String end, String duration, String fundingGoal, String profit,
                    String profitHigh, String investorShare, String mudaribShare) {
        this.user = user;
        this.title = title;
        this.trust = trust;
        this.location = location;
        this.begin = begin;
        this.end = end;
        this.duration = duration;
        this.fundingGoal = fundingGoal;
        this.profit = profit;
        this.profitHigh = profitHigh;
        this.investorShare = investorShare;
        this.mudaribShare = mudaribShare;
    }

    public String getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public String getTrust() {
        return trust;
    }

    public String getLocation() {
        return location;
    }

    public String getBegin() {
        return begin;
    }

    public String getEnd() {
        return end;
    }

    public String getDuration() {
        return duration;
    }

    public String getFundingGoal() {
        return fundingGoal;
    }

    public String getProfit() {
        return profit;
    }

    public String getProfitHigh() {
        return profitHigh;
    }

    public String getInvestorShare() {
        return investorShare;
    }

    public String getMudaribShare() {
        return mudaribShare;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTrust(String trust) {
        this.trust = trust;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setFundingGoal(String fundingGoal) {
        this.fundingGoal = fundingGoal;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public void setProfitHigh(String profitHigh) {
        this.profitHigh = profitHigh;
    }

    public void setInvestorShare(String investorShare) {
        this.investorShare = investorShare;
    }

    public void setMudaribShare(String mudaribShare) {
        this.mudaribShare = mudaribShare;
    }
}
