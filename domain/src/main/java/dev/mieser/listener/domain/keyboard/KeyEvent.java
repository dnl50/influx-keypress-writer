package dev.mieser.listener.domain.keyboard;

import dev.mieser.listener.domain.KeyTransition;

import java.time.ZonedDateTime;

public record KeyEvent(KeyInfo keyInfo, KeyTransition transition, ZonedDateTime timestamp) {

}
