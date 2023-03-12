package dev.mieser.heatmap.hook.impl;

import dev.mieser.heatmap.hook.api.KeyListener;
import dev.mieser.heatmap.hook.api.KeyboardHookRegistry;
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
    public void register(KeyListener listener) {
        if (keyboardHook == null) {
            throw new IllegalStateException("Registry is not initialized.");
        }

        keyboardHook.addKeyListener(new KeyListenerAdapter(listener, keyInfoEventFactory));
    }

    @Override
    public void close() {
        if (keyboardHook != null) {
            keyboardHook.shutdownHook();
            keyboardHook = null;
        }
    }

}
