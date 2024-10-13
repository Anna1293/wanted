package com.wanted.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring")
@Data
public class ApplicationProperties {

    @Getter
    @Setter
    public static class Datasource {
        private String url;
        private String username;
        private String password;
        private String driverClassName;
    }

    private Datasource datasource;
}
