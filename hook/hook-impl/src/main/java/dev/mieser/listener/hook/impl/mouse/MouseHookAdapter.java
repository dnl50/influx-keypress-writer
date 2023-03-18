package dev.mieser.listener.hook.impl.mouse;

import dev.mieser.listener.hook.api.mouse.MouseListener;
import lc.kra.system.mouse.event.GlobalMouseAdapter;
import lc.kra.system.mouse.event.GlobalMouseEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MouseHookAdapter extends GlobalMouseAdapter {

    private final MouseListener delegate;

    private final MouseEventFactory mouseEventFactory;

    @Override
    public void mousePressed(GlobalMouseEvent event) {
        notifyDelegate(event);
    }

    @Override
    public void mouseReleased(GlobalMouseEvent event) {
        notifyDelegate(event);
    }

    private void notifyDelegate(GlobalMouseEvent event) {
        try {
            delegate.onEvent(mouseEventFactory.create(event));
        } catch (Exception e) {
            log.warn("Listener threw exception.", e);
        }
    }

}
