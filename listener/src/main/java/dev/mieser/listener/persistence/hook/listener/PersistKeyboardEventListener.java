package dev.mieser.listener.persistence.hook.listener;

import dev.mieser.listener.domain.KeyTransition;
import dev.mieser.listener.domain.keyboard.KeyEvent;
import dev.mieser.listener.domain.mouse.MouseEvent;
import dev.mieser.listener.hook.api.keyboard.KeyboardListener;
import dev.mieser.listener.hook.api.mouse.MouseListener;
import dev.mieser.listener.persistence.api.EventRepository;
import dev.mieser.listener.persistence.hook.config.ListenerProperties;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.function.Consumer;
import java.util.function.Function;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = {@Inject})
public class PersistKeyboardEventListener implements KeyboardListener, MouseListener {

    private final EventRepository eventRepository;

    private final ListenerProperties listenerProperties;

    @Override
    public void onEvent(KeyEvent event) {
        onEvent(event, KeyEvent::transition, eventRepository::save);
    }

    @Override
    public void onEvent(MouseEvent event) {
        onEvent(event, MouseEvent::transition, eventRepository::save);
    }

    private <T> void onEvent(T event, Function<T, KeyTransition> transitionExtractor, Consumer<T> repository) {
        if (shouldIgnoreTransition(transitionExtractor.apply(event))) {
            return;
        }

        repository.accept(event);
    }


    private boolean shouldIgnoreTransition(KeyTransition transition) {
        return transition == KeyTransition.RELEASED && listenerProperties.ignoreReleases();
    }

}
