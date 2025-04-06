package org.g.uploader.model;

import lombok.Data;

@Data
public class AccountDTO {
    private Long id;
    private Long groupId;

    private String name;
    private String platformCode;
    private String mediaType;

    private String dataPath;
    /**
     * normal expired
     */
    private String status;
    private String avatar;
}
