package dev.mieser.listener.persistence.hook.listener;

import dev.mieser.listener.domain.KeyEvent;
import dev.mieser.listener.domain.KeyEventType;
import dev.mieser.listener.hook.api.KeyListener;
import dev.mieser.listener.persistence.api.KeyEventRepository;
import dev.mieser.listener.persistence.hook.config.ListenerProperties;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = {@Inject})
public class PersistKeyEventListener implements KeyListener {

    private final KeyEventRepository keyEventRepository;

    private final ListenerProperties listenerProperties;

    @Override
    public void onEvent(KeyEvent event) {
        if (shouldIgnoreEvent(event)) {
            return;
        }

        keyEventRepository.save(event);
    }

    private boolean shouldIgnoreEvent(KeyEvent event) {
        return event.type() == KeyEventType.RELEASED && listenerProperties.ignoreKeyReleases();
    }

}
