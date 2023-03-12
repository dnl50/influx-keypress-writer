package dev.mieser.heatmap.persistence.hook.listener;

import dev.mieser.heatmap.domain.KeyEvent;
import dev.mieser.heatmap.domain.KeyEventType;
import dev.mieser.heatmap.hook.api.KeyListener;
import dev.mieser.heatmap.persistence.api.KeyEventRepository;
import dev.mieser.heatmap.persistence.hook.config.ListenerProperties;
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
