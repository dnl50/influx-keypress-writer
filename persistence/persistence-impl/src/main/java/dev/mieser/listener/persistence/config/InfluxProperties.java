package dev.mieser.listener.persistence.config;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

import javax.validation.constraints.NotEmpty;

@ConfigMapping(prefix = "influx")
public interface InfluxProperties {

    Connection connection();

    Host host();

    Measurement measurement();

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

    interface Host {

        @WithDefault("local")
        @NotEmpty
        String identifier();

    }

    interface Measurement {

        @WithDefault("key_event")
        @NotEmpty
        String keyboard();

        @WithDefault("mouse_event")
        @NotEmpty
        String mouse();

    }

}
