package dev.mieser.listener.persistence.hook.config;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

@ConfigMapping(prefix = "listener")
public interface ListenerProperties {

    @WithDefault("true")
    boolean ignoreKeyReleases();

}
