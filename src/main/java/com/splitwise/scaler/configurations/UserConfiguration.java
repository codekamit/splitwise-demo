package com.splitwise.scaler.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "userproperties")
public class UserConfiguration {
    public int PASSWORD_MIN_LENGTH;
    public int PASSWORD_MAX_LENGTH;

    public int getPASSWORD_MIN_LENGTH() {
        return PASSWORD_MIN_LENGTH;
    }

    public void setPASSWORD_MIN_LENGTH(int PASSWORD_MIN_LENGTH) {
        this.PASSWORD_MIN_LENGTH = PASSWORD_MIN_LENGTH;
    }

    public int getPASSWORD_MAX_LENGTH() {
        return PASSWORD_MAX_LENGTH;
    }

    public void setPASSWORD_MAX_LENGTH(int PASSWORD_MAX_LENGTH) {
        this.PASSWORD_MAX_LENGTH = PASSWORD_MAX_LENGTH;
    }
}
