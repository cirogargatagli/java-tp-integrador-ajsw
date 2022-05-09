package com.ajsw.javausersservice.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class HashUtil {

    public String Hash256(String value){
        return DigestUtils.sha256Hex(value);
    }

}
