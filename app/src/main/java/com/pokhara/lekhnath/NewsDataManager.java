package com.pokhara.lekhnath;

public class NewsDataManager {

    String id,postTitle,postDescription, userName;

    public NewsDataManager(){

    }
    public NewsDataManager(String id, String postTitle, String postDescription,String userName){
        this.id=id;
        this.postTitle=postTitle;
        this.postDescription=postDescription;
        this.userName= userName;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }


}
