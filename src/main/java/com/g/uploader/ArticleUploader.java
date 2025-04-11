package com.g.uploader;

import com.g.uploader.model.AccountInfo;
import org.openqa.selenium.WebDriver;

/**
 * 文章上传器接口。
 * <p>
 * 实现该接口的类可用于将文档/文章上传至特定平台。
 * 通常配合 Selenium WebDriver 实现平台自动化操作。
 * </p>
 */
public interface ArticleUploader {

    /**
     * 获取上传器名称，例如平台名称（如“知乎”、“公众号”等）。
     *
     * @return 上传器名称
     */
    String name();

    /**
     * 获取上传器编码，用于标识平台的唯一代码。
     *
     * @return 上传器编码（通常为英文名，如 ZHI_HU）
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
     * 通过 WebDriver 提取当前登录用户的账号信息（如用户名和头像），用于后续绑定或展示。
     * </p>
     *
     * @param driver Selenium WebDriver 实例
     * @return 封装的账号信息对象
     */
    AccountInfo collectAccountInfo(WebDriver driver);

    /**
     * 上传文件（文章内容）。
     * <p>
     * 当前driver以打开url()的界面，
     * 需实现上传指定的文章docx文件。
     * </p>
     *
     * @param videoPath 文件路径
     * @param driver    Selenium WebDriver 实例
     */
    void uploadFile(String videoPath, WebDriver driver);

    /**
     * 设置文章标题。
     *
     * @param title  文章标题文本
     * @param driver Selenium WebDriver 实例
     */
    void setTitle(String title, WebDriver driver);

    /**
     * 设置文章封面图像。
     *
     * @param imagePath 封面图片的本地路径
     * @param driver    Selenium WebDriver 实例
     */
    void setArticleCover(String imagePath, WebDriver driver);

    /**
     * 优化文章内容（可选实现）。
     * <p>
     * 可用于对正文进行排版美化、添加标签、插入作者简介等操作。
     * 若无特殊需求，可保留默认空实现。
     * </p>
     *
     * @param driver Selenium WebDriver 实例
     */
    default void optimizeArticle(WebDriver driver) {}

    /**
     * 提交发布文章。
     * <p>
     * 在设置好标题、封面、正文内容后，调用该方法以提交文章。
     * </p>
     *
     * @param driver Selenium WebDriver 实例
     */
    void submit(WebDriver driver);
}
