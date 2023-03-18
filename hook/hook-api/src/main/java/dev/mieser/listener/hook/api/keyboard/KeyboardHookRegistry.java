package dev.mieser.listener.hook.api.keyboard;

import java.io.Closeable;

public interface KeyboardHookRegistry extends Closeable {

    /**
     * Initializes the underlying native library. Must be called before {@link #register(KeyboardListener) registering} any {@link KeyboardListener}s.
     */
    void initialize();

    /**
     * @param listener The listener to register, not {@code null}.
     */
    void register(KeyboardListener listener);

}
