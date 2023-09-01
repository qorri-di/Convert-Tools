package com.qodev.tech.configuration;

import io.quarkus.vertx.http.runtime.filters.Filters;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class RequestFilters {
    @ConfigProperty(name="ddms.auth.token")
    String ddmsAdminToken;

    public void filters(@Observes final Filters filters) {
        filters.register(rc -> {
            String requestToken=rc.request().getHeader("Authorization");
           if (ddmsAdminToken.equals(requestToken)) {
               rc.request().headers().remove("Authorization");
           }
            rc.next();
        }, 9000);
    }

}