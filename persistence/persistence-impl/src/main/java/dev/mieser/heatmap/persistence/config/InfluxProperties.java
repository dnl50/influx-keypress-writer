package dev.mieser.heatmap.persistence.config;

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

    }

    interface Point {

        @WithDefault("key_event")
        @NotEmpty
        String name();

        @NotEmpty
        String hostIdentifier();

    }

}
