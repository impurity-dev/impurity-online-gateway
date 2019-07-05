package com.impurityonline.gateway.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Data
@Component
@ConfigurationProperties(prefix = "route")
public class RouteProperties {
    @NotBlank
    private String twitchUrl;
    @NotBlank
    private String steamUrl;
    @NotBlank
    private String osrsUrl;
}
