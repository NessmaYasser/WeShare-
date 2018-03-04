package pharaoh.com.weshare.models;

/**
 * Created by Comptia Ware on 2/20/2018.
 */

public class Follow {
    public int profile_img;
    public String name;
    public String location;

    public int getProfile_img() {
        return profile_img;
    }

    public void setProfile_img(int profile_img) {
        this.profile_img = profile_img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
