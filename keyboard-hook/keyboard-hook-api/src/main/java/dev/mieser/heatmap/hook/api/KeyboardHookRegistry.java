package dev.mieser.heatmap.hook.api;

import java.io.Closeable;

public interface KeyboardHookRegistry extends Closeable {

    /**
     * Initializes the underlying native library. Must be called before {@link #register(KeyListener) registering} any {@link KeyListener}s.
     */
    void initialize();

    /**
     * @param listener The listener to register, not {@code null}.
     */
    void register(KeyListener listener);

}
