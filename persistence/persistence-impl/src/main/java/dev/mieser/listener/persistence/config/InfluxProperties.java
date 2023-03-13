package dev.mieser.listener.persistence.config;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

import javax.validation.constraints.NotEmpty;

@ConfigMapping(prefix = "influx")
public interface InfluxProperties {

    Connection connection();

    Point point();

    interface Connection {

        @NotEmpty
        String url();

        @NotEmpty
        String token();

        @NotEmpty
        String bucket();

        @NotEmpty
        String org();

        @WithDefault("true")
        boolean enableCompression();

    }

    interface Point {

        @WithDefault("key_event")
        @NotEmpty
        String measurementName();

        @WithDefault("local")
        @NotEmpty
        String hostIdentifier();

    }

}
