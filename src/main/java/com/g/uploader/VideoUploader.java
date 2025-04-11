package com.g.uploader;

import com.g.uploader.model.AccountInfo;
import org.openqa.selenium.WebDriver;

/**
 * 视频上传器接口。
 * <p>
 * 实现该接口的类用于将视频上传至特定视频平台（如 Bilibili、抖音、西瓜视频等）。
 * 通常配合 Selenium WebDriver 实现平台自动化上传操作。
 * </p>
 */
public interface VideoUploader {

    /**
     * 获取上传器名称，例如平台名称（如“Bilibili”、“抖音”等）。
     *
     * @return 上传器名称
     */
    String name();

    /**
     * 获取上传器编码，用于标识平台的唯一代码。
     *
     * @return 上传器编码（通常为英文，如 bilibili）
     */
    String code();

    /**
     * 获取上传页面的 URL。
     *
     * @return 上传页面的 URL 地址
     */
    String url();

    /**
     * 获取平台首页地址。
     *
     * @return 平台首页 URL
     */
    String homeUrl();

    /**
     * 获取平台 logo 的 Base64 编码字符串。
     *
     * @return Base64 编码格式的 logo 图像，用于 UI 展示
     */
    String logoBase64();

    /**
     * 采集当前已登录账号信息。
     * <p>
     * 通过 WebDriver 提取当前登录用户的账号信息（如昵称、UID 等），用于后续绑定或展示。
     * </p>
     *
     * @param driver Selenium WebDriver 实例
     * @return 封装的账号信息对象
     */
    AccountInfo collectAccountInfo(WebDriver driver);

    /**
     * 上传视频文件。
     * <p>
     * 实现应自动打开上传页面并上传指定的视频文件。
     * </p>
     *
     * @param videoPath 视频文件的本地路径
     * @param driver    Selenium WebDriver 实例
     */
    void uploadFile(String videoPath, WebDriver driver);

    /**
     * 设置视频标题。
     *
     * @param title  视频标题文本
     * @param driver Selenium WebDriver 实例
     */
    void setVideoTitle(String title, WebDriver driver);

    /**
     * 设置视频封面。
     *
     * @param imagePath 封面图片的本地路径
     * @param driver    Selenium WebDriver 实例
     */
    void setVideoCover(String imagePath, WebDriver driver);

    /**
     * 设置视频描述（正文内容）。
     *
     * @param description 视频描述文本（一般为视频简介或引导文字）
     * @param driver      Selenium WebDriver 实例
     */
    void setVideoDescription(String description, WebDriver driver);

    /**
     * 设置视频内容所属话题（可选实现）。
     * <p>
     * 某些平台支持为视频绑定话题、分类、标签等内容。
     * 实现类可根据平台规则进行适配。
     * </p>
     *
     * @param videoContentTopic 内容话题文本
     * @param driver            Selenium WebDriver 实例
     */
    default void setVideoContentTopic(String videoContentTopic, WebDriver driver) {}

    /**
     * 设置额外的上传配置（可选实现）。
     * <p>
     * 某些平台可能支持额外的上传设置，例如是否原创、隐私设置、分区选择等。
     * 可以通过该方法传入 JSON 或自定义字符串格式配置。
     * </p>
     *
     * @param config  配置内容（格式可自定义）
     * @param driver  Selenium WebDriver 实例
     */
    default void extraConfig(String config, WebDriver driver) {}

    /**
     * 提交发布视频。
     * <p>
     * 在设置好标题、封面、正文内容、视频文件等后，调用该方法以完成视频的最终发布。
     * </p>
     *
     * @param driver Selenium WebDriver 实例
     */
    void submit(WebDriver driver);
}
