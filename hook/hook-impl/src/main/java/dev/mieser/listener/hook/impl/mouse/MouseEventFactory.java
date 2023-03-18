package dev.mieser.listener.hook.impl.mouse;

import dev.mieser.listener.domain.KeyTransition;
import dev.mieser.listener.domain.mouse.MouseButton;
import dev.mieser.listener.domain.mouse.MouseEvent;
import lc.kra.system.mouse.event.GlobalMouseEvent;
import lombok.RequiredArgsConstructor;

import java.time.Clock;
import java.time.ZonedDateTime;

@RequiredArgsConstructor
public class MouseEventFactory {

    private final Clock clock;

    MouseEvent create(GlobalMouseEvent event) {
        return new MouseEvent(
                mapButton(event),
                event.getTransitionState() == GlobalMouseEvent.TS_DOWN ? KeyTransition.PRESSED : KeyTransition.RELEASED,
                ZonedDateTime.now(clock)
        );
    }

    private MouseButton mapButton(GlobalMouseEvent event) {
        return switch (event.getButton()) {
            case GlobalMouseEvent.BUTTON_LEFT -> MouseButton.LEFT;
            case GlobalMouseEvent.BUTTON_MIDDLE -> MouseButton.MIDDLE;
            case GlobalMouseEvent.BUTTON_RIGHT -> MouseButton.RIGHT;
            case GlobalMouseEvent.BUTTON_X2 -> MouseButton.FORWARD;
            case GlobalMouseEvent.BUTTON_X1 -> MouseButton.BACKWARD;
            default ->
                    throw new IllegalStateException("Unsupported mouse button: " + Integer.toBinaryString(event.getButton()));
        };
    }

}
