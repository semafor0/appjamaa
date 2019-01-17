package one.jamaa.appjamaa.information;

public class UsersProfile {

    public String managed;
    public String supported;
    public String success;
    public String following;
    public String followers;
    public String location;
    public String profession;
    public String education;

    public UsersProfile(String managed, String supported, String success, String following, String followers, String location, String profession, String education) {
        this.managed = managed;
        this.supported = supported;
        this.success = success;
        this.following = following;
        this.followers = followers;
        this.location = location;
        this.profession = profession;
        this.education = education;
    }

    public String getManaged() {
        return managed;
    }

    public String getSupported() {
        return supported;
    }

    public String getSuccess() {
        return success;
    }

    public String getFollowing() {
        return following;
    }

    public String getFollowers() {
        return followers;
    }

    public String getLocation() {
        return location;
    }

    public String getProfession() {
        return profession;
    }

    public String getEducation() {
        return education;
    }
}
