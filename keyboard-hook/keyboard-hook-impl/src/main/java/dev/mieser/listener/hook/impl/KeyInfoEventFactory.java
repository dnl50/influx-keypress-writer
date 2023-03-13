package dev.mieser.listener.hook.impl;

import dev.mieser.listener.domain.KeyEvent;
import dev.mieser.listener.domain.KeyEventType;
import dev.mieser.listener.domain.KeyInfo;
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

    private KeyEventType map(int transitionState) {
        return transitionState == GlobalKeyEvent.TS_DOWN ? KeyEventType.PRESSED : KeyEventType.RELEASED;
    }

}
