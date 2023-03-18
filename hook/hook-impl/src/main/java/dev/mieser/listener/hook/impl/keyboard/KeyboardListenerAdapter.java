package dev.mieser.listener.hook.impl.keyboard;

import dev.mieser.listener.hook.api.keyboard.KeyboardListener;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import lc.kra.system.keyboard.event.GlobalKeyListener;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * {@link GlobalKeyListener} which delegates to a {@link KeyboardListener}.
 */
@Slf4j
class KeyboardListenerAdapter implements GlobalKeyListener {

    private final KeyboardListener delegate;

    private final KeyInfoEventFactory keyInfoEventFactory;

    private final Set<Integer> currentlyPressedKeys;

    KeyboardListenerAdapter(KeyboardListener delegate, KeyInfoEventFactory keyInfoEventFactory) {
        this.delegate = delegate;
        this.keyInfoEventFactory = keyInfoEventFactory;
        this.currentlyPressedKeys = new HashSet<>();
    }

    @Override
    public void keyPressed(GlobalKeyEvent event) {
        if (!currentlyPressedKeys.add(event.getVirtualKeyCode())) {
            return;
        }

        notifyDelegate(event);
    }

    @Override
    public void keyReleased(GlobalKeyEvent event) {
        currentlyPressedKeys.remove(event.getVirtualKeyCode());
        notifyDelegate(event);
    }

    private void notifyDelegate(GlobalKeyEvent keyEvent) {
        try {
            delegate.onEvent(keyInfoEventFactory.create(keyEvent));
        } catch (RuntimeException e) {
            log.warn("Listener threw exception.", e);
        }
    }

}
