package dev.mieser.listener.app.config;

import dev.mieser.listener.hook.api.keyboard.KeyboardHookRegistry;
import dev.mieser.listener.hook.api.keyboard.KeyboardListener;
import dev.mieser.listener.hook.api.mouse.MouseHookRegistry;
import dev.mieser.listener.hook.api.mouse.MouseListener;
import io.quarkus.runtime.StartupEvent;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;

@Slf4j
@Dependent
public class ListenerRegistrar {

    void registerKeyboardHooks(@Observes StartupEvent event, KeyboardHookRegistry registry, Instance<KeyboardListener> listeners) {
        long listenerCount = listeners.stream()
                .peek(registry::register)
                .count();
        log.info("Registered {} listener(s) at keyboard hook registry.", listenerCount);
    }

    void registerMouseHooks(@Observes StartupEvent event, MouseHookRegistry registry, Instance<MouseListener> listeners) {
        long listenerCount = listeners.stream()
                .peek(registry::register)
                .count();
        log.info("Registered {} listener(s) at mouse hook registry.", listenerCount);
    }

}
