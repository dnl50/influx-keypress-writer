package dev.mieser.heatmap.hook.config;


import dev.mieser.heatmap.hook.api.KeyboardHookRegistry;
import dev.mieser.heatmap.hook.impl.KeyInfoEventFactory;
import dev.mieser.heatmap.hook.impl.KeyboardHookRegistryImpl;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import java.time.Clock;

@Slf4j
@Dependent
class KeyboardHookRegistryConfig {

    @Produces
    @ApplicationScoped
    KeyboardHookRegistry keyboardHookRegistry() {
        var registry = new KeyboardHookRegistryImpl(new KeyInfoEventFactory(Clock.systemDefaultZone()));
        registry.initialize();
        log.debug("Keyboard hook registry initialized.");

        return registry;
    }

    void closeRegistry(@Disposes KeyboardHookRegistry keyboardHookRegistry) {
        try {
            keyboardHookRegistry.close();
            log.debug("Keyboard hook registry closed successfully.");
        } catch (Exception e) {
            log.warn("Failed to close keyboard hook registry.", e);
        }
    }

}
