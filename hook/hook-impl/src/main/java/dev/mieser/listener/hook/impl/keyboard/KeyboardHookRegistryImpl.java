package dev.mieser.listener.hook.impl.keyboard;

import dev.mieser.listener.hook.api.keyboard.KeyboardHookRegistry;
import dev.mieser.listener.hook.api.keyboard.KeyboardListener;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class KeyboardHookRegistryImpl implements KeyboardHookRegistry {

    private final KeyInfoEventFactory keyInfoEventFactory;

    private GlobalKeyboardHook keyboardHook;

    @Override
    public void initialize() {
        if (keyboardHook != null) {
            return;
        }

        keyboardHook = new GlobalKeyboardHook(false);
    }

    @Override
    public void register(KeyboardListener listener) {
        if (keyboardHook == null) {
            throw new IllegalStateException("Registry is not initialized.");
        }

        keyboardHook.addKeyListener(new KeyboardListenerAdapter(listener, keyInfoEventFactory));
    }

    @Override
    public void close() {
        if (keyboardHook != null) {
            keyboardHook.shutdownHook();
            keyboardHook = null;
        }
    }

}
