package dev.mieser.listener.hook.impl.keyboard;

import dev.mieser.listener.domain.KeyTransition;
import dev.mieser.listener.domain.keyboard.KeyEvent;
import dev.mieser.listener.domain.keyboard.KeyInfo;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import lombok.RequiredArgsConstructor;

import java.time.Clock;
import java.time.ZonedDateTime;

@RequiredArgsConstructor
public class KeyInfoEventFactory {

    private final Clock clock;

    KeyEvent create(GlobalKeyEvent keyEvent) {
        return new KeyEvent(
                map(keyEvent),
                map(keyEvent.getTransitionState()),
                ZonedDateTime.now(clock)
        );
    }

    private KeyInfo map(GlobalKeyEvent keyEvent) {
        return new KeyInfo(
                keyEvent.getVirtualKeyCode(),
                keyEvent.getKeyChar(),
                keyEvent.isMenuPressed(),
                keyEvent.isShiftPressed(),
                keyEvent.isControlPressed(),
                keyEvent.isWinPressed(),
                keyEvent.isExtendedKey()
        );
    }

    private KeyTransition map(int transitionState) {
        return transitionState == GlobalKeyEvent.TS_DOWN ? KeyTransition.PRESSED : KeyTransition.RELEASED;
    }

}
