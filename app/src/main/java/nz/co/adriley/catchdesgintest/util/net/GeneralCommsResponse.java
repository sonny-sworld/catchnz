package nz.co.adriley.catchdesgintest.util.net;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GeneralCommsResponse implements Serializable {

    @SerializedName("id")
    private Integer id;
    @SerializedName("title")
    public String title;
    @SerializedName("subtitle")
    public String subtitle;
    @SerializedName("content")
    public String content;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
