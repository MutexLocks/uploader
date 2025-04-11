package com.g.uploader.model;

import lombok.Data;

@Data
public class AccountInfo {
    // 账号名称
    private String name;

    // 账号头像图片，转成base64格式
    private String avatar;
}
