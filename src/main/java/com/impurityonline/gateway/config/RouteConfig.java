package com.impurityonline.gateway.config;

import com.impurityonline.gateway.properties.RouteProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Impurity
 */
@Configuration
public class RouteConfig {
    @Autowired
    private RouteProperties routeProperties;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(route -> route.path("/twitch").uri(routeProperties.getTwitchUrl()))
                .route(route -> route.path("/steam").uri(routeProperties.getSteamUrl()))
                .route(route -> route.path("/osrs").uri(routeProperties.getOsrsUrl()))
                .build();
    }
}
