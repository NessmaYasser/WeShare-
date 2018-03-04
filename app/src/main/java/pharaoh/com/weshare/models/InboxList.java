package pharaoh.com.weshare.models;

/**
 * Created by Comptia Ware on 2/18/2018.
 */

public class InboxList {

    public int profile_img;
    public String name;
    public String message;
    public String date;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
