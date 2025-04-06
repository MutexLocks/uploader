package com.g.uploader;

import com.g.uploader.model.AccountDTO;
import org.openqa.selenium.WebDriver;

public interface ArticleUploader{
    String name();

    String code();

    String url();

    String homeUrl();

    String logoBase64();

    AccountDTO collectAccountInfo(WebDriver driver);

    void uploadFile(String videoPath, WebDriver driver);

    void setTitle(String title, WebDriver driver);

    void setArticleCover(String imagePath, WebDriver driver);

    void optimizeArticle(WebDriver driver);

    void submit(WebDriver driver);
}
