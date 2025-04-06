package org.g.uploader.model;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum AccountStatus {
    NORMAL("normal"),
    EXPIRED("expired");

    AccountStatus(String code) {
        this.code = code;
    }
    private String code;

    public static AccountStatus get(String code) {
        Optional<AccountStatus> first = Arrays.stream(values())
                .filter(item -> StringUtils.equalsIgnoreCase(item.getCode(), code))
                .findFirst();
        return first.orElse(null);
    }

    public static boolean contains(String code) {
        Optional<AccountStatus> first = Arrays.stream(values())
                .filter(item -> item.code.equalsIgnoreCase(code))
                .findFirst();
        return first.isPresent();
    }
}
