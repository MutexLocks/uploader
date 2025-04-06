package com.g.uploader;


import com.g.uploader.model.AccountDTO;
import org.openqa.selenium.WebDriver;

public interface VideoUploader {

    String name();
    String code();
    String url();

    String homeUrl();

    String logoBase64();

    AccountDTO collectAccountInfo(WebDriver driver);


    void uploadFile(String videoPath, WebDriver driver);

    default void setVideoTitle(String title, WebDriver driver) {

    }
    default void setVideoCover(String imagePath, WebDriver driver){

    }

    default void setVideoDescription(String description, WebDriver driver){}
    void setVideoContentTopic(String videoContentTopic, WebDriver driver);

    void submit(WebDriver driver);

}
