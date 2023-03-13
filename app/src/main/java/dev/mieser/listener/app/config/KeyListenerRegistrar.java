package dev.mieser.listener.app.config;

import dev.mieser.listener.hook.api.KeyListener;
import dev.mieser.listener.hook.api.KeyboardHookRegistry;
import io.quarkus.runtime.StartupEvent;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;

@Slf4j
@Dependent
public class KeyListenerRegistrar {

    void startup(@Observes StartupEvent event, KeyboardHookRegistry registry, Instance<KeyListener> listeners) {
        long listenerCount = listeners.stream()
                .peek(registry::register)
                .count();
        log.info("Registered {} listener(s) at keyboard hook registry.", listenerCount);
    }

}
