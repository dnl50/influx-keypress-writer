package dev.mieser.listener.hook.api.mouse;

import java.io.Closeable;

public interface MouseHookRegistry extends Closeable {

    /**
     * Initializes the underlying native library. Must be called before {@link #register(MouseListener) registering} any {@link MouseListener}s.
     */
    void initialize();

    /**
     * @param listener The listener to register, not {@code null}.
     */
    void register(MouseListener listener);

}
