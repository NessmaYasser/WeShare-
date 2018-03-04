package pharaoh.com.weshare.models;

import java.util.Date;

/**
 * Created by Comptia Ware on 2/8/2018.
 */

public class Home {
    public int img;
    public String body;
    public String posterName;
    public String date;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
