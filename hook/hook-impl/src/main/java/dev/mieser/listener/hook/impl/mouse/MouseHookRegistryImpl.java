package dev.mieser.listener.hook.impl.mouse;

import dev.mieser.listener.hook.api.mouse.MouseHookRegistry;
import dev.mieser.listener.hook.api.mouse.MouseListener;
import lc.kra.system.mouse.GlobalMouseHook;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MouseHookRegistryImpl implements MouseHookRegistry {

    private final MouseEventFactory eventFactory;

    private GlobalMouseHook globalMouseHook;

    @Override
    public void initialize() {
        if (globalMouseHook != null) {
            return;
        }

        globalMouseHook = new GlobalMouseHook(false);
    }

    @Override
    public void register(MouseListener listener) {
        if (globalMouseHook == null) {
            throw new IllegalStateException("Registry is not initialized.");
        }

        globalMouseHook.addMouseListener(new MouseHookAdapter(listener, eventFactory));
    }

    @Override
    public void close() {
        if (globalMouseHook == null) {
            return;
        }

        globalMouseHook.shutdownHook();
        globalMouseHook = null;
    }

}
