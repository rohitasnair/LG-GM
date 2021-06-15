package lg.gm.inventory;

import com.google.firebase.database.Exclude;

public class Upload {
    private String mName;
    private String mImageUrl;
    private String mKey;
    private String mID;
    private String Ctime;
    private String Uname;
    private String Transfer;

    public Upload() {
        //empty constructor needed
    }

    public Upload(String name, String imageUrl,String id,String time,String username,String next_owner) {
        if (name.trim().equals("")) {
            name = "No Name";
        }
        if (id.trim().equals("")) {
            id = "No Asset ID";
        }

        mName = name;
        mImageUrl = imageUrl;
        mID=id;
        Ctime=time;
        Uname=username;
        Transfer=next_owner;
    }

    public String getName() {
        return mName;
    }

    public String getCtime() {
        return Ctime;
    }

    public void setCtime(String time) {
        Ctime = time;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String username) {
        Uname = username;
    }

    public String getTransfer() {
        return Transfer;
    }

    public void setTransfer(String next_owner) {
        Transfer = next_owner;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getID() {
        return mID;
    }

    public void setID(String id) {
        mID = id;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    @Exclude
    public String getKey() {
        return mKey;
    }

    @Exclude
    public void setKey(String key) {
        mKey = key;
    }
}