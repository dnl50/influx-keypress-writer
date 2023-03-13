package dev.mieser.listener.domain;

import java.time.ZonedDateTime;

public record KeyEvent(KeyInfo keyInfo, KeyEventType type, ZonedDateTime timestamp) {

}
