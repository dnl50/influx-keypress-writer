package dev.mieser.listener.hook.config;


import dev.mieser.listener.hook.api.keyboard.KeyboardHookRegistry;
import dev.mieser.listener.hook.api.mouse.MouseHookRegistry;
import dev.mieser.listener.hook.impl.keyboard.KeyInfoEventFactory;
import dev.mieser.listener.hook.impl.keyboard.KeyboardHookRegistryImpl;
import dev.mieser.listener.hook.impl.mouse.MouseEventFactory;
import dev.mieser.listener.hook.impl.mouse.MouseHookRegistryImpl;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import java.io.Closeable;
import java.time.Clock;

@Slf4j
@Dependent
class HookRegistryConfig {

    @Produces
    @ApplicationScoped
    KeyboardHookRegistry keyboardHookRegistry() {
        var registry = new KeyboardHookRegistryImpl(new KeyInfoEventFactory(Clock.systemDefaultZone()));
        registry.initialize();
        log.info("Keyboard hook registry initialized.");

        return registry;
    }

    @Produces
    @ApplicationScoped
    MouseHookRegistry mouseHookRegistry() {
        var registry = new MouseHookRegistryImpl(new MouseEventFactory(Clock.systemDefaultZone()));
        registry.initialize();
        log.info("Mouse hook registry initialized.");

        return registry;
    }

    void closeRegistry(@Disposes Closeable keyboardHookRegistry) {
        try {
            keyboardHookRegistry.close();
            log.info("Successfully closed hook registry.");
        } catch (Exception e) {
            log.warn("Failed to close hook registry.", e);
        }
    }

}
