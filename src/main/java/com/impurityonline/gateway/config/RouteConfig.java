package com.impurityonline.gateway.config;

import com.impurityonline.gateway.properties.RouteProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.factory.RewritePathGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Impurity
 */
@Slf4j
@Configuration
public class RouteConfig {
    @Autowired
    private RouteProperties routeProperties;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        new RewritePathGatewayFilterFactory();
        return builder
                .routes()
                    .route("twitch_api_route", route -> route
                            .path("/twitch/**")
                            .filters(filter -> filter.stripPrefix(1))
                            .uri(routeProperties.getTwitchUrl())
                    )
                    .route("steam_api_route", route -> route
                            .path("/steam/**")
                            .filters(filter -> filter.stripPrefix(1))
                            .uri(routeProperties.getSteamUrl())
                    )
                    .route("osrs_api_route", route -> route
                            .path("/osrs/**")
                            .filters(filter -> filter.stripPrefix(1))
                            .uri(routeProperties.getOsrsUrl())
                    )
                .build();
    }
}
